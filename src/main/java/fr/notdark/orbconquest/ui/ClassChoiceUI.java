package fr.notdark.orbconquest.ui;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ClassChoiceUI {

    private final Main main;

    public ClassChoiceUI(Main main) {
        this.main = main;
    }

    public Inventory getInventory(){
        Inventory inv = Bukkit.createInventory(null, 54, "Choix de la classe");

        ItemStack vitre = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 5).setDisplayName(" ").build(false);

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

        inv.setItem(20, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§e▸ Guerrier").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("guerrier.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("guerrier.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("guerrier.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("guerrier.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("guerrier.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("guerrier.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("guerrier.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("guerrier.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("guerrier.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("guerrier.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("guerrier.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("guerrier.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("guerrier.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("guerrier.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("guerrier.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("guerrier.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjI1ZjUxZDQ3YTJiNmM4YjVhMDIyNDUzMmE1NWM5MzgwNGM1YjU3NDY5OTlhODU5NTBjNTgyYTgyZjExMDVlNiJ9fX0=").build(false));

        inv.setItem(21, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§c▸ Tank").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("tank.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("tank.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("tank.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("tank.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("tank.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("tank.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("tank.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("tank.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("tank.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("tank.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("tank.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("tank.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("tank.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("tank.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("tank.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("tank.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmViZjgxYmMwN2M1Zjg2NzY1ZmMwZjcxZTUxNmI3YWI3YjgyYWE2MzlkOTRkYjA5MWZkOTJlMDYxYWIzMDVjIn19fQ==").build(false));

        inv.setItem(22, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§d▸ Mage").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("mage.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("mage.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("mage.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("mage.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("mage.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("mage.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("mage.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("mage.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("mage.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("mage.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("mage.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("mage.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("mage.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("mage.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("mage.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("mage.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdmZDlkYjBjYThiY2I5NWJmYWI0NmZjM2VlYjYzMTBmNjUyZDRhMjY4ZjQ3ZGIxOWJjYTI3ZjY3NzM5YjM5MiJ9fX0=").build(false));

        inv.setItem(23, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§2▸ Invocateur").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("invocateur.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("invocateur.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("invocateur.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("invocateur.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("invocateur.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("invocateur.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("invocateur.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("invocateur.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("invocateur.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("invocateur.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("invocateur.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("invocateur.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("invocateur.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("invocateur.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("invocateur.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("invocateur.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWZkODk1Y2ExMTMxZWIwOGYzNTAxNGNkNjUwOTVhNjhjNGRhMDE3OGQxZDMwNWIyZmEyOTM5NTIxM2YxYTYzMyJ9fX0=").build(false));

        inv.setItem(24, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§b▸ Support").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("support.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("support.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("support.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("support.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("support.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("support.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("support.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("support.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("support.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("support.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("support.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("support.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("support.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("support.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("support.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("support.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDgxYTViMzBmYzQ1MjkyOWE1OTc3ODMwYTgyOWRhYzU4ZjRhNjA4MDFlM2QyMDQ0MjM0OWU5YWYzZjZhZjU3YSJ9fX0=").build(false));

        inv.setItem(30, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§f▸ Archer").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("archer.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("archer.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("archer.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("archer.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("archer.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("archer.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("archer.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("archer.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("archer.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("archer.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("archer.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("archer.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("archer.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("archer.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("archer.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("archer.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkzZWU1YmIwYzdmYWNjYTBmM2RmZTA5NDMwYzViODRhOTBlNjU4OGQwYTEwOTlkYTg1YjZlYWViODk1OGY5YSJ9fX0=").build(false));

        inv.setItem(32, new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setDisplayName("§9▸ Aassassin").setLoreWithList(Arrays.asList(
                " ",
                "§8▪ §7STR: §6" + main.getClassesManager().getInt("assassin.str"),
                "§8▪ §7RES: §c" + main.getClassesManager().getInt("assassin.res"),
                "§8▪ §7AGI: §3" + main.getClassesManager().getInt("assassin.agi"),
                "§8▪ §7HP: §a" + main.getClassesManager().getInt("assassin.hp"),
                "§8▪ §7MP: §b" + main.getClassesManager().getInt("assassin.mp"),
                " ",
                "§8▪ §7Pièces d'armure: §e" + main.getClassesManager().getInt("assassin.armure.nombre"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("assassin.armure.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Type d'épée: §e" + main.getClassesManager().getString("assassin.epee.type").replaceAll("DIAMOND_SWORD", "§bÉpée en diamant").replaceAll("IRON_SWORD", "§fÉpée en fer"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("assassin.epee.enchant").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Sharpness").replaceAll(":", " "),
                " ",
                "§8▪ §7Arc: §e" + main.getClassesManager().getBooleanToString("assassin.arc.boolean"),
                "§8▪ §7Enchantement(s): §e" + main.getClassesManager().getStringListNonNull("assassin.arc.enchants").toString().replaceAll("\\[", "§d").replaceAll("]", "").replaceAll("PROTECTION_ENVIRONMENTAL", "Protection").replaceAll("DAMAGE_ALL", "Power").replaceAll(":", " "),
                "§8▪ §7Fleches: §f" + main.getClassesManager().getInt("assassin.arc.fleches"),
                " ",
                "§8▪ §7Elements: §9" + main.getClassesManager().getInt("assassin.elementsMax"),
                "§8▪ §7Sorts: §9" + main.getClassesManager().getInt("assassin.sortsMax"),
                "§8▪ §7Skills de classe: §2" + main.getClassesManager().getInt("assassin.skillsClassesMax"),
                "§8▪ §7Skills classiques: §2" + main.getClassesManager().getInt("assassin.skillsClassiquesMax"),
                " ",
                "§eClique pour sélectionner cette classe"
        )).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjYzODU4M2NmMmM3NjFmYWMzZjgzOTgyNTg5YWMyNmVlNTc3MWExODM4NjNiNDdhMjQ5MGU0Y2I1MDZhZDI2In19fQ==").build(false));

        return inv;
    }
}
