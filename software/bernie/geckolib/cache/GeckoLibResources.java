package software.bernie.geckolib.cache;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.loading.json.ModelFormatVersion;
import software.bernie.geckolib.loading.json.raw.Model;
import software.bernie.geckolib.loading.json.typeadapter.BakedAnimationsAdapter;
import software.bernie.geckolib.loading.json.typeadapter.KeyFramesAdapter;
import software.bernie.geckolib.loading.object.BakedAnimations;
import software.bernie.geckolib.loading.object.BakedModelFactory;
import software.bernie.geckolib.loading.object.GeometryTree;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.object.CompoundException;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.minecraft.class_2960;
import net.minecraft.class_3298;
import net.minecraft.class_3300;
import net.minecraft.class_3302.class_4045;
import net.minecraft.class_3518;

/**
 * Cache class for holding loaded {@link Animation Animations}
 * and {@link GeoModel Models}
 */
public final class GeckoLibResources {
	public static final class_2960 RELOAD_LISTENER_ID = GeckoLibConstants.id("geckolib_resources");
	public static final class_2960 ANIMATIONS_PATH = GeckoLibConstants.id("geckolib/animations");
	public static final class_2960 MODELS_PATH = GeckoLibConstants.id("geckolib/models");
	public static final Pattern SUFFIX_STRIPPER = Pattern.compile("((\\.geo)|((\\.animation)s?))?(\\.json)$");
	public static final Pattern PREFIX_STRIPPER = Pattern.compile("^(geckolib/)((animations/)|(models/))?");

	private static Map<class_2960, BakedAnimations> ANIMATIONS = Collections.emptyMap();
	private static Map<class_2960, BakedGeoModel> MODELS = Collections.emptyMap();

	/**
	 * Get GeckoLib's cache of all the loaded animations from the {@link #ANIMATIONS_PATH}
	 */
	public static Map<class_2960, BakedAnimations> getBakedAnimations() {
		return ANIMATIONS;
	}

	/**
	 * Get GeckoLib's cache of all the loaded geo models from the {@link #MODELS_PATH}
	 */
	public static Map<class_2960, BakedGeoModel> getBakedModels() {
		return MODELS;
	}

	@ApiStatus.Internal
	public static CompletableFuture<Void> reload(class_4045 stage, class_3300 resourceManager, Executor backgroundExecutor, Executor gameExecutor) {
		CompletableFuture<Map<class_2960, BakedAnimations>> animations = loadAnimations(backgroundExecutor, resourceManager);
		CompletableFuture<Map<class_2960, BakedGeoModel>> models = loadModels(backgroundExecutor, resourceManager);

		return CompletableFuture.runAsync(() -> BakedAnimationsAdapter.COMPRESSION_CACHE = new ConcurrentHashMap<>(), backgroundExecutor)
				.thenCompose(ignored -> CompletableFuture.allOf(animations, models).thenCompose(stage::method_18352).thenRunAsync(() -> {
					GeckoLibResources.ANIMATIONS = animations.join();
					GeckoLibResources.MODELS = models.join();
					BakedAnimationsAdapter.COMPRESSION_CACHE = null;
				}, gameExecutor));
	}

	/**
	 * Strip the asset prefix and suffix from the given filepath, returning the stripped location
	 *
	 * @return The stripped location, or the original path if no match is found
	 */
	public static class_2960 stripPrefixAndSuffix(class_2960 path) {
		String newPath = path.method_12832();
		Matcher prefixMatcher = PREFIX_STRIPPER.matcher(newPath);
		newPath = prefixMatcher.find() ? newPath.substring(prefixMatcher.end()) : newPath;
		Matcher suffixMatcher = SUFFIX_STRIPPER.matcher(newPath);
		newPath = suffixMatcher.find() ? newPath.substring(0, suffixMatcher.start()) : newPath;

		return newPath.length() == path.method_12832().length() ? path : path.method_45136(newPath);
	}

	/**
	 * Provide a {@link Future} for retrieving and baking all animation jsons from the {@link #ANIMATIONS_PATH}
	 */
	private static CompletableFuture<Map<class_2960, BakedAnimations>> loadAnimations(Executor backgroundExecutor, class_3300 resourceManager) {
		return bakeJsonResources(backgroundExecutor, resourceManager, ANIMATIONS_PATH.method_12832(), GeckoLibResources::bakeAnimations,
								 ex -> new BakedAnimations(new Object2ObjectOpenHashMap<>()));
	}

	/**
	 * Provide a {@link Future} for retrieving and baking all geo model jsons from the {@link #MODELS_PATH}
	 */
	private static CompletableFuture<Map<class_2960, BakedGeoModel>> loadModels(Executor backgroundExecutor, class_3300 resourceManager) {
		return bakeJsonResources(backgroundExecutor, resourceManager, MODELS_PATH.method_12832(), GeckoLibResources::bakeModel,
								 ex -> null);
	}

	/**
	 * Retrieve all asset JSON files from a given location, then bake them into their final form.
	 * <p>
	 * Automatically handles sequentially managed file I/O and parallelized task deployment
	 */
	private static <BAKED> CompletableFuture<Map<class_2960, BAKED>> bakeJsonResources(Executor backgroundExecutor, class_3300 resourceManager, String assetPath,
																							 BiFunction<class_2960, JsonObject, BAKED> elementFactory, Function<Throwable, BAKED> exceptionalFactory) {


		return loadResources(backgroundExecutor, resourceManager, assetPath, "json", GeckoLibResources::readJsonFile)
				.thenCompose(resources -> {
					List<CompletableFuture<Pair<class_2960, BAKED>>> tasks = new ObjectArrayList<>(resources.size());

					resources.forEach(pair -> tasks.add(CompletableFuture.supplyAsync(() -> Pair.of(stripPrefixAndSuffix(pair.left()), elementFactory.apply(pair.left(), pair.right())), backgroundExecutor)
																.exceptionally(ex -> {
																	ex.printStackTrace();

																	return Pair.of(pair.left(), exceptionalFactory.apply(ex));
																})));

					return CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]))
							.thenApply(ignored -> tasks.stream().map(CompletableFuture::join).filter(Objects::nonNull).collect(Collectors.toMap(Pair::left, Pair::right)));
				});
	}

	/**
	 * Load a set of resources from their respective files for all available namespaces, into their raw/unbaked format ready for further processing.
	 * <p>
	 * This step is separated to prevent parallelized file I/O
	 */
	private static <UNBAKED> CompletableFuture<List<Pair<class_2960, UNBAKED>>> loadResources(Executor executor, class_3300 resourceManager, String assetPath, String fileType, BiFunction<class_2960, class_3298, UNBAKED> elementFactory) {
		final String fileTypeSuffix = "." + fileType;

		return CompletableFuture.supplyAsync(() -> resourceManager.method_14488(assetPath, fileName -> fileName.method_12832().endsWith(fileTypeSuffix)), executor)
				.thenCompose(resources -> {
					List<CompletableFuture<Pair<class_2960, UNBAKED>>> tasks = new ObjectArrayList<>(resources.size());

					resources.forEach((path, resource) -> tasks.add(CompletableFuture.supplyAsync(() -> Pair.of(path, elementFactory.apply(path, resource)), executor)));

					return CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).thenApply(ignored -> tasks.stream().map(CompletableFuture::join).filter(Objects::nonNull).toList());
				});
	}

	/**
	 * Bake a {@link BakedGeoModel} from its {@link JsonObject} serialized form
	 */
	@NotNull
	private static BakedGeoModel bakeModel(class_2960 path, JsonObject json) {
		if (path.method_12832().endsWith(".animation.json"))
			throw new RuntimeException("Found animation file found in models folder! '" + path + "'");

		Model model = KeyFramesAdapter.GEO_GSON.fromJson(json, Model.class);
		ModelFormatVersion matchedVersion = ModelFormatVersion.match(model.formatVersion());

		if (matchedVersion == null) {
            GeckoLibConstants.LOGGER.warn("{}: Unknown geo model format version: '{}'. This may not work correctly", path, model.formatVersion());
		}
		else if (!matchedVersion.isSupported()) {
            GeckoLibConstants.LOGGER.error("{}: Unsupported geo model format version: '{}'. {}", path, model.formatVersion(), matchedVersion.getErrorMessage());
		}

		return BakedModelFactory.getForNamespace(path.method_12836()).constructGeoModel(GeometryTree.fromModel(model));
	}

	/**
	 * Bake the {@link BakedAnimations} from a {@link JsonObject} serialized form
	 */
	@NotNull
	private static BakedAnimations bakeAnimations(class_2960 path, JsonObject json) {
		if (path.method_12832().endsWith(".geo.json"))
			throw new RuntimeException("Found model file in animations folder! '" + path + "'");

		try {
			return KeyFramesAdapter.GEO_GSON.fromJson(class_3518.method_15296(json, "animations"), BakedAnimations.class);
		}
		catch (CompoundException ex) {
			throw ex.withMessage(path + ": Error building animations from JSON");
		}
		catch (Exception ex) {
			throw GeckoLibConstants.exception(path, "Error building animations from JSON", ex);
		}
	}

	/**
	 * Read a single resource into its {@link JsonObject} form
	 */
	private static JsonObject readJsonFile(class_2960 id, class_3298 resource) {
		try (Reader reader = resource.method_43039()) {
			return class_3518.method_15255(reader);
		}
		catch (IOException ex) {
			throw GeckoLibConstants.exception(id, "Error reading JSON file", ex);
		}
	}
}
