package dev.szx.dimensionworks.mekstress.memory;

import com.simibubi.create.content.kinetics.KineticNetwork;
import dev.szx.dimensionworks.mekstress.core.MachinePowerMath;
import dev.szx.dimensionworks.rpmlimit.optimizer.KineticNetworkOptimizer;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import mekanism.common.tile.base.TileEntityMekanism;

/** Maintains one virtual Create kinetic member for each powered Mekanism machine. */
public final class MachineKineticRegistry {
    private static final Map<TileEntityMekanism, MachineKineticMember> MEMBERS =
        Collections.synchronizedMap(new WeakHashMap<>());

    private MachineKineticRegistry() {
    }

    public static void sync(TileEntityMekanism machine, KineticNetwork network, float memberRpm) {
        if (network == null) {
            detach(machine);
            return;
        }

        float rpm = Float.isFinite(memberRpm) ? Math.max(0.0F, memberRpm) : 0.0F;
        synchronized (MEMBERS) {
            MachineKineticMember member = MEMBERS.computeIfAbsent(machine, MachineKineticMember::new);
            KineticNetwork previous = member.dimensionworks$boundNetwork();
            float previousRpm = member.getTheoreticalSpeed();
            boolean wasAttached = network.members.containsKey(member);
            member.setSpeed(rpm);

            if (previous != network) {
                if (previous != null) {
                    KineticNetworkOptimizer.invalidate(previous);
                    previous.members.remove(member);
                }
                member.dimensionworks$bindNetwork(network);
            }
            if (previous != network || !wasAttached) {
                KineticNetworkOptimizer.invalidate(network);
                network.members.put(member, MachinePowerMath.stressPerRpm(1.0F));
            }

            if (previous != null && previous != network) {
                KineticNetworkOptimizer.invalidate(previous);
                previous.updateNetwork();
            }
            if (previous != network || !wasAttached || Float.compare(previousRpm, rpm) != 0) {
                KineticNetworkOptimizer.invalidate(network);
                network.updateNetwork();
            }
        }
    }

    public static void detach(TileEntityMekanism machine) {
        synchronized (MEMBERS) {
            MachineKineticMember member = MEMBERS.remove(machine);
            if (member == null) {
                return;
            }
            KineticNetwork network = member.dimensionworks$boundNetwork();
            member.dimensionworks$unbindNetwork();
            if (network != null) {
                KineticNetworkOptimizer.invalidate(network);
                network.members.remove(member);
                network.updateNetwork();
            }
        }
    }
}
