package dev.szx.dimensionworks.mekstress.mixin.mek;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import mekanism.common.tile.base.TileEntityMekanism;
import org.junit.jupiter.api.Test;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

class TileEntityMekanismMixinTest {
    @Test
    void everyInjectionTargetsADeclaredMekanismMethod() {
        for (Method handler : TileEntityMekanismMixin.class.getDeclaredMethods()) {
            Inject inject = handler.getAnnotation(Inject.class);
            if (inject == null) {
                continue;
            }

            assertTrue(inject.method().length > 0, () -> "Mixin target must not be empty: " + handler.getName());
            for (String target : inject.method()) {
                assertDoesNotThrow(
                    () -> TileEntityMekanism.class.getDeclaredMethod(target),
                    () -> "Mixin target must be declared by TileEntityMekanism: " + target
                );
            }
        }
    }

    @Test
    void wrapsTheFullServerUpdateCallWithTheProductionContext() {
        boolean found = false;
        for (Method handler : TileEntityMekanismMixin.class.getDeclaredMethods()) {
            Redirect redirect = handler.getAnnotation(Redirect.class);
            if (redirect == null) {
                continue;
            }
            if (redirect.method().length == 1 && "tickServer".equals(redirect.method()[0])) {
                found = true;
                assertTrue(Modifier.isStatic(handler.getModifiers()));
            }
        }
        assertTrue(found, "tickServer must be wrapped at the onUpdateServer call site");
    }

    @Test
    void removesVirtualMembersWhenTheMachineIsRemovedOrUnloaded() {
        boolean found = false;
        for (Method handler : TileEntityMekanismMixin.class.getDeclaredMethods()) {
            Inject inject = handler.getAnnotation(Inject.class);
            if (inject == null) {
                continue;
            }
            for (String target : inject.method()) {
                if ("setRemoved".equals(target)) {
                    found = true;
                }
            }
        }
        assertTrue(found, "setRemoved must detach the machine's virtual kinetic member");
    }
}
