package fr.notdark.orbconquest.commands;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHost extends Command {

    private final Main main;
    public SetHost(String name, Main main) {
        super(name);
        this.main = main;
    }

    public boolean execute(CommandSender sender, String label, String[] args) {

        if(!sender.hasPermission("orbconquest.sethost")) {
            sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
            return false;
        }

        if(args.length != 1) {
            sender.sendMessage("§cUsage: /sethost <host>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if(target == null){
            sender.sendMessage("§cCe joueur n'est pas connecté !");
            return true;
        }

        ConfigManager configManager = main.getConfigManager();
        Player b = null;
        if(configManager.getString("host") != null){
            b = Bukkit.getPlayer(configManager.getString("host"));
        }
        if(b != null) {
            if(b.getName().equals(target.getName())) {
                sender.sendMessage("§cCe joueur est déjà l'hôte !");
                return true;
            }

            b.sendMessage("§cVous n'êtes plus l'hôte de la partie !");
            b.getInventory().setItem(8, null);
            b.getInventory().setItem(7, null);
        }

        configManager.setString("host", target.getDisplayName());
        Player a = Bukkit.getServer().getPlayer(configManager.getString("host"));
        a.getInventory().setItem(8, main.getGameManager().getOptionsHostItem());
        a.getInventory().setItem(7, main.getGameManager().getLaunchGameItem());
        a.sendMessage("§aVous êtes maintenant l'hôte de la partie !");
        sender.sendMessage("§aLe nouveau host est maintenant: " + target.getDisplayName());
        return false;
    }
}
