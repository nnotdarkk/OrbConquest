package fr.notdark.orbconquest.skills.elements.feu;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSorts;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.tools.Cuboid;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class HellAura implements Listener {

    private final Main main;

    public HellAura(Main main) {
        this.main = main;
    }

    public String getName() {
        return "§c§lHell Aura";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        Player player = e.getPlayer();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(player, GameSorts.HellAura);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            Location loc = e.getPlayer().getLocation();
            main.getParticleManager().spawnCircle(loc, (Packet) main.getParticles().FLAME().packet(true, loc));

            Cuboid cuboid = new Cuboid(loc.add(10, 10, 10), loc.add(-10, -10, -10));
            for(Player p : Bukkit.getOnlinePlayers()){
                if(cuboid.contains(p.getLocation())){
                    if(p != player){
                        p.setFireTicks(120);
                    }
                }
            }
        }
    }
}
