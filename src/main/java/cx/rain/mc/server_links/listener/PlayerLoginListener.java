package cx.rain.mc.server_links.listener;

import com.comphenix.protocol.ProtocolLibrary;
import cx.rain.mc.server_links.PluginConstants;
import cx.rain.mc.server_links.config.ConfigManager;
import cx.rain.mc.server_links.packet.PacketHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerLoginListener implements Listener {

    private final ConfigManager configManager;

    public PlayerLoginListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        if (player.hasPermission(PluginConstants.PERMISSION_USER)) {
            PacketHelper.sendServerLinks(configManager.getLinks(), player);
        }
    }
}
