package world.bentobox.bentobox.api.commands.island;

import java.util.List;

import fr.minuskube.inv.SmartInventory;
import world.bentobox.bentobox.api.commands.CompositeCommand;
import world.bentobox.bentobox.api.user.User;
import world.bentobox.bentobox.panels.LanguagePanel;

/**
 * @author Poslovitch
 */
public class IslandLanguageCommand extends CompositeCommand {

    public IslandLanguageCommand(CompositeCommand islandCommand) {
        super(islandCommand, "language", "lang");
    }

    @Override
    public void setup() {
        setPermission("island.language");
        setOnlyPlayer(true);
        setDescription("commands.island.language.description");
    }

    @Override
    public boolean execute(User user, String label, List<String> args) {
        SmartInventory.builder()
                .title(user.getTranslation("language.panel-title"))
                .manager(getPlugin().getInventoryManager())
                .provider(new LanguagePanel())
                .build()
                .open(user.getPlayer());
        return true;
    }
}