package cx.rain.mc.server_links;

import cx.rain.mc.server_links.command.ServerLinksCommand;
import cx.rain.mc.server_links.config.ConfigManager;
import cx.rain.mc.server_links.listener.PlayerLoginListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerLinksPlugin extends JavaPlugin {
    private final ConfigManager configManager;

    public ServerLinksPlugin() {
        configManager = new ConfigManager(this);
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(configManager), this);

        var pluginCommand = getServer().getPluginCommand("serverlinks");
        assert pluginCommand != null;

        var command = new ServerLinksCommand(configManager);
        pluginCommand.setExecutor(command);
        pluginCommand.setTabCompleter(command);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
