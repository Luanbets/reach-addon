package com.reachaddon.mixin;

import com.reachaddon.BlockReach;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public abstract class ReachMixin {

    @Inject(method = "getPickRange", at = @At("RETURN"), cancellable = true)
    private void onGetPickRange(CallbackInfoReturnable<Float> cir) {
        float extra = (float) BlockReach.get().getExtraBlockReach();
        cir.setReturnValue(cir.getReturnValue() + extra);
    }

    @Inject(method = "hasFarPickRange", at = @At("RETURN"), cancellable = true)
    private void onHasFarPickRange(CallbackInfoReturnable<Boolean> cir) {
        if (BlockReach.get().getExtraBlockReach() > 0) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getAttackRange", at = @At("RETURN"), cancellable = true)
    private void onGetAttackRange(CallbackInfoReturnable<Float> cir) {
        if (BlockReach.get().isEntityReachEnabled()) {
            float extra = (float) BlockReach.get().getExtraEntityReach();
            cir.setReturnValue(cir.getReturnValue() + extra);
        }
    }
}
