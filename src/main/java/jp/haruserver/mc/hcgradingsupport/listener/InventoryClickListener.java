package jp.haruserver.mc.hcgradingsupport.listener;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;
import jp.haruserver.mc.hcgradingsupport.util.TakeGuiHolder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class InventoryClickListener implements Listener{

    private final HCGradingSupport HCGradingSupport;

    public InventoryClickListener(HCGradingSupport HCGradingSupport) {
        this.HCGradingSupport = HCGradingSupport;
    }
        
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        Player player = (Player)event.getWhoClicked();
        if (!(event.getInventory().getHolder() instanceof TakeGuiHolder)) return;

        event.setCancelled(true);

        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || !clicked.hasItemMeta()) return;

        ItemMeta meta = clicked.getItemMeta();
        if (meta == null || !meta.hasLore()) return;

        List<Component> lore = meta.lore();
        if (lore == null || lore.size() < 2) return;

        String command = PlainTextComponentSerializer.plainText().serialize(lore.get(1));
        if (command.startsWith("/hcgs take ")) {
            player.closeInventory();
            player.performCommand(command.substring(1)); // "/" は不要なので除く
        }
    }
}