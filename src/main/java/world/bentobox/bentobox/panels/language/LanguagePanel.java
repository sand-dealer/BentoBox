package world.bentobox.bentobox.panels.language;

import fr.minuskube.inv.SmartInventory;
import world.bentobox.bentobox.BentoBox;
import world.bentobox.bentobox.api.user.User;

public class LanguagePanel {

    public static void open(User user) {
        SmartInventory.builder()
                .title(user.getTranslation("language.panel-title"))
                .manager(BentoBox.getInstance().getInventoryManager())
                .provider(new LanguageInventoryProvider())
                .build()
                .open(user.getPlayer());
    }
}
