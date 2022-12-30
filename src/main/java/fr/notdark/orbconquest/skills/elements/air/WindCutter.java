package fr.notdark.orbconquest.skills.elements.air;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.tools.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class WindCutter implements Listener {

    private final Main main;

    public WindCutter(Main main) {
        this.main = main;
    }

    public String getName() {
        return "§a§lWind Cutter";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            Location loc = e.getPlayer().getLocation();
            loc.setPitch(0);

            ArmorStand as = loc.getWorld().spawn(loc, ArmorStand.class);

            as.setCanPickupItems(false);
            as.setCustomNameVisible(false);
            as.setVisible(false);
            ItemStack item = new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setCustomHeadData("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODJkZDUyYTFiZDA3MzNhZTMzMjFmNDE2MmI3OTcyZDk0MzA0YzE1ODVjM2E2MmE0MGViZDZmMDZmMGYyYzRjIn19fQ==").build(false);
            as.setHelmet(item);

            as.setVelocity(as.getLocation().getDirection().multiply(3));

            Bukkit.getScheduler().runTaskTimer(main, () -> {
                if(as.getVelocity().toBlockVector().equals(new Vector(0, 0, 0))){
                    as.remove();
                }


            }, 0, 1L);
        }
    }
}

