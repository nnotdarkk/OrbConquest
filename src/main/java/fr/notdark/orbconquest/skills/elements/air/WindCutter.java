package fr.notdark.orbconquest.skills.elements.air;

import org.bukkit.Location;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class WindCutter implements Listener {

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

            ArmorStand as = loc.getWorld().spawn(loc, ArmorStand.class);

            as.setGravity(false);
            as.setCanPickupItems(false);
            as.setCustomNameVisible(false);
            as.setVisible(false);
            as.setHelmet(new ItemStack(Material.DIAMOND_HELMET));

            as.setVelocity(e.getPlayer().getLocation().getDirection().multiply(15));
        }
    }
}

