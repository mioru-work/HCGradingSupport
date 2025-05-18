package jp.haruserver.mc.hcgradingsupport.util;

import java.util.Map;

import org.bukkit.Material;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;

public class StorageUtil {

    private final HCGradingSupport HCGradingSupport;
    private final Map<Material,String> storageKeyMap;

	public StorageUtil(HCGradingSupport HCGradingSupport) {
        this.HCGradingSupport = HCGradingSupport;
        this.storageKeyMap = HCGradingSupport.getStorageKeysMap();
	}

	public boolean isSupported(Material material){
		return storageKeyMap.containsKey(material);
	}
}
