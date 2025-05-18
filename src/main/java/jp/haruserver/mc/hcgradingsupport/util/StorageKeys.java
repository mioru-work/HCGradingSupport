package jp.haruserver.mc.hcgradingsupport.util;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import jp.haruserver.mc.hcgradingsupport.HCGradingSupport;

public class StorageKeys {

    private final HCGradingSupport HCGradingSupport;
    private final Map<Material,String> storageKeyMap;

    public StorageKeys(HCGradingSupport HCGradingSupport) {
        this.HCGradingSupport = HCGradingSupport;
        this.storageKeyMap = HCGradingSupport.getStorageKeysMap();
    }

    public int getStoredAmount(Player player, Material material) {
        if (!isSupported(material)) return 0;
        String key = storageKeyMap.get(material);
        NamespacedKey nameSpaceKey = NamespacedKey.fromString(key);
        PersistentDataContainer container = player.getPersistentDataContainer();
        return container.getOrDefault(nameSpaceKey, PersistentDataType.INTEGER, 0);
    }

    public void setStoredAmount(Player player, Material material, int amount) {
        String key = storageKeyMap.get(material);
        NamespacedKey nameSpaceKey = NamespacedKey.fromString(key);
        PersistentDataContainer container = player.getPersistentDataContainer();
        container.set(nameSpaceKey, PersistentDataType.INTEGER,amount);
    }

    public boolean isSupported(Material material) {
        return storageKeyMap.containsKey(material);
    }
}