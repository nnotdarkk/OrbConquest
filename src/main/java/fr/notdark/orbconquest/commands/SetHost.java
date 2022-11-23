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
        Player b = Bukkit.getPlayer(configManager.getHost());
        if(b != null) {
            b.sendMessage("§cVous n'êtes plus l'hôte de la partie !");
            b.getInventory().setItem(8, null);
        }
        configManager.setHost(target.getDisplayName());
        Player a = Bukkit.getServer().getPlayer(configManager.getHost());
        a.getInventory().setItem(8, main.getGameManager().getOptionsHostItem());
        a.sendMessage("§aVous êtes maintenant l'hôte de la partie !");
        sender.sendMessage("§aLe nouveau host est maintenant: " + target.getDisplayName());
        return false;
    }
}
