package jp.haruserver.mc.hcgradingsupport.util;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class PlayerMetaManager {

	public void setMetadata(Player player, String key, Object value, Plugin plugin) {
		player.setMetadata(key, new FixedMetadataValue(plugin, value));
	}

	public MetadataValue getMetadata(Player player, String key, Plugin plugin) {
		List<MetadataValue> values = player.getMetadata(key);
		for (MetadataValue value : values) {
			if (value.getOwningPlugin().getDescription().getName().equals(plugin.getDescription().getName())) {
				return value;
			}
		}
		return null;
	}
}

