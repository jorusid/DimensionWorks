package dev.szx.dimensionworks.mekstress.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

/** Expands a Mekanism bounding footprint into the kinetic blocks touching its outer surface. */
public final class MachineFootprint {
    private MachineFootprint() {
    }

    public static Map<BlockPos, List<Direction>> kineticCandidates(BlockPos mainPos,
                                                                    Iterable<BlockPos> boundingPositions) {
        Set<BlockPos> occupied = new LinkedHashSet<>();
        occupied.add(mainPos.immutable());
        for (BlockPos position : boundingPositions) {
            occupied.add(position.immutable());
        }

        Map<BlockPos, List<Direction>> candidates = new LinkedHashMap<>();
        for (BlockPos occupiedPos : occupied) {
            for (Direction direction : Direction.values()) {
                BlockPos candidate = occupiedPos.relative(direction).immutable();
                if (occupied.contains(candidate)) {
                    continue;
                }
                candidates.computeIfAbsent(candidate, ignored -> new ArrayList<>()).add(direction);
            }
        }

        Map<BlockPos, List<Direction>> immutable = new LinkedHashMap<>();
        candidates.forEach((position, directions) ->
            immutable.put(position, Collections.unmodifiableList(List.copyOf(directions))));
        return Collections.unmodifiableMap(immutable);
    }
}
