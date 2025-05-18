package jp.haruserver.mc.hcgradingsupport.commands;


import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;
import jp.haruserver.mc.hcgradingsupport.util.ItemManager;
import jp.haruserver.mc.hcgradingsupport.util.StorageKeys;
import jp.haruserver.mc.hcgradingsupport.util.StorageUtil;
import jp.haruserver.mc.hcgradingsupport.util.TakeGuiOpener;

public class CommandExecuter implements CommandExecutor{

	private final HCGradingSupport HCGradingSupport;
	
    public CommandExecuter(HCGradingSupport HCGradingSupportn) {
        this.HCGradingSupport = HCGradingSupportn;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false;
        Player player = (Player)sender;
        StorageUtil storageUtil = HCGradingSupport.getStorageUtil();
        StorageKeys storageKeys = HCGradingSupport.getStorageKeys();
        
        switch (args.length) {
            case 1:
                if (args[0].equalsIgnoreCase("check")) {
                    Map<Material, String> storageKeysMap = HCGradingSupport.getStorageKeysMap();
                    for (Map.Entry<Material, String> entry : storageKeysMap.entrySet()) {
                        Material mat = entry.getKey();
                        Bukkit.getServer().getLogger().info(mat.name());
                        int currentAmount = storageKeys.getStoredAmount(player, mat);
                        if (currentAmount > 0) {
                            //後ほどユーザーフレンドリーな結果通知にすること
                            sender.sendMessage(" - " + mat.name() + ": " + currentAmount);
                        }
                    }
                }else if(args[0].equalsIgnoreCase("all")){
                    ItemManager itemManager = HCGradingSupport.getItemManager();
                    Map<Material, String> storageKeysMap = HCGradingSupport.getStorageKeysMap();
                    for (Map.Entry<Material, String> entry : storageKeysMap.entrySet()) {
                        Material mat = entry.getKey();
                        int materialNum = itemManager.inventoryItemCounter(player, mat);
                        if (materialNum == 0) continue; 

                        int storageNum = storageKeys.getStoredAmount(player, mat);
                        int totalNum = materialNum + storageNum;
                        itemManager.inventoryItemDrawer(player, mat, materialNum);
                        storageKeys.setStoredAmount(player, mat, totalNum);

                        //後ほどユーザーフレンドリーな結果通知にすること
                        player.sendMessage("登録:" + mat.name() + ",インベントリ個数:" + String.valueOf(materialNum) + ",各納前ストレージ個数:" + String.valueOf(storageNum) + ",格納後ストレージ個数:" + String.valueOf(totalNum) + ",デバッグ用:" + String.valueOf(storageKeys.getStoredAmount(player, mat)));
                        //証跡出力
                        Bukkit.getServer().getLogger().info("[HCGS_ALL]PLAYER:" + player.getName() + ",UUID:" + player.getUniqueId().toString() + ",TYPE:" + mat.name() + ",BEFORE_STOR:" + String.valueOf(storageNum) + ",AFTER_STOR:" + String.valueOf(totalNum));
                    }
                }
                break;
            case 2:
                if (args[0].equalsIgnoreCase("take")) {

                    int takeAmount = 0;

                    try {
                        takeAmount = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("有効な数字を入れてください");
                        return false;
                    }
                    Map<Material, String> storageKeysMap = HCGradingSupport.getStorageKeysMap();
                    TakeGuiOpener.openTakeGui(player, takeAmount, storageKeysMap, HCGradingSupport);
                }
                break;
            case 3:
                if (args[0].equalsIgnoreCase("put")) {
                    Material material = Material.matchMaterial(args[1]);

                    if (material == null) {
                        sender.sendMessage("無効なブロックです。");
                        return true;
                    }

                    if (!storageUtil.isSupported(material)) {
                        sender.sendMessage("このマテリアルは登録されていません。");
                        return true;
                    }

                    int putNum = 0;

                    try {
                        putNum = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("有効な数字を入れてください");
                        return false;
                    }
                    ItemManager itemManager = HCGradingSupport.getItemManager();

                    int inventoryNum = itemManager.inventoryItemCounter(player, material);

                    if(putNum > inventoryNum){
                        putNum = inventoryNum;
                    }

                    int storageNum = storageKeys.getStoredAmount(player, material);
                    int totalNum = storageNum + putNum;

                    itemManager.inventoryItemDrawer(player, material, putNum);
                    storageKeys.setStoredAmount(player, material, totalNum);
                    sender.sendMessage(putNum + "個を預けました。");
                    Bukkit.getServer().getLogger().info("[HCGS_PUT]PLAYER:" + player.getName() + ",UUID:" + player.getUniqueId().toString() + ",TYPE:" + material.name() + ",BEFORE_STOR:" + String.valueOf(storageNum)+ ",PUT_NUM:" + String.valueOf(putNum) + ",AFTER_STOR:" + String.valueOf(totalNum));

                }else if (args[0].equalsIgnoreCase("take")) {
                    Material material = Material.matchMaterial(args[1]);

                    if (material == null) {
                        sender.sendMessage("無効なブロックです。");
                        return true;
                    }

                    if (!storageUtil.isSupported(material)) {
                        sender.sendMessage("このマテリアルは登録されていません。");
                        return true;
                    }
                    int takeNum = 0;

                    try {
                        takeNum = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("有効な数字を入れてください");
                        return false;
                    }
                    ItemManager itemManager = HCGradingSupport.getItemManager();
                    int emptySlot = itemManager.checkInventoryEmpty(player);
                    int maxStackSize = (new ItemStack(material)).getMaxStackSize();
                    int storageNum = storageKeys.getStoredAmount(player, material);

                    if(storageNum < takeNum){
                        takeNum = storageNum;
                    }
                    int requiredSlots = (takeNum + maxStackSize - 1) / maxStackSize;

                    if(requiredSlots > emptySlot){
                        sender.sendMessage("インベントリの空きが足りません。");
                        return false;
                    }

                    int totalNum = storageNum - takeNum;
                    storageKeys.setStoredAmount(player, material, totalNum);
                    itemManager.inventoryItemAddr(player, material, takeNum);
                    sender.sendMessage(takeNum + "個を取り出しました。");
                    Bukkit.getServer().getLogger().info("[HCGS_TAKE]PLAYER:" + player.getName() + ",UUID:" + player.getUniqueId().toString() + ",TYPE:" + material.name() + ",BEFORE_STOR:" + String.valueOf(storageNum)+ ",TAKE_NUM:" + String.valueOf(takeNum) + ",AFTER_STOR:" + String.valueOf(totalNum));

                }
                break;
            default:
                break;
        }
        return true;
    }
}