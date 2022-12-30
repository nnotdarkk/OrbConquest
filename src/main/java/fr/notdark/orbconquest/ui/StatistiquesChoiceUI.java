package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class StatistiquesChoiceUI {

    private final Main main;

    public StatistiquesChoiceUI(Main main) {
        this.main = main;
    }

    public Inventory getInventory(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "Points de statistiques");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 3).setDisplayName(" ").build(false);

        UserManager um = new UserManager(main, player);

        int a = main.getConfigManager().getInt("players-points-start") - main.getGameManager().getPlayerUserPointsStart(player);
        inv.setItem(49, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName(" ").setLoreWithList(Arrays.asList(
                "§8▪ §7Points de statistiques disponibles: §a" + a,
                " "
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTg0YTI3NTU2ZDdhNjc4N2M4YjJhZjhkMjIyMDQ4NzUxODhhNzgyYzYwNDFjNTkwYjIwYjdkNjE0YTk0YTY1ZiJ9fX0=").build(false));

        inv.setItem(20, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§6► STR").setLoreWithList(Arrays.asList(
                " ",
                " §7STR représente votre force (+10 de STR équivaux",
                " §7à +10% de force supplémentaire)",
                " ",
                "§8▪ §7Force actuelle: §6" + um.getInt("str"),
                " ",
                "§eCliquez pour attribuer 10 points de stats",
                "",
                "§c⚠ §cVous ne pourrez pas revenir en",
                "   §carrière, alors réfléchissez bien"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjEzZjc3MGIzMTI5OWM4ZTg0MDNjZWFkZGNjMTZhNzVkNjc1NDVmY2Y5NzEyMjk2YWNjNWRiOGIxZGMzY2VlOCJ9fX0=").build(false));

        inv.setItem(30, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§c► RES").setLoreWithList(Arrays.asList(
                " ",
                " §7RES représente votre résistance (+10 de RES équivaux",
                " §7à +10% de résistance supplémentaire)",
                " ",
                "§8▪ §7Résistance actuelle: §c" + um.getInt("res"),
                " ",
                "§eCliquez pour attribuer 10 points de stats",
                "",
                "§c⚠ §cVous ne pourrez pas revenir en",
                "   §carrière, alors réfléchissez bien"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTRiZDlhNDViOTY4MWNlYTViMjhjNzBmNzVhNjk1NmIxZjU5NGZlYzg0MGI5NjA3Nzk4ZmIxZTcwNzc2NDQzMCJ9fX0=").build(false));

        inv.setItem(22, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§3► AGI").setLoreWithList(Arrays.asList(
                " ",
                " §7AGI représente votre vitesse (+10 de AGI équivaux",
                " §7à +10% de vitesse de marche supplémentaire)",
                " ",
                "§8▪ §7Vitesse actuelle: §3" + um.getInt("agi"),
                " ",
                "§eCliquez pour attribuer 10 points de stats",
                "",
                "§c⚠ §cVous ne pourrez pas revenir en",
                "   §carrière, alors réfléchissez bien"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTMwMmYxNGViNjM3MTcxMTI0ZDdhOWY2ZDA1NzM3OWZiODcxMGEyY2U4ZGNjY2MwZWRkNTI5ZGJmZDk3ZTE4NyJ9fX0=").build(false));

        inv.setItem(32, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§a► HP").setLoreWithList(Arrays.asList(
                " ",
                " §7HP représente votre vie (+10 d'HP équivaux",
                " §7à un coeur supplémentaire)",
                " ",
                "§8▪ §7Vie actuelle: §a" + um.getInt("hp"),
                " ",
                "§eCliquez pour attribuer 10 points de stats",
                "",
                "§c⚠ §cVous ne pourrez pas revenir en",
                "   §carrière, alors réfléchissez bien"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGJkMmUzZmYzZjc5OGJmNjc3MjkxZDE3NGQyZGM0ZDM4NzZkNjNiMzA4OGFmMWE5YWFiMDJiMDc5MDRlNDEzMCJ9fX0=").build(false));

        inv.setItem(24, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§b► MP").setLoreWithList(Arrays.asList(
                " ",
                " §7MP représente votre mana (Indispensable pour",
                " §7lancer des sorts)",
                " ",
                "§8▪ §7Mana actuel: §b" + um.getInt("mp"),
                " ",
                "§eCliquez pour attribuer 10 points de stats",
                "",
                "§c⚠ §cVous ne pourrez pas revenir en",
                "   §carrière, alors réfléchissez bien"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzY5MGQ0YjQ2M2VhYzM3ZmZkYWFiMmVhOGQzODQ2N2MxZWZkMWI4ZmU5MDZhNDQ3NTk5YzMxZWNiZDY5YTUyNCJ9fX0=").build(false));

        inv.setItem(0, vitre);
        inv.setItem(1, vitre);
        inv.setItem(7, vitre);
        inv.setItem(8, vitre);
        inv.setItem(9, vitre);
        inv.setItem(17, vitre);
        inv.setItem(36, vitre);
        inv.setItem(44, vitre);
        inv.setItem(45, vitre);
        inv.setItem(46, vitre);
        inv.setItem(52, vitre);
        inv.setItem(53, vitre);

        return inv;
    }

}
