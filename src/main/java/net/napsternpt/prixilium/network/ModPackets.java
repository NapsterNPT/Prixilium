package net.napsternpt.prixilium.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import net.napsternpt.prixilium.Prixilium;
import net.napsternpt.prixilium.block.custom.PrixiversePortalBlock;
import net.napsternpt.prixilium.screen.PrixiverseCreditsScreen;

import java.util.Objects;

public class ModPackets {

    public record ShowCreditsPayload() implements CustomPayload {
        public static final Id<ShowCreditsPayload> ID = new Id<>(
                Identifier.of(Prixilium.MOD_ID, "show_credits")
        );
        public static final PacketCodec<PacketByteBuf, ShowCreditsPayload> CODEC =
                PacketCodec.unit(new ShowCreditsPayload());

        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }

    public static void registerServer() {
        PayloadTypeRegistry.playS2C().register(ShowCreditsPayload.ID, ShowCreditsPayload.CODEC);
    }

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(ShowCreditsPayload.ID, (payload, context) ->
                context.client().execute(() -> {
                    String playerName = Objects.requireNonNull(context.client().player).getName().getString();
                    context.client().setScreen(new PrixiverseCreditsScreen(playerName, () -> ClientPlayNetworking.send(new ReturnToOverworldPayload())));
                })
        );
    }

    public static void sendShowCredits(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, new ShowCreditsPayload());
    }

    public record ReturnToOverworldPayload() implements CustomPayload {
        public static final Id<ReturnToOverworldPayload> ID = new Id<>(Identifier.of(Prixilium.MOD_ID, "return_overworld"));
        public static final PacketCodec<PacketByteBuf, ReturnToOverworldPayload> CODEC =
                PacketCodec.unit(new ReturnToOverworldPayload());

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }

    public static void registerReturnHandler() {
        PayloadTypeRegistry.playC2S().register(ReturnToOverworldPayload.ID, ReturnToOverworldPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(ReturnToOverworldPayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            context.server().execute(() -> {
                var overworld = context.server().getWorld(World.OVERWORLD);
                if (overworld != null) player.teleportTo(player.getRespawnTarget(true, TeleportTarget.NO_OP));
                PrixiversePortalBlock.markCreditsFinished(player);
            });
        });
    }
}