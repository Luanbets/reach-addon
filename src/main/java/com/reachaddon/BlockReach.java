package com.reachaddon;

import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.DoubleSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;

public class BlockReach extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> extraBlockReach = sgGeneral.add(new DoubleSetting.Builder()
        .name("extra-block-reach")
        .description("Extra block interaction range.")
        .defaultValue(3.0)
        .min(0)
        .max(8)
        .sliderRange(0, 8)
        .build()
    );

    private final Setting<Boolean> entityReach = sgGeneral.add(new BoolSetting.Builder()
        .name("entity-reach")
        .description("Enable entity reach extension.")
        .defaultValue(false)
        .build()
    );

    private final Setting<Double> extraEntityReach = sgGeneral.add(new DoubleSetting.Builder()
        .name("extra-entity-reach")
        .description("Extra entity attack range.")
        .defaultValue(2.0)
        .min(0)
        .max(6)
        .sliderRange(0, 6)
        .visible(entityReach::get)
        .build()
    );

    public BlockReach() {
        super(Category.Combat, "block-reach", "Extends block and entity reach.");
    }

    public static BlockReach get() {
        return Modules.get().get(BlockReach.class);
    }

    public double getExtraBlockReach() {
        return isActive() ? extraBlockReach.get() : 0;
    }

    public boolean isEntityReachEnabled() {
        return isActive() && entityReach.get();
    }

    public double getExtraEntityReach() {
        return isActive() && entityReach.get() ? extraEntityReach.get() : 0;
    }
}
