
package jp.haruserver.mc.hcgradingsupport;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import jp.haruserver.mc.hcgradingsupport.commands.CommandExecuter;
import jp.haruserver.mc.hcgradingsupport.config.CustomConfig;
import net.milkbowl.vault.economy.Economy;

public class HCGradingSupport extends JavaPlugin{

	//メッセージヘッダ
	public static final String COMMAND_HEADER = ChatColor.AQUA + "[整地支援システム]" + ChatColor.WHITE;
	public static final String COMMAND_HEADER_ERROR = ChatColor.RED + "[整地支援システム]" + ChatColor.WHITE;

	//ストレージファイル名
	public static final String DIRT_STORAGE_NAME = "dirt_storage";
	public static final String COBBLESTONE_STORAGE_NAME = "cobblestone_storage";
	public static final String STONE_STORAGE_NAME = "stone_storage";
	public static final String GRAVEL_STORAGE_NAME = "gravel_storage";
	public static final String SAND_STORAGE_NAME = "sand_storage";

	public static final String GRNAITE_STORAGE_NAME = "granite_storage";
	public static final String DIORITE_STORAGE_NAME = "diorite_storage";
	public static final String ANDESITE_STORAGE_NAME = "andesite_storage";
	public static final String DEEPSLATE_STORAGE_NAME = "deepslate_storage";
	public static final String COBBLED_DEEPSLATE_STORAGE_NAME = "cobbled_deepslate_storage";
	public static final String CALCITE_STORAGE_NAME = "calcite_storage";
	public static final String TUFF_STORAGE_NAME = "tuff_storage";
	public static final String NETHERRACK_STORAGE_NAME = "netherrack_storage";
	public static final String SANDSTONE_STORAGE_NAME = "sandstone_storage";

	public static final String GLOVAL_STORAGE_NAME = "gloval_storage";

	//コンフィグ
	public static CustomConfig dirt_storage = null;
	public static CustomConfig cobblestone_storage = null;
	public static CustomConfig stone_storage = null;
	public static CustomConfig gravel_storage = null;
	public static CustomConfig sand_storage = null;

	public static CustomConfig granite_storage = null;
	public static CustomConfig diorite_storage = null;
	public static CustomConfig andesite_storage = null;
	public static CustomConfig deepslate_storage = null;
	public static CustomConfig cobbled_deepslate_storage = null;
	public static CustomConfig calcite_storage = null;
	public static CustomConfig tuff_storage = null;
	public static CustomConfig netherrack_storage = null;
	public static CustomConfig sandstone_storage = null;

	public static CustomConfig gloval_storage = null;

	public static final int maxItemNum = 999999;
	public static final int maxItemNumGloval = 2000000000;

	//経済関連
	public static final double giveMoneyPerBlock = 0.01;
	public static final double takeMoneyPerBlock = 0.02;
	private static Economy econ = null;

	private static final Logger log = Logger.getLogger("Minecraft");


	public void onLoad(){
		//ストレージファイルロード
		dirt_storage = new CustomConfig(this,DIRT_STORAGE_NAME + ".yml");
		cobblestone_storage = new CustomConfig(this,COBBLESTONE_STORAGE_NAME + ".yml");
		stone_storage = new CustomConfig(this,STONE_STORAGE_NAME + ".yml");
		gravel_storage = new CustomConfig(this,GRAVEL_STORAGE_NAME + ".yml");
		sand_storage = new CustomConfig(this,SAND_STORAGE_NAME + ".yml");

		granite_storage = new CustomConfig(this,GRNAITE_STORAGE_NAME + ".yml");
		diorite_storage = new CustomConfig(this,DIORITE_STORAGE_NAME + ".yml");
		andesite_storage = new CustomConfig(this,ANDESITE_STORAGE_NAME + ".yml");
		deepslate_storage = new CustomConfig(this,DEEPSLATE_STORAGE_NAME + ".yml");
		cobbled_deepslate_storage = new CustomConfig(this,COBBLED_DEEPSLATE_STORAGE_NAME + ".yml");
		calcite_storage = new CustomConfig(this,CALCITE_STORAGE_NAME + ".yml");
		tuff_storage = new CustomConfig(this,TUFF_STORAGE_NAME + ".yml");
		netherrack_storage = new CustomConfig(this,NETHERRACK_STORAGE_NAME + ".yml");
		sandstone_storage = new CustomConfig(this,SANDSTONE_STORAGE_NAME + ".yml");
		gloval_storage = new CustomConfig(this,GLOVAL_STORAGE_NAME + ".yml");

		//ストレージファイルがなければ配置する
		dirt_storage.saveDefaultConfig();
		cobblestone_storage.saveDefaultConfig();
		stone_storage.saveDefaultConfig();
		gravel_storage.saveDefaultConfig();
		sand_storage.saveDefaultConfig();

		granite_storage.saveDefaultConfig();
		diorite_storage.saveDefaultConfig();
		andesite_storage.saveDefaultConfig();
		deepslate_storage.saveDefaultConfig();
		cobbled_deepslate_storage.saveDefaultConfig();
		calcite_storage.saveDefaultConfig();
		tuff_storage.saveDefaultConfig();
		netherrack_storage.saveDefaultConfig();
		sandstone_storage.saveDefaultConfig();
		gloval_storage.saveDefaultConfig();
	}

	public void onEnable() {
		CommandExecuter CommandExecuter = new CommandExecuter();
		getCommand("hcgs").setExecutor(CommandExecuter);

		if (!setupEconomy() ) {
			log.severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}

	}

	public void onDisable() {

	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	public static Economy getEconomy() {
		return econ;
	}
}
