package dev.szx.dimensionworks.rpmlimit.optimizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class KineticNetworkOptimizerTest {

    @Test
    void deltaUpdatesPreserveTheRecomputedTotal() {
        List<Float> values = new ArrayList<>();
        float cached = 0.0F;
        for (int i = 0; i < 5000; i++) {
            float value = (i % 31) * 0.25F;
            values.add(value);
            cached += value;
        }

        for (int i = 0; i < values.size(); i++) {
            float previous = values.get(i);
            float replacement = ((i * 7) % 47) * 0.125F;
            values.set(i, replacement);
            cached = KineticNetworkOptimizer.applyDelta(cached, previous, replacement);
        }

        float recomputed = 0.0F;
        for (float value : values) {
            recomputed += value;
        }

        assertEquals(recomputed, cached, 0.1F);
    }

    @Test
    void abortBatchClearsLeakedThreadState() {
        KineticNetworkOptimizer.beginBatch();
        KineticNetworkOptimizer.abortBatch();

        assertFalse(KineticNetworkOptimizer.isBatching());
    }
}
