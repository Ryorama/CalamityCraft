package com.ryorama.calamitycraft.common.content.invasions.types;

import net.minecraftforge.fml.common.registry.EntityEntry;
import org.jetbrains.annotations.NotNull;
import org.zeith.terraria.api.client.music.MusicMood;
import org.zeith.terraria.api.tags.TagKey;
import org.zeith.terraria.api.world.invasion.InvasionType;
import org.zeith.terraria.common.content.biome.api.IBiomeEntityEntry;
import org.zeith.terraria.common.data.player.PlayerDataTC;
import org.zeith.terraria.common.data.world.world.WorldDataTC;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class InvasionTypeAcidRain extends InvasionType {
    public InvasionTypeAcidRain(@NotNull ToIntFunction<WorldDataTC> totalPoints, @NotNull Predicate<PlayerDataTC> isActiveAround, @NotNull TagKey<EntityEntry> invasionEntities, Consumer<WorldDataTC> onInvasionEnd, MusicMood musicOverride, List<IBiomeEntityEntry<?>> entities, int chatColor) {
        super(totalPoints, isActiveAround, invasionEntities, onInvasionEnd, musicOverride, entities, chatColor);
    }

    @Override
    public boolean enqueue(WorldDataTC world, int startCooldown) {
        System.out.println("ENq");
        if (!world.invasions().enqueueInvasion(this, startCooldown, this.getArriveMessage(world))) {
            return false;
        } else {
            return true;
        }
    }
}
