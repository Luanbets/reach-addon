package com.reachaddon.mixin;

import com.reachaddon.BlockReach;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @ModifyConstant(method = "pick", constant = @Constant(floatValue = 3.0f, ordinal = 0))
    private float modifyBlockReach(float constant) {
        return constant + (float) BlockReach.get().getExtraBlockReach();
    }

    @ModifyConstant(method = "pick", constant = @Constant(floatValue = 9.0f))
    private float modifyBlockReachSquared(float constant) {
        float extra = (float) BlockReach.get().getExtraBlockReach();
        float base = 3.0f + extra;
        return base * base;
    }
}
