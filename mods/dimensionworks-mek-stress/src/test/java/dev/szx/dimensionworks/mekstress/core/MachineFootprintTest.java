package dev.szx.dimensionworks.mekstress.core;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import org.junit.jupiter.api.Test;

class MachineFootprintTest {
    @Test
    void exposesKineticCandidatesAroundEveryBoundingBlock() {
        BlockPos main = BlockPos.ZERO;
        List<BlockPos> bounding = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x != 0 || y != 0 || z != 0) {
                        bounding.add(new BlockPos(x, y, z));
                    }
                }
            }
        }

        var candidates = MachineFootprint.kineticCandidates(main, bounding);
        BlockPos farEast = new BlockPos(2, 0, 0);

        assertTrue(candidates.containsKey(farEast));
        assertTrue(candidates.get(farEast).contains(Direction.EAST));
        assertFalse(candidates.containsKey(new BlockPos(1, 0, 0)));
        assertTrue(candidates.containsKey(new BlockPos(0, 2, 0)));
    }
}
