
package jp.haruserver.mc.hcgradingsupport;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import jp.haruserver.mc.hcgradingsupport.commands.CommandExecuter;
import jp.haruserver.mc.hcgradingsupport.listener.InventoryClickListener;
import jp.haruserver.mc.hcgradingsupport.util.ItemManager;
import jp.haruserver.mc.hcgradingsupport.util.StorageKeys;
import jp.haruserver.mc.hcgradingsupport.util.StorageUtil;
public class HCGradingSupport extends JavaPlugin{

    private final Map<Material, String> storageKeysMap = new HashMap<>();
    private final StorageKeys storageKeys = new StorageKeys(this);
    private final StorageUtil storageUtil = new StorageUtil(this);
    private final ItemManager itemManager = new ItemManager(this);

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadStorageKeys();
        getLogger().info("HCGradingSupport has been enabled.");

        CommandExecuter CommandExecuter = new CommandExecuter(this);
		getCommand("hcgs").setExecutor(CommandExecuter);

        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InventoryClickListener(this),this);

    }

    @Override
    public void onDisable() {
        getLogger().info("HCGradingSupport has been disabled.");
    }

    public Map<Material, String> getStorageKeysMap() {
        return this.storageKeysMap;
    }

    public StorageKeys getStorageKeys() {
        return this.storageKeys;
    }

    public StorageUtil getStorageUtil() {
        return this.storageUtil;
    }

    public ItemManager getItemManager() {
        return this.itemManager;
    }

    private void loadStorageKeys() {
        FileConfiguration config = getConfig();
        ConfigurationSection section = config.getConfigurationSection("storage_keys");
        if (section != null) {
            for (String materialName : section.getKeys(false)) {
                try {
                    Material material = Material.valueOf(materialName);
                    String keyName = section.getString(materialName);
                    storageKeysMap.put(material, keyName);
                    Bukkit.getServer().getLogger().info("Load:" + materialName);
                } catch (IllegalArgumentException ex) {
                    getLogger().warning("無効なMaterial名: " + materialName);
                }
            }
        }
    }
}