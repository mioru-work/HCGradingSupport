package jp.haruserver.mc.hcgradingsupport.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;

public class ItemManager {

	private final HCGradingSupport HCGradingSupport;
	
	public ItemManager(HCGradingSupport HCGradingSupport){
		this.HCGradingSupport = HCGradingSupport;
	}

	/**
	 * 引数で指定したマテリアルのアイテムがインベントリ内にいくつあるかチェックします。
	 *
	 * @param player
	 * @param mat マテリアル
	 * @return マテリアルの数
	 */
	public int inventoryItemCounter(Player player, Material mat) {
		PlayerInventory inventory = player.getInventory();
		ItemStack[] items = inventory.getContents();
		int counter = 0;
		for (ItemStack item : items){
			if ((item != null) && (item.getType() == mat) && (item.getAmount() > 0)){
				counter += item.getAmount();
			}
		}
        return counter;
	}

	/**
	 * 数で指定したマテリアルを指定の数だけインベントリから引き去ります。
	 *
	 * @param player
	 * @param mat マテリアル
	 * @param draw 引く数
	 * @return 引けた数
	 */
	public int inventoryItemDrawer(Player player, Material mat,int draw) {
		PlayerInventory inventory = player.getInventory();
		ItemStack[] items = inventory.getContents();
		int counter = draw;
		for (ItemStack item : items){
			if ((item != null) && (item.getType() == mat) && (item.getAmount() > 0)){
				int itemStackNum = item.getAmount();
				if(itemStackNum < draw) {
					draw -= itemStackNum;
					item.setAmount(0);
				}else{
					itemStackNum -= draw;
					item.setAmount(itemStackNum);
					draw = 0;
				}
			}
		}
        return counter - draw;
	}

	/**
	 * インベントリの空きスロットを確認します。
	 *
	 * @param player
	 * @return 空きスロット数
	 */
	public int checkInventoryEmpty(Player player) {
		PlayerInventory inventory = player.getInventory();
		ItemStack[] items = inventory.getContents();
		int counter = 0;
		for (ItemStack item : items){
			if(item == null) {
				counter ++;
			}
		}

		items = inventory.getArmorContents();
		for (ItemStack item : items){
			if(item == null) {
				counter --;
			}
		}

		ItemStack im = inventory.getItemInOffHand();
		if(im.getType() == Material.AIR) {
			counter --;
		}
		return counter;
	}

	/**
	 * インベントリにアイテムを追加します。
	 * インベントリの空き数を計算してから使用してください。
	 *
	 * @param player
	 * @param additem 追加するアイテム
	 * @param add 追加する数
	 * @return
	 */
	public void inventoryItemAddr(Player player, Material mat,int add) {
		PlayerInventory inventory = player.getInventory();
		while (add > 0){
			if(add < 64) {
				inventory.addItem(new ItemStack(mat,add));
				add = 0;
			}else{
				inventory.addItem(new ItemStack(mat,64));
				add = add - 64;
			}

		}
		return;
	}
}
