package net.fortresswars.events.kits.engineer;

import net.fortresswars.core.entities.FortressWarsPlayer;
import org.bukkit.block.Block;

public class EngineerWrenchInteractRepairEvent extends EngineerWrenchInteractEvent {

    private int repairAmount;
    private int metalAmount;

    public EngineerWrenchInteractRepairEvent(FortressWarsPlayer player, Block block, int repairAmount, int metalAmount) {
        super(player, block);
        this.repairAmount = repairAmount;
        this.metalAmount = metalAmount;
    }

    public int getRepairAmount() {
        return repairAmount;
    }

    public void setRepairAmount(int repairAmount) {
        this.repairAmount = repairAmount;
    }

    public int getMetalAmount() {
        return metalAmount;
    }

    public void setMetalAmount(int metalAmount) {
        this.metalAmount = metalAmount;
    }
}
