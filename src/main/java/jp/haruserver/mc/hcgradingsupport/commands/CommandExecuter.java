package jp.haruserver.mc.hcgradingsupport.commands;

import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;
import jp.haruserver.mc.hcgradingsupport.util.ItemManager;
import jp.haruserver.mc.hcgradingsupport.util.StorageUtil;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

public class CommandExecuter implements CommandExecutor{

	StorageUtil stutil = new StorageUtil();
	ItemManager im = new ItemManager();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//めんどいのでプレイヤー専用コマンドにします
		if(!(sender instanceof Player)) return false;
		if(!label.equals("hcgs")) return false;
		if(args.length == 0) {
			commandExplanation(sender);
			return false;
		}
		Player player = (Player)sender;
		String playerUUID = player.getUniqueId().toString();
		Economy econ = HCGradingSupport.getEconomy();
		int allcount = 0;
		EconomyResponse r;

		switch (args[0]) {
			case "all":
				//ストレージ登録チェック
				stutil.containeStorage(playerUUID,HCGradingSupport.COBBLESTONE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.DIRT_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.GRAVEL_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.SAND_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.STONE_STORAGE_NAME);

				stutil.containeStorage(playerUUID, HCGradingSupport.GRNAITE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.DIORITE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.ANDESITE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.DEEPSLATE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.CALCITE_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.TUFF_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.NETHERRACK_STORAGE_NAME);
				stutil.containeStorage(playerUUID, HCGradingSupport.SANDSTONE_STORAGE_NAME);

				int cobblestoneCount = im.inventoryItemCounter(player,Material.COBBLESTONE);
				im.inventoryItemDrawer(player,Material.COBBLESTONE,cobblestoneCount);
				int[] cobblestoneStorage = stutil.addStorage(playerUUID,HCGradingSupport.COBBLESTONE_STORAGE_NAME, cobblestoneCount);

				int dirtCount = im.inventoryItemCounter(player,Material.DIRT);
				im.inventoryItemDrawer(player,Material.DIRT,dirtCount);
				int[] dirtStorage = stutil.addStorage(playerUUID,HCGradingSupport.DIRT_STORAGE_NAME, dirtCount);

				int gravelCount = im.inventoryItemCounter(player,Material.GRAVEL);
				im.inventoryItemDrawer(player,Material.GRAVEL,gravelCount);
				int[] gravelStorage = stutil.addStorage(playerUUID,HCGradingSupport.GRAVEL_STORAGE_NAME, gravelCount);

				int sandCount = im.inventoryItemCounter(player,Material.SAND);
				im.inventoryItemDrawer(player,Material.SAND,sandCount);
				int[] sandStorage = stutil.addStorage(playerUUID,HCGradingSupport.SAND_STORAGE_NAME, sandCount);

				int stoneCount = im.inventoryItemCounter(player,Material.STONE);
				im.inventoryItemDrawer(player,Material.STONE,stoneCount);
				int[] stoneStorage = stutil.addStorage(playerUUID,HCGradingSupport.STONE_STORAGE_NAME, stoneCount);

				int graniteCount = im.inventoryItemCounter(player,Material.GRANITE);
				im.inventoryItemDrawer(player,Material.GRANITE,graniteCount);
				int[] graniteStorage = stutil.addStorage(playerUUID,HCGradingSupport.GRNAITE_STORAGE_NAME, graniteCount);

				int dioriteCount = im.inventoryItemCounter(player,Material.DIORITE);
				im.inventoryItemDrawer(player,Material.DIORITE,dioriteCount);
				int[] dioriteStorage = stutil.addStorage(playerUUID,HCGradingSupport.DIORITE_STORAGE_NAME, dioriteCount);

				int andesiteCount = im.inventoryItemCounter(player,Material.ANDESITE);
				im.inventoryItemDrawer(player,Material.ANDESITE,andesiteCount);
				int[] andesiteStorage = stutil.addStorage(playerUUID,HCGradingSupport.ANDESITE_STORAGE_NAME, andesiteCount);

				int deepslateCount = im.inventoryItemCounter(player,Material.DEEPSLATE);
				im.inventoryItemDrawer(player,Material.DEEPSLATE,deepslateCount);
				int[] deepslateStorage = stutil.addStorage(playerUUID,HCGradingSupport.DEEPSLATE_STORAGE_NAME, deepslateCount);

				int cobbledDeepslateCount = im.inventoryItemCounter(player,Material.COBBLED_DEEPSLATE);
				im.inventoryItemDrawer(player,Material.COBBLED_DEEPSLATE,cobbledDeepslateCount);
				int[] cobbledDeepslateStorage = stutil.addStorage(playerUUID,HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME, cobbledDeepslateCount);

				int calciteCount = im.inventoryItemCounter(player,Material.CALCITE);
				im.inventoryItemDrawer(player,Material.CALCITE,calciteCount);
				int[] calciteStorage = stutil.addStorage(playerUUID,HCGradingSupport.CALCITE_STORAGE_NAME, calciteCount);

				int tuffCount = im.inventoryItemCounter(player,Material.TUFF);
				im.inventoryItemDrawer(player,Material.TUFF,tuffCount);
				int[] tuffStorage = stutil.addStorage(playerUUID,HCGradingSupport.TUFF_STORAGE_NAME, tuffCount);

				int netherrackCount = im.inventoryItemCounter(player,Material.NETHERRACK);
				im.inventoryItemDrawer(player,Material.NETHERRACK,netherrackCount);
				int[] netherrackStorage = stutil.addStorage(playerUUID,HCGradingSupport.NETHERRACK_STORAGE_NAME, netherrackCount);

				int sandstoneCount = im.inventoryItemCounter(player,Material.SANDSTONE);
				im.inventoryItemDrawer(player,Material.SANDSTONE,sandstoneCount);
				int[] sandstoneStorage = stutil.addStorage(playerUUID,HCGradingSupport.SANDSTONE_STORAGE_NAME, sandstoneCount);

				player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
				player.sendMessage(ChatColor.AQUA + "アイテムを格納しました");
				player.sendMessage(ChatColor.AQUA + "丸石[cobblestone]:" + String.valueOf(cobblestoneStorage[0]) + "個追加 倉庫数:" + String.valueOf(cobblestoneStorage[1]));
				player.sendMessage(ChatColor.AQUA + "土[dirt]:" + String.valueOf(dirtStorage[0]) + "個追加 倉庫数:" + String.valueOf(dirtStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂利[gravel]:" + String.valueOf(gravelStorage[0]) + "個追加 倉庫数:" + String.valueOf(gravelStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂[sand]:" + String.valueOf(sandStorage[0]) + "個追加 倉庫数:" + String.valueOf(sandStorage[1]));
				player.sendMessage(ChatColor.AQUA + "石[stone]:" + String.valueOf(stoneStorage[0]) + "個追加 倉庫数:" + String.valueOf(stoneStorage[1]));

				player.sendMessage(ChatColor.AQUA + "花崗岩[granite]:" + String.valueOf(graniteStorage[0]) + "個追加 倉庫数:" + String.valueOf(graniteStorage[1]));
				player.sendMessage(ChatColor.AQUA + "閃緑岩[diorite]" + String.valueOf(dioriteStorage[0]) + "個追加 倉庫数:" + String.valueOf(dioriteStorage[1]));
				player.sendMessage(ChatColor.AQUA + "安山岩[andesite]:" + String.valueOf(andesiteStorage[0]) + "個追加 倉庫数:" + String.valueOf(andesiteStorage[1]));
				player.sendMessage(ChatColor.AQUA + "深層岩[deepslate]:" + String.valueOf(deepslateStorage[0]) + "個追加 倉庫数:" + String.valueOf(deepslateStorage[1]));
				player.sendMessage(ChatColor.AQUA + "深層岩の丸石[cobbled_deepslate]:" + String.valueOf(cobbledDeepslateStorage[0]) + "個追加 倉庫数:" + String.valueOf(cobbledDeepslateStorage[1]));
				player.sendMessage(ChatColor.AQUA + "方解石[calcite]:" + String.valueOf(calciteStorage[0]) + "個追加 倉庫数:" + String.valueOf(calciteStorage[1]));
				player.sendMessage(ChatColor.AQUA + "凝灰岩[tuff]:" + String.valueOf(tuffStorage[0]) + "個追加 倉庫数:" + String.valueOf(tuffStorage[1]));
				player.sendMessage(ChatColor.AQUA + "ネザーラック[netherrack]:" + String.valueOf(netherrackStorage[0]) + "個追加 倉庫数:" + String.valueOf(netherrackStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂岩[sandstone]:" + String.valueOf(sandstoneStorage[0]) + "個追加 倉庫数:" + String.valueOf(sandstoneStorage[1]));
				player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");

				break;
			case "take":
				if(args.length < 2) {
					player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "コマンドの構文に誤りがあります。");
					return false;
				}
				if(args.length >= 3) {
					if(!isNumber(args[2])) {
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "数値を指定してください。");
						return false;
					}
					if(!isMinus(args[2])) {
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "正の整数を指定してください。");
						return false;
					}
				}

				int wantNum = 0;
				if(args.length >= 3) {
					wantNum = Integer.parseInt(args[2]);
				}else {
					wantNum = 64;
				}

				int[] storage = null;
				String itemName = null;
				int emptySlots = 0;
				int canHaveItemNum = 0;

				switch (args[1].toUpperCase()){
					case "COBBLESTONE":
						//ストレージ登録チェック
						stutil.containeStorage(playerUUID,HCGradingSupport.COBBLESTONE_STORAGE_NAME);
						//インベントリ内空のスロット数を取得
						emptySlots = im.checkInventoryEmpty(player);
						//取得可能アイテム数を取得
						canHaveItemNum = emptySlots * 64;
						//要求数が取得可能数を上回っている場合は修正
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						//ストレージから減算
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.COBBLESTONE_STORAGE_NAME, wantNum);
						//アイテムをインベントリに追加
						im.inventoryItemAddr(player,Material.COBBLESTONE, storage[0]);
						itemName = "丸石[cobblestone]";
						break;
					case "DIRT":
						stutil.containeStorage(playerUUID, HCGradingSupport.DIRT_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.DIRT_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.DIRT, storage[0]);
						itemName = "土[dirt]";
						break;
					case "GRAVEL":
						stutil.containeStorage(playerUUID, HCGradingSupport.GRAVEL_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.GRAVEL_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.GRAVEL, storage[0]);
						itemName = "砂利[gravel]";
						break;
					case "SAND":
						stutil.containeStorage(playerUUID, HCGradingSupport.SAND_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.SAND_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.SAND, storage[0]);
						itemName = "砂[sand]";
						break;
					case "STONE":
						stutil.containeStorage(playerUUID, HCGradingSupport.STONE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.STONE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.STONE, storage[0]);
						itemName = "石[stone]";
						break;
					case "GRANITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.GRNAITE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.GRNAITE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.GRANITE, storage[0]);
						itemName = "花崗岩[granite]";
						break;
					case "DIORITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.DIORITE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.DIORITE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.DIORITE, storage[0]);
						itemName = "閃緑岩[diorite]";
						break;
					case "ANDESITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.ANDESITE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.ANDESITE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.ANDESITE, storage[0]);
						itemName = "安山岩[andesite]";
						break;
					case "DEEPSLATE":
						stutil.containeStorage(playerUUID, HCGradingSupport.DEEPSLATE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.DEEPSLATE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.DEEPSLATE, storage[0]);
						itemName = "深層岩[deepslate]";
						break;
					case "COBBLED_DEEPSLATE":
						stutil.containeStorage(playerUUID, HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.COBBLED_DEEPSLATE, storage[0]);
						itemName = "深層岩の丸石[cobbled_deepslate]";
						break;
					case "CALCITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.CALCITE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.CALCITE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.CALCITE, storage[0]);
						itemName = "方解石[calcite]";
						break;
					case "TUFF":
						stutil.containeStorage(playerUUID, HCGradingSupport.TUFF_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.TUFF_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.TUFF, storage[0]);
						itemName = "凝灰岩[tuff]";
						break;
					case "NETHERRACK":
						stutil.containeStorage(playerUUID, HCGradingSupport.NETHERRACK_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.NETHERRACK_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.NETHERRACK, storage[0]);
						itemName = "ネザーラック[netherrack]";
						break;
					case "SANDSTONE":
						stutil.containeStorage(playerUUID, HCGradingSupport.SANDSTONE_STORAGE_NAME);
						emptySlots = im.checkInventoryEmpty(player);
						canHaveItemNum = emptySlots * 64;
						if(canHaveItemNum < wantNum) {
							wantNum = canHaveItemNum;
						}
						storage = stutil.minusStorage(playerUUID, HCGradingSupport.SANDSTONE_STORAGE_NAME, wantNum);
						im.inventoryItemAddr(player,Material.SANDSTONE, storage[0]);
						itemName = "砂岩[sandstone]";
						break;
					default:
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "コマンドの構文に誤りがあります。");
						return false;
					}

					player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
					player.sendMessage(ChatColor.AQUA + "アイテムを取り出しました。Took out your items");
					player.sendMessage(ChatColor.AQUA + itemName + ":" + String.valueOf(storage[0]) + "個取り出し 倉庫数:" + String.valueOf(storage[1]));
					player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");

				break;
			case "gtake":
				if(args.length < 2) {
					player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "コマンドの構文に誤りがあります。");
					return false;
				}
				if(args.length >= 3) {
					if(!isNumber(args[2])) {
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "数値を指定してください。");
						return false;
					}
					if(!isMinus(args[2])) {
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "正の整数を指定してください。");
						return false;
					}
				}

				int wantNumGloval = 0;
				if(args.length >= 3) {
					wantNumGloval = Integer.parseInt(args[2]);
				}else {
					wantNumGloval = 64;
				}

				int[] storageGloval = null;
				String itemNameGloval = null;
				int emptySlotsGloval = 0;
				int canHaveItemNumGloval = 0;
				switch (args[1].toUpperCase()){
					case "COBBLESTONE":
						//ストレージ登録チェック
						stutil.containeGlovalStorage(HCGradingSupport.COBBLESTONE_STORAGE_NAME);
						//インベントリ内空のスロット数を取得
						emptySlotsGloval = im.checkInventoryEmpty(player);
						//取得可能アイテム数を取得
						canHaveItemNumGloval = emptySlotsGloval * 64;
						//要求数が取得可能数を上回っている場合は修正
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						//ストレージから減算
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.COBBLESTONE_STORAGE_NAME, wantNumGloval);
						//アイテムをインベントリに追加
						im.inventoryItemAddr(player,Material.COBBLESTONE, storageGloval[0]);
						itemNameGloval = "丸石[cobblestone]";
						break;
					case "DIRT":
						stutil.containeStorage(playerUUID, HCGradingSupport.DIRT_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.DIRT_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.DIRT, storageGloval[0]);
						itemNameGloval = "土[dirt]";
						break;
					case "GRAVEL":
						stutil.containeStorage(playerUUID, HCGradingSupport.GRAVEL_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.GRAVEL_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.GRAVEL, storageGloval[0]);
						itemNameGloval = "砂利[gravel]";
						break;
					case "SAND":
						stutil.containeStorage(playerUUID, HCGradingSupport.SAND_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.SAND_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.SAND, storageGloval[0]);
						itemNameGloval = "砂[sand]";
						break;
					case "STONE":
						stutil.containeStorage(playerUUID, HCGradingSupport.STONE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.STONE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.STONE, storageGloval[0]);
						itemNameGloval = "石[stone]";
						break;
					case "GRNAITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.GRNAITE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.GRNAITE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.GRANITE, storageGloval[0]);
						itemNameGloval = "花崗岩[granite]";
						break;
					case "DIORITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.DIORITE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.DIORITE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.DIORITE, storageGloval[0]);
						itemNameGloval = "閃緑岩[diorite]";
						break;
					case "ANDESITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.ANDESITE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.ANDESITE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.ANDESITE, storageGloval[0]);
						itemNameGloval = "安山岩[andesite]";
						break;
					case "DEEPSLATE":
						stutil.containeStorage(playerUUID, HCGradingSupport.DEEPSLATE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.DEEPSLATE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.DEEPSLATE, storageGloval[0]);
						itemNameGloval = "深層岩[deepslate]";
						break;
					case "COBBLED_DEEPSLATE":
						stutil.containeStorage(playerUUID, HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.COBBLED_DEEPSLATE, storageGloval[0]);
						itemNameGloval = "深層岩の丸石[cobbled_deepslate]";
						break;
					case "CALCITE":
						stutil.containeStorage(playerUUID, HCGradingSupport.CALCITE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.CALCITE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.CALCITE, storageGloval[0]);
						itemNameGloval = "方解石[calcite]";
						break;
					case "TUFF":
						stutil.containeStorage(playerUUID, HCGradingSupport.TUFF_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.TUFF_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.TUFF, storageGloval[0]);
						itemNameGloval = "凝灰岩[tuff]";
						break;
					case "NETHERRACK":
						stutil.containeStorage(playerUUID, HCGradingSupport.NETHERRACK_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.NETHERRACK_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.NETHERRACK, storageGloval[0]);
						itemNameGloval = "ネザーラック[netherrack]";
						break;
					case "SANDSTONE":
						stutil.containeStorage(playerUUID, HCGradingSupport.SANDSTONE_STORAGE_NAME);
						emptySlotsGloval = im.checkInventoryEmpty(player);
						canHaveItemNumGloval = emptySlotsGloval * 64;
						if(canHaveItemNumGloval < wantNumGloval) {
							wantNumGloval = canHaveItemNumGloval;
						}
						//お金が足りない場合戻る
						if(!canWithdraw(player,wantNumGloval * HCGradingSupport.takeMoneyPerBlock)) {
							player.sendMessage(ChatColor.RED + "お金が足りません。You don't have enough money.");
							return false;
						}
						storageGloval = stutil.minusGlovalStorage(HCGradingSupport.SANDSTONE_STORAGE_NAME, wantNumGloval);
						im.inventoryItemAddr(player,Material.SANDSTONE, storageGloval[0]);
						itemNameGloval = "砂岩[sandstone]";
						break;
					default:
						player.sendMessage(HCGradingSupport.COMMAND_HEADER_ERROR + "コマンドの構文に誤りがあります。");
						return false;
					}

					r = econ.withdrawPlayer(player, wantNumGloval * HCGradingSupport.takeMoneyPerBlock);
					if(r.transactionSuccess()) {
						sender.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
					} else {
						sender.sendMessage(String.format("An error occured: %s", r.errorMessage));
					}
					player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
					player.sendMessage(ChatColor.AQUA + "アイテムを取り出しました。Took out your items");
					player.sendMessage(ChatColor.AQUA + itemNameGloval + ":" + String.valueOf(storageGloval[0]) + "個取り出し 倉庫数:" + String.valueOf(storageGloval[1]));
					player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");

				break;

			case "gall":
				//ストレージ登録チェック
				stutil.containeGlovalStorage(HCGradingSupport.GLOVAL_STORAGE_NAME);

				int cobblestoneGlovalCount = im.inventoryItemCounter(player,Material.COBBLESTONE);
				im.inventoryItemDrawer(player,Material.COBBLESTONE,cobblestoneGlovalCount);
				int[] cobblestoneGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.COBBLESTONE_STORAGE_NAME, cobblestoneGlovalCount);

				allcount += cobblestoneGlovalStorage[0];

				int dirtGlovalCount = im.inventoryItemCounter(player,Material.DIRT);
				im.inventoryItemDrawer(player,Material.DIRT,dirtGlovalCount);
				int[] dirtGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.DIRT_STORAGE_NAME, dirtGlovalCount);
				allcount += dirtGlovalStorage[0];

				int gravelGlovalCount = im.inventoryItemCounter(player,Material.GRAVEL);
				im.inventoryItemDrawer(player,Material.GRAVEL,gravelGlovalCount);
				int[] gravelGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.GRAVEL_STORAGE_NAME, gravelGlovalCount);
				allcount += gravelGlovalStorage[0];

				int sandGlovalCount = im.inventoryItemCounter(player,Material.SAND);
				im.inventoryItemDrawer(player,Material.SAND,sandGlovalCount);
				int[] sandGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.SAND_STORAGE_NAME, sandGlovalCount);
				allcount += sandGlovalStorage[0];

				int stoneGlovalCount = im.inventoryItemCounter(player,Material.STONE);
				im.inventoryItemDrawer(player,Material.STONE,stoneGlovalCount);
				int[] stoneGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.STONE_STORAGE_NAME, stoneGlovalCount);
				allcount += stoneGlovalStorage[0];

				int graniteGlovalCount = im.inventoryItemCounter(player,Material.GRANITE);
				im.inventoryItemDrawer(player,Material.GRANITE,graniteGlovalCount);
				int[] graniteGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.GRNAITE_STORAGE_NAME, graniteGlovalCount);
				allcount += graniteGlovalStorage[0];

				int dioriteGlovalCount = im.inventoryItemCounter(player,Material.DIORITE);
				im.inventoryItemDrawer(player,Material.DIORITE,dioriteGlovalCount);
				int[] dioriteGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.DIORITE_STORAGE_NAME, dioriteGlovalCount);
				allcount += dioriteGlovalStorage[0];

				int andesiteGlovalCount = im.inventoryItemCounter(player,Material.ANDESITE);
				im.inventoryItemDrawer(player,Material.ANDESITE,andesiteGlovalCount);
				int[] andesiteGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.ANDESITE_STORAGE_NAME, andesiteGlovalCount);
				allcount += andesiteGlovalStorage[0];

				int deepslateGlovalCount = im.inventoryItemCounter(player,Material.DEEPSLATE);
				im.inventoryItemDrawer(player,Material.DEEPSLATE,deepslateGlovalCount);
				int[] deepslateGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.DEEPSLATE_STORAGE_NAME, deepslateGlovalCount);
				allcount += deepslateGlovalStorage[0];

				int cobbledDeepslateGlovalCount = im.inventoryItemCounter(player,Material.COBBLED_DEEPSLATE);
				im.inventoryItemDrawer(player,Material.COBBLED_DEEPSLATE,cobbledDeepslateGlovalCount);
				int[] cobbledDeepslateGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME, cobbledDeepslateGlovalCount);
				allcount += cobbledDeepslateGlovalStorage[0];

				int calciteGlovalCount = im.inventoryItemCounter(player,Material.CALCITE);
				im.inventoryItemDrawer(player,Material.CALCITE,calciteGlovalCount);
				int[] calciteGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.CALCITE_STORAGE_NAME, calciteGlovalCount);
				allcount += calciteGlovalStorage[0];

				int tuffGlovalCount = im.inventoryItemCounter(player,Material.TUFF);
				im.inventoryItemDrawer(player,Material.TUFF,tuffGlovalCount);
				int[] tuffGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.TUFF_STORAGE_NAME, tuffGlovalCount);
				allcount += tuffGlovalStorage[0];

				int netherrackGlovalCount = im.inventoryItemCounter(player,Material.NETHERRACK);
				im.inventoryItemDrawer(player,Material.NETHERRACK,netherrackGlovalCount);
				int[] netherrackGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.NETHERRACK_STORAGE_NAME, netherrackGlovalCount);
				allcount += netherrackGlovalStorage[0];

				int sandstoneGlovalCount = im.inventoryItemCounter(player,Material.SANDSTONE);
				im.inventoryItemDrawer(player,Material.SANDSTONE,sandstoneGlovalCount);
				int[] sandstoneGlovalStorage = stutil.addGlovalStorage(HCGradingSupport.SANDSTONE_STORAGE_NAME, sandstoneGlovalCount);
				allcount += sandstoneGlovalStorage[0];

				player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
				player.sendMessage(ChatColor.AQUA + "グローバルストレージにアイテムを格納しました");
				player.sendMessage(ChatColor.AQUA + "丸石[cobblestone]:" + String.valueOf(cobblestoneGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(cobblestoneGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "土[dirt]:" + String.valueOf(dirtGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(dirtGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂利[gravel]:" + String.valueOf(gravelGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(gravelGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂[sand]:" + String.valueOf(sandGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(sandGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "石[stone]:" + String.valueOf(stoneGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(stoneGlovalStorage[1]));

				player.sendMessage(ChatColor.AQUA + "花崗岩[granite]:" + String.valueOf(graniteGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(graniteGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "閃緑岩[diorite]" + String.valueOf(dioriteGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(dioriteGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "安山岩[andesite]:" + String.valueOf(andesiteGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(andesiteGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "深層岩[deepslate]:" + String.valueOf(deepslateGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(deepslateGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "深層岩の丸石[cobbled_deepslate]:" + String.valueOf(cobbledDeepslateGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(cobbledDeepslateGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "方解石[calcite]:" + String.valueOf(calciteGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(calciteGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "凝灰岩[tuff]:" + String.valueOf(tuffGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(tuffGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "ネザーラック[netherrack]:" + String.valueOf(netherrackGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(netherrackGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "砂岩[sandstone]:" + String.valueOf(sandstoneGlovalStorage[0]) + "個追加 倉庫数:" + String.valueOf(sandstoneGlovalStorage[1]));
				player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");

				//支払処理
	            r = econ.depositPlayer(player, allcount * HCGradingSupport.giveMoneyPerBlock);
	            if(r.transactionSuccess()) {
	                sender.sendMessage(String.format("You were given %s and now have %s", econ.format(r.amount), econ.format(r.balance)));
	            } else {
	                sender.sendMessage(String.format("An error occured: %s", r.errorMessage));
	            }

				break;
			default:
				commandExplanation(sender);
				break;
		}
		return true;
	}

	void commandExplanation(CommandSender player) {
		player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
		player.sendMessage(ChatColor.AQUA + "/hcgs all 全ての丸石、土、砂利、砂をストレージに格納します。");
		player.sendMessage(ChatColor.AQUA + "/hcgs take [STONE|COBBLESTONE|DIRT|GRAVEL|SAND|GRANITE|DIORITE|SANDESITE|DEEPSLATE|COBBLED_DEEPSLATE|CALCITE|TUFF|NETHERRACK|SANDSTONE] 個数 ストレージからアイテムを取り出します。");
		player.sendMessage(ChatColor.AQUA + "/hcgs gall 全ての丸石、土、砂利、砂をグローバルストレージに格納します。");
		player.sendMessage(ChatColor.AQUA + "---------------------[INFO]---------------------");
		return;
	}

	public boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
	public boolean isMinus(String val) {
	    boolean result = false;
	    if (val != null) {
	        Pattern pattern = Pattern.compile("^[0-9]+$");
	        result = pattern.matcher(val).matches();
	    }
	    return result;
	}

	public boolean canWithdraw(Player player,Double withdraw) {
		Economy econ = HCGradingSupport.getEconomy();
		econ.getBalance(player);
		if(econ.getBalance(player) >= withdraw) {
			return true;
		} else {
			return false;
		}
	}

}
