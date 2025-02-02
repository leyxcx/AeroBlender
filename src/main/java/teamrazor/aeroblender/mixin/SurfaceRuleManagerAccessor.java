package teamrazor.aeroblender.mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import terrablender.api.SurfaceRuleManager;

import java.util.Map;

@Mixin(SurfaceRuleManager.class)
public interface SurfaceRuleManagerAccessor {
    @Accessor
    static Map<SurfaceRuleManager.RuleCategory, Map<String, SurfaceRules.RuleSource>> getSurfaceRules() {
        throw new UnsupportedOperationException();
    }

    @Accessor
    static Map<SurfaceRuleManager.RuleCategory, SurfaceRules.RuleSource> getDefaultSurfaceRules() {
        throw new UnsupportedOperationException();
    }
}
