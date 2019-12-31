package world.bentobox.bentobox.api.inventory.content;

import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.entity.Player;
import org.eclipse.jdt.annotation.NonNull;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.user.User;

/**
 * @author Poslovitch
 * @since 1.10.0
 */
public interface BentoBoxInventoryProvider extends InventoryProvider {

    void init(@NonNull BentoBox plugin, @NonNull User user, @NonNull InventoryContents contents);
    default void update(@NonNull BentoBox plugin, @NonNull User user, @NonNull InventoryContents contents) {}

    @Override
    default void init(Player player, InventoryContents contents) {
        init(BentoBox.getInstance(), User.getInstance(player), contents);
    }

    @Override
    default void update(Player player, InventoryContents contents) {
        update(BentoBox.getInstance(), User.getInstance(player), contents);
    }
}
