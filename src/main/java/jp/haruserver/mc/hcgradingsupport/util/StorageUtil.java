package jp.haruserver.mc.hcgradingsupport.util;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;
import jp.haruserver.mc.hcgradingsupport.config.CustomConfig;

public class StorageUtil {

	/**
	 * 各ストレージのuuid存在確認をします。存在しない場合は追加します。
	 *
	 * @param uuid プレイヤーuuid
	 * @param storageName ストレージ名
	 * @return
	 */
	public boolean containeStorage(String uuid,String storageName) {

		CustomConfig cs = null;
		switch (storageName){
			case (HCGradingSupport.COBBLESTONE_STORAGE_NAME):
				cs = HCGradingSupport.cobblestone_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.DIRT_STORAGE_NAME):
				cs = HCGradingSupport.dirt_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.GRAVEL_STORAGE_NAME):
				cs = HCGradingSupport.gravel_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.SAND_STORAGE_NAME):
				cs = HCGradingSupport.sand_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.STONE_STORAGE_NAME):
				cs = HCGradingSupport.stone_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.GRNAITE_STORAGE_NAME):
				cs = HCGradingSupport.granite_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.DIORITE_STORAGE_NAME):
				cs = HCGradingSupport.diorite_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.ANDESITE_STORAGE_NAME):
				cs = HCGradingSupport.andesite_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.deepslate_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.cobbled_deepslate_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.CALCITE_STORAGE_NAME):
				cs = HCGradingSupport.calcite_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.TUFF_STORAGE_NAME):
				cs = HCGradingSupport.tuff_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.NETHERRACK_STORAGE_NAME):
				cs = HCGradingSupport.netherrack_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
			case (HCGradingSupport.SANDSTONE_STORAGE_NAME):
				cs = HCGradingSupport.sandstone_storage;
				if(!cs.getConfig().contains(uuid)) {
					cs.getConfig().set(uuid,0);
					cs.saveConfig();
				}
				break;
		}
		return true;
	}

	public boolean containeGlovalStorage(String storageName) {
		CustomConfig cs = HCGradingSupport.gloval_storage;
		return true;
	}

	/**
	 * ストレージに加算します。
	 *
	 * @param uuid プレイヤーuuid
	 * @param storageName ストレージ名
	 * @param add 加算する数
	 * @return [実際の加算数、加算後ストレージ内アイテム数]
	 */
	public int[] addStorage(String uuid,String storageName,int add) {
		CustomConfig cs = null;
		int count = 0;
		switch (storageName){
			case (HCGradingSupport.COBBLESTONE_STORAGE_NAME):
				cs = HCGradingSupport.cobblestone_storage;
				break;
			case (HCGradingSupport.DIRT_STORAGE_NAME):
				cs = HCGradingSupport.dirt_storage;
				break;
			case (HCGradingSupport.GRAVEL_STORAGE_NAME):
				cs = HCGradingSupport.gravel_storage;
				break;
			case (HCGradingSupport.SAND_STORAGE_NAME):
				cs = HCGradingSupport.sand_storage;
				break;
			case (HCGradingSupport.STONE_STORAGE_NAME):
				cs = HCGradingSupport.stone_storage;
				break;
			case (HCGradingSupport.GRNAITE_STORAGE_NAME):
				cs = HCGradingSupport.granite_storage;
				break;
			case (HCGradingSupport.DIORITE_STORAGE_NAME):
				cs = HCGradingSupport.diorite_storage;
				break;
			case (HCGradingSupport.ANDESITE_STORAGE_NAME):
				cs = HCGradingSupport.andesite_storage;
				break;
			case (HCGradingSupport.DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.deepslate_storage;
				break;
			case (HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.cobbled_deepslate_storage;
				break;
			case (HCGradingSupport.CALCITE_STORAGE_NAME):
				cs = HCGradingSupport.calcite_storage;
				break;
			case (HCGradingSupport.TUFF_STORAGE_NAME):
				cs = HCGradingSupport.tuff_storage;
				break;
			case (HCGradingSupport.NETHERRACK_STORAGE_NAME):
				cs = HCGradingSupport.netherrack_storage;
				break;
			case (HCGradingSupport.SANDSTONE_STORAGE_NAME):
				cs = HCGradingSupport.sandstone_storage;
				break;
		}
		if(cs.getConfig().contains(uuid)) {
			count = cs.getConfig().getInt(uuid) + add;
			if(count > HCGradingSupport.maxItemNum) {
				add = count - HCGradingSupport.maxItemNum;
				count = HCGradingSupport.maxItemNum;
				cs.getConfig().set(uuid,HCGradingSupport.maxItemNum);
			}else {
				cs.getConfig().set(uuid,count);
			}
			cs.saveConfig();
		}
		int[] storage = {add,count};
		return storage;
	}

	public int[] addGlovalStorage(String material,int add) {
		CustomConfig cs = HCGradingSupport.gloval_storage;
		int count = 0;
		if(!cs.getConfig().contains(material)) {
			cs.getConfig().set(material,0);
			cs.saveConfig();
		}
		if(cs.getConfig().contains(material)) {
			count = cs.getConfig().getInt(material) + add;
			if(count > HCGradingSupport.maxItemNumGloval) {
				add = count - HCGradingSupport.maxItemNumGloval;
				count = HCGradingSupport.maxItemNumGloval;
				cs.getConfig().set(material,HCGradingSupport.maxItemNumGloval);
			}else {
				cs.getConfig().set(material,count);
			}
			cs.saveConfig();
		}
		int[] storage = {add,count};
		return storage;
	}

	/**
	 * ストレージから減算します。
	 *
	 * @param uuid プレイヤーuuid
	 * @param storageName ストレージ名
	 * @param minus 減算する数
	 * @return [実際の減算数、減算後後ストレージ内アイテム数]
	 */
	public int[] minusStorage(String uuid,String storageName,int minus) {
		CustomConfig cs = null;
		int count = 0;
		switch (storageName){
			case (HCGradingSupport.COBBLESTONE_STORAGE_NAME):
				cs = HCGradingSupport.cobblestone_storage;
				break;
			case (HCGradingSupport.DIRT_STORAGE_NAME):
				cs = HCGradingSupport.dirt_storage;
				break;
			case (HCGradingSupport.GRAVEL_STORAGE_NAME):
				cs = HCGradingSupport.gravel_storage;
				break;
			case (HCGradingSupport.SAND_STORAGE_NAME):
				cs = HCGradingSupport.sand_storage;
				break;
			case (HCGradingSupport.STONE_STORAGE_NAME):
				cs = HCGradingSupport.stone_storage;
				break;
			case (HCGradingSupport.GRNAITE_STORAGE_NAME):
				cs = HCGradingSupport.granite_storage;
				break;
			case (HCGradingSupport.DIORITE_STORAGE_NAME):
				cs = HCGradingSupport.diorite_storage;
				break;
			case (HCGradingSupport.ANDESITE_STORAGE_NAME):
				cs = HCGradingSupport.andesite_storage;
				break;
			case (HCGradingSupport.DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.deepslate_storage;
				break;
			case (HCGradingSupport.COBBLED_DEEPSLATE_STORAGE_NAME):
				cs = HCGradingSupport.cobbled_deepslate_storage;
				break;
			case (HCGradingSupport.CALCITE_STORAGE_NAME):
				cs = HCGradingSupport.calcite_storage;
				break;
			case (HCGradingSupport.TUFF_STORAGE_NAME):
				cs = HCGradingSupport.tuff_storage;
				break;
			case (HCGradingSupport.NETHERRACK_STORAGE_NAME):
				cs = HCGradingSupport.netherrack_storage;
				break;
			case (HCGradingSupport.SANDSTONE_STORAGE_NAME):
				cs = HCGradingSupport.sandstone_storage;
				break;
		}
		if(cs.getConfig().contains(uuid)) {
			count = cs.getConfig().getInt(uuid) - minus;
			if(count < 0) {
				cs.getConfig().set(uuid,0);
				minus = minus + count;
				count = 0;
			}else {
				cs.getConfig().set(uuid,count);
			}
			cs.saveConfig();
		}
		int[] storage = {minus,count};
		return storage;
	}

	public int[] minusGlovalStorage(String material,int minus) {
		CustomConfig cs = HCGradingSupport.gloval_storage;

		int count = 0;
		if(cs.getConfig().contains(material)) {
			count = cs.getConfig().getInt(material) - minus;
			if(count < 0) {
				cs.getConfig().set(material,0);
				minus = minus + count;
				count = 0;
			}else {
				cs.getConfig().set(material,count);
			}
			cs.saveConfig();
		}
		int[] storage = {minus,count};
		return storage;
	}
}
