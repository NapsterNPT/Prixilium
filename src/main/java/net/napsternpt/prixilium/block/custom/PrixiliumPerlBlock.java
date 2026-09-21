package net.napsternpt.prixilium.block.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.particle.TrailParticleEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.napsternpt.prixilium.block.ModBlocks;
import net.napsternpt.prixilium.effect.ModEffects;
import net.napsternpt.prixilium.util.ModTags;

public class PrixiliumPerlBlock extends FlowerBlock {
    public static final MapCodec<PrixiliumPerlBlock> CODEC = RecordCodecBuilder.mapCodec((instance) ->
            instance.group(Codec.BOOL.fieldOf("open").forGetter((block) ->
                    block.state.open), createSettingsCodec()).apply(instance, PrixiliumPerlBlock::new));
    private final PrixiliumPerlBlock.PrixiliumPerlState state;

    public MapCodec<? extends PrixiliumPerlBlock> getCodec() {
        return CODEC;
    }

    public PrixiliumPerlBlock(PrixiliumPerlBlock.PrixiliumPerlState state, AbstractBlock.Settings settings) {
        super(state.stewEffect, state.effectLengthInSeconds, settings);
        this.state = state;
    }

    public PrixiliumPerlBlock(boolean open, AbstractBlock.Settings settings) {
        super(PrixiliumPerlBlock.PrixiliumPerlState.of(open).stewEffect, PrixiliumPerlBlock.PrixiliumPerlState.of(open).effectLengthInSeconds, settings);
        this.state = PrixiliumPerlBlock.PrixiliumPerlState.of(open);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (this.state.isOpen() && random.nextInt(700) == 0) {
            BlockState blockState = world.getBlockState(pos.down());
            if (blockState.isOf(ModBlocks.PRIXILIUM_GRASS)) {
                world.playSoundClient(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_EYEBLOSSOM_IDLE, SoundCategory.AMBIENT, 1.0F, 1.0F, false);
            }
        }

    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.updateStateAndNotifyOthers(state, world, pos, random)) {
            world.playSound(null, pos, this.state.getOpposite().longSound, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        super.randomTick(state, world, pos, random);
    }

    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.updateStateAndNotifyOthers(state, world, pos, random)) {
            world.playSound(null, pos, this.state.getOpposite().sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        super.scheduledTick(state, world, pos, random);
    }

    private boolean updateStateAndNotifyOthers(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        boolean bl = world.getBiome(pos).isIn(ModTags.Biomes.OPENS_PRIXILIUM_PERL);
        if (bl == this.state.open) {
            return false;
        } else {
            PrixiliumPerlBlock.PrixiliumPerlState PrixiliumPerlState = this.state.getOpposite();
            world.setBlockState(pos, PrixiliumPerlState.getBlockState(), 3);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
            PrixiliumPerlState.spawnTrailParticle(world, pos, random);
            BlockPos.iterate(pos.add(-3, -2, -3), pos.add(3, 2, 3)).forEach((otherPos) -> {
                BlockState blockState2 = world.getBlockState(otherPos);
                if (blockState2 == state) {
                    double d = Math.sqrt(pos.getSquaredDistance(otherPos));
                    int i = random.nextBetween((int)(d * (double)5.0F), (int)(d * (double)10.0F));
                    world.scheduleBlockTick(otherPos, state.getBlock(), i);
                }

            });
            return true;
        }
    }

    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
        if (!world.isClient() && world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof BeeEntity beeEntity) {
            if (BeeEntity.isAttractive(state) && !beeEntity.hasStatusEffect(StatusEffects.POISON)) {
                beeEntity.addStatusEffect(this.getContactEffect());
            }
        }

    }

    public StatusEffectInstance getContactEffect() {
        return new StatusEffectInstance(StatusEffects.POISON, 25);
    }

    public enum PrixiliumPerlState {
        OPEN(true, ModEffects.PRIXILIUM_SLOWNESS, 11.0F, SoundEvents.BLOCK_EYEBLOSSOM_OPEN_LONG, SoundEvents.BLOCK_EYEBLOSSOM_OPEN, 0xffcb00),
        CLOSED(false, ModEffects.PRIXILIUM_IMMUNITY, 7.0F, SoundEvents.BLOCK_EYEBLOSSOM_CLOSE_LONG, SoundEvents.BLOCK_EYEBLOSSOM_CLOSE, 0xf7f1d8);

        final boolean open;
        final RegistryEntry<StatusEffect> stewEffect;
        final float effectLengthInSeconds;
        final SoundEvent longSound;
        final SoundEvent sound;
        private final int particleColor;

        PrixiliumPerlState(final boolean open, final RegistryEntry<StatusEffect> stewEffect, final float effectLengthInSeconds, final SoundEvent longSound, final SoundEvent sound, final int particleColor) {
            this.open = open;
            this.stewEffect = stewEffect;
            this.effectLengthInSeconds = effectLengthInSeconds;
            this.longSound = longSound;
            this.sound = sound;
            this.particleColor = particleColor;
        }

        public Block getBlock() {
            return this.open ? ModBlocks.OPEN_PRIXILIUM_PERL : ModBlocks.CLOSED_PRIXILIUM_PERL;
        }

        public BlockState getBlockState() {
            return this.getBlock().getDefaultState();
        }

        public PrixiliumPerlBlock.PrixiliumPerlState getOpposite() {
            return of(!this.open);
        }

        public boolean isOpen() {
            return this.open;
        }

        public static PrixiliumPerlBlock.PrixiliumPerlState of(boolean open) {
            return open ? OPEN : CLOSED;
        }

        public void spawnTrailParticle(ServerWorld world, BlockPos pos, Random random) {
            Vec3d vec3d = pos.toCenterPos();
            double d = (double)0.5F + random.nextDouble();
            Vec3d vec3d2 = new Vec3d(random.nextDouble() - (double)0.5F, random.nextDouble() + (double)1.0F, random.nextDouble() - (double)0.5F);
            Vec3d vec3d3 = vec3d.add(vec3d2.multiply(d));
            TrailParticleEffect trailParticleEffect = new TrailParticleEffect(vec3d3, this.particleColor, (int)((double)20.0F * d));
            world.spawnParticles(trailParticleEffect, vec3d.x, vec3d.y, vec3d.z, 1, 0.0F, 0.0F, 0.0F, 0.0F);
        }
    }
}
