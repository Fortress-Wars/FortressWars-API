package net.fortresswars.core.entities;

import net.fortresswars.core.kits.Kit;
import net.fortresswars.core.kits.KitDataContainer;
import net.fortresswars.core.kits.KitID;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public interface FortressWarsPlayer extends FortressWarsLivingEntity {

    Player getPlayer();

    void setPlayer(Player player);

    Kit getKit();

    void setKit(Kit kit);

    KitID getKitID();

    KitDataContainer getKitDataOverrides();

    void resetGear();

    void setKitToChangeTo();

    KitID getKitToChangeTo();

    void stopQuitTimer();

    void setQuitTimer(BukkitTask quitTimer);

    boolean isUsingTeamChat();

    void setUsingTeamChat(boolean usingTeamChat);

    void setKitTransferPotions();

    int getKitTransferPotions();


}
