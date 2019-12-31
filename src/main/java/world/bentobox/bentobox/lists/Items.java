package world.bentobox.bentobox.lists;

import org.bukkit.Material;
import world.bentobox.bentobox.api.inventory.item.PremadeItem;
import world.bentobox.bentobox.api.panels.builders.PanelItemBuilder;

public class Items {

    public static final PremadeItem PAGINATION_NEXT = PremadeItem.of(new PanelItemBuilder().icon(Material.ARROW).build().getItem());
    public static final PremadeItem LOOKS_EMPTY = PremadeItem.of(new PanelItemBuilder()
            .icon(Material.STRUCTURE_VOID)
            .name("buttons.empty-here.name")
            .description("buttons.empty-here.description")
            .build().getItem());
}
