package teamrazor.aeroblender.mixin;

import com.google.common.collect.Maps;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import teamrazor.aeroblender.aether.AetherRegionType;
import teamrazor.aeroblender.aether.AetherRuleCategory;
import teamrazor.aeroblender.aether.AetherSurfaceRuleData;
import terrablender.api.SurfaceRuleManager;
import terrablender.worldgen.TBSurfaceRuleData;

import java.util.Map;

@Mixin(value = SurfaceRuleManager.class, remap = false)
public class SurfaceRuleManagerMixin {

    @Shadow
    private static Map<SurfaceRuleManager.RuleCategory, SurfaceRules.RuleSource> defaultSurfaceRules;


    @Inject(method = "getDefaultSurfaceRules", at = @At("HEAD"), cancellable = true)
    private static void getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory category, CallbackInfoReturnable<SurfaceRules.RuleSource> cir) {
        if (defaultSurfaceRules.containsKey(category)) {
            cir.setReturnValue(defaultSurfaceRules.get(category));
        } else if (category == AetherRuleCategory.THE_AETHER) {
            cir.setReturnValue(AetherSurfaceRuleData.aether());
        }
    }
}
