package world.bentobox.bentobox.panels.manager;

import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryProvider;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.user.User;
import world.bentobox.bentobox.panels.manager.providers.AddonsInventoryProvider;
import world.bentobox.bentobox.panels.manager.providers.GamemodesInventoryProvider;
import world.bentobox.bentobox.panels.manager.providers.HooksInventoryProvider;

public class ManagementPanel {

    protected static final String LOCALE_REF = "management.panel.";

    public static void open(User user, View view) {
        InventoryProvider provider;
        switch (view) {
            case ADDONS:
                provider = new AddonsInventoryProvider();
                break;
            case HOOKS:
                provider = new HooksInventoryProvider();
                break;
            case GAMEMODES:
            default:
                provider = new GamemodesInventoryProvider();
                break;
        }

        SmartInventory.builder()
                .title(user.getTranslation(LOCALE_REF + "title"))
                .manager(BentoBox.getInstance().getInventoryManager())
                .provider(provider)
                .build()
                .open(user.getPlayer());
    }

    public enum View {
        GAMEMODES,
        ADDONS,
        HOOKS
    }
}
