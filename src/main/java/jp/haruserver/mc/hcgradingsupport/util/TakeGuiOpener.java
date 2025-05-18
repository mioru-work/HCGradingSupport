package jp.haruserver.mc.hcgradingsupport.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class TakeGuiOpener {

    public static void openTakeGui(Player player, int takeAmount, Map<Material, String> storageKeysMap, HCGradingSupport plugin) {
        // タイトルをComponent形式で作成
        MiniMessage mm = MiniMessage.miniMessage();
        Component title = mm.deserialize("<gradient:#FFD700:#FF8C00><bold>◆ 取り出すブロックを選択 ◆</bold></gradient>");

        // Adventure対応のcreateInventory
        Inventory gui = Bukkit.createInventory(new TakeGuiHolder(), 54, title);

        for (Material material : storageKeysMap.keySet()) {
            if (material.isItem()) {
                ItemStack item = new ItemStack(material);
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    // displayName の設定（緑色）
                    meta.displayName(Component.text(material.name(), NamedTextColor.GREEN));

                    // lore の設定（灰色＋黄色）
                    List<Component> lore = new ArrayList<>();
                    lore.add(Component.text("クリックで" + takeAmount + "個取り出す", NamedTextColor.GRAY));
                    lore.add(Component.text("/hcgs take " + material.name() + " " + String.valueOf(takeAmount)));
                    meta.lore(lore);
                    item.setItemMeta(meta);
                }
                gui.addItem(item);
            }
        }

        player.openInventory(gui);
    }
}