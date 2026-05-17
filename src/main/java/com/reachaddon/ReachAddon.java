package com.reachaddon;

import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;

public class ReachAddon {
    public static final String MOD_ID = "reachaddon";

    public static void init() {
        Modules.get().add(new BlockReach());
    }
}
