package dev.szx.dimensionworks.maidaecrank;

import com.github.tartaricacid.touhoulittlemaid.api.ILittleMaid;
import com.github.tartaricacid.touhoulittlemaid.api.LittleMaidExtension;
import com.github.tartaricacid.touhoulittlemaid.entity.task.TaskManager;

@LittleMaidExtension
public final class MaidAE2CrankExtension implements ILittleMaid {
    public MaidAE2CrankExtension() {
    }

    @Override
    public void addMaidTask(TaskManager manager) {
        manager.add(new MaidAE2CrankTask());
    }
}
