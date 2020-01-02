package world.bentobox.bentobox.panels.manager.providers;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.eclipse.jdt.annotation.NonNull;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.inventory.content.BentoBoxInventoryProvider;
import world.bentobox.bentobox.api.user.User;

public class BaseInventoryProvider implements BentoBoxInventoryProvider {
    @Override
    public void init(@NonNull BentoBox plugin, @NonNull User user, @NonNull InventoryContents contents) {
        // Borders
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE)));
    }
}
