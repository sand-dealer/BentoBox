package world.bentobox.bentobox.panels.language;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.content.InventoryContents;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import org.eclipse.jdt.annotation.NonNull;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.inventory.content.BentoBoxInventoryProvider;
import world.bentobox.bentobox.api.localization.BentoBoxLocale;
import world.bentobox.bentobox.api.localization.TextVariables;
import world.bentobox.bentobox.api.panels.builders.PanelItemBuilder;
import world.bentobox.bentobox.api.user.User;

import java.util.Locale;

/**
 * @author Poslovitch
 */
public class LanguageInventoryProvider implements BentoBoxInventoryProvider {

    @Override
    public void init(@NonNull BentoBox plugin, @NonNull User user, @NonNull InventoryContents contents) {
        plugin.getLocalesManager().getAvailableLocales(true)
                .forEach(locale -> contents.add(ClickableItem.of(getItem(user, locale), e -> {
                    BentoBox.getInstance().getPlayers().setLocale(user.getUniqueId(), locale.toLanguageTag());
                    user.sendMessage("language.edited", "[lang]", WordUtils.capitalize(locale.getDisplayName(user.getLocale())));
                    contents.inventory().open(user.getPlayer());
                })));
    }

    private ItemStack getItem(@NonNull User user, Locale locale) {
        PanelItemBuilder localeIcon = new PanelItemBuilder();
        BentoBoxLocale language = BentoBox.getInstance().getLocalesManager().getLanguages().get(locale);
        if (language.getBanner() != null) {
            localeIcon.icon(language.getBanner());
        } else {
            localeIcon.icon(new ItemStack(Material.WHITE_BANNER, 1)); // Set to a blank banner.
        }
        localeIcon.name(ChatColor.WHITE + WordUtils.capitalize(locale.getDisplayName(user.getLocale())));
        if (user.getLocale().equals(locale)) {
            localeIcon.description(user.getTranslation("language.description.selected"), "");
        } else {
            localeIcon.description(user.getTranslation("language.description.click-to-select"), "");
        }

        localeIcon.description(user.getTranslation("language.description.authors"));
        for (String author : language.getAuthors()) {
            localeIcon.description(user.getTranslation("language.description.author", TextVariables.NAME, author));
        }

        return localeIcon.build().getItem();
    }
}
