package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.config.user.UserManager;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ElementsChoiceUI {

    private final Main main;

    public ElementsChoiceUI(Main main) {
        this.main = main;
    }

    public Inventory getInventory(Player player){
        Inventory inv = Bukkit.createInventory(null, 54, "Choix des éléments");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 5).setDisplayName(" ").build(false);

        UserManager userManager = new UserManager(main, player);
        String gameClasses = userManager.getClasse().toString().toLowerCase(Locale.ROOT);
        int a = main.getClassesManager().getInt(gameClasses + ".sortsMax");

        inv.setItem(21, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§c▸ Feu").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §cFireBall",
                " §8▪ §cFlare Accel",
                " §8▪ §cHell Aura",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Feu),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmYwZWU2NDdhNjIxMWU1YzJmODE2MTZhNTk3N2E2NTg1MWU0ZGI3ODM0Y2Y0NTAxMjQ2ZGU2YjM5YWRhMzI5MSJ9fX0=").build(false));

        inv.setItem(23, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§9▸ Foudre").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §9Paralyze Shot",
                " §8▪ §9Lightning Bolt",
                " §8▪ §9Thunder",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Foudre),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNlZWQzYjA4ZmEzNDk4MmJjM2ZhYWE5OTM2OTQxYjZjZDAwYWJkMzcxNzNlZTY3YjNjZTNiOWUxOGJmY2E2YyJ9fX0=").build(false));

        inv.setItem(29, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§b▸ Glace").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §bCryo Stasis",
                " §8▪ §bIce Aura",
                " §8▪ §bSnow Ball",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Glace),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTZhYWI1OGZhMDFmY2U5YWY0NjllZDc0N2FlZDgxMWQ3YmExOGM0NzZmNWE3ZjkwODhlMTI5YzMxYjQ1ZjMifX19").build(false));

        inv.setItem(30, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§f▸ Air").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §fAerial Speed",
                " §8▪ §fMist",
                " §8▪ §fWind Cutter",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Air),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY4NmQ5NmFkOGU1OGE4NmE1YTI4MzI2Yzk5ZmRlOWQ0OTgxZTQ2YzA5ZWFlNTFlN2E5ODYxOTBjZDM2YjBmIn19fQ==").build(false));

        inv.setItem(31, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§2▸ Poison").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §2Poison Synthesis",
                " §8▪ §2Poison Ball",
                " §8▪ §2Poison Breath",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Poison),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGQ5ZThkZTFmZTE3NjA4Mzg2OWUzMDI1MjRjNjUwMTBkN2NmMmUzMWIwNjNlYmI4YmM3NmI3OWQxNDEzMCJ9fX0=").build(false));

        inv.setItem(32, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§e▸ Lumière").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §eFlash Bomb",
                " §8▪ §eHeal",
                " §8▪ §eHealing Zone",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Lumiere),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTc2ODJmZDE3YWM0NGI4NmE3MDVjYTA0YzkyNjU0ZTFlZDkxYTI0Zjg4MGFmMmUwOTU0Y2E3NjYyZjQ3NTU1MiJ9fX0=").build(false));

        inv.setItem(33, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§6▸ Invocation").setLoreWithList(Arrays.asList(
                "",
                "§7Maitrisez avec perfection " + a +" sorts",
                "§7parmis les sorts suivants:",
                " §8▪ §6Invocation de zombie",
                " §8▪ §6Invocation de squelette",
                " §8▪ §6Invocation de golem de fer",
                " §8▪ §6Invocation de cheval",
                " §8▪ §6Invocation de lapin",
                " §8▪ §6Invocation de mouton",
                "",
                "§8▪ §7Sélectionné: " + symbol(player, GameElements.Invocation),
                "",
                "§eCliquez pour choisir cet élément"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzNmYWI3NmY3MTgwOTJkNjRiN2IwMGRkYjcyOTMxYzBiMDVlOGNiYjY4NzEwNmMzYzZmMzU2MGY5MzNmOTkzMCJ9fX0=").build(false));

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

    private String symbol(Player player, GameElements element) {
        UserManager um = new UserManager(main, player);
        List<GameElements> elements = um.getElements();
        if(elements.contains(element)) {
            return "§a✔";
        } else {
            return "§c✘";
        }
    }
}
