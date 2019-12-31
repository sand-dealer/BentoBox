package world.bentobox.bentobox.api.inventory.item;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import world.bentobox.bentobox.api.user.User;

import java.util.stream.Collectors;

public class PremadeItem {

    private ItemStack item;

    private PremadeItem(ItemStack item) {
        this.item = item;
    }

    public static PremadeItem of(ItemStack item) {
        return new PremadeItem(item);
    }

    public ItemStack to(User user) {
        // Get the meta
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            // Set flags to neaten up the view
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_DESTROYS);
            meta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            item.setItemMeta(meta);

            // Set name
            String name = user.getTranslation(meta.getLocalizedName());
            meta.setDisplayName(name);
            meta.setLocalizedName(name); //Localized name cannot be overridden by the player using an anvils

            // Set description
            meta.setLore(meta.getLore().stream().map(line -> user.getTranslation(line)).collect(Collectors.toList()));
        }
        return item;
    }
}
