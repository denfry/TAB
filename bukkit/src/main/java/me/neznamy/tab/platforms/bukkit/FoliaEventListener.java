package me.neznamy.tab.platforms.bukkit;

import lombok.RequiredArgsConstructor;
import me.neznamy.tab.shared.TAB;
import me.neznamy.tab.shared.platform.TabPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import io.papermc.paper.event.entity.EntityAddToWorldEvent;

/**
 * Event listener for Folia-specific events.
 */
@RequiredArgsConstructor
public class FoliaEventListener implements Listener {

    /**
     * Listens to entity add to world event (Folia support).
     *
     * @param   e
     *          Entity add to world event
     */
    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityAddToWorld(EntityAddToWorldEvent e) {
        if (e.getEntity() instanceof Player) {
            TabPlayer p = TAB.getInstance().getPlayer(e.getEntity().getUniqueId());
            if (p != null) {
                TAB.getInstance().getFeatureManager().onWorldChange(p.getUniqueId(), me.neznamy.tab.shared.data.World.byName(e.getWorld().getName()));
            }
        }
    }
}
