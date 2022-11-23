package fr.notdark.orbconquest.skills.elements.feu;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameElements;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class FlareAccel implements Listener {

    private final Main main;
    private SkillsManager skillsManager;
    private boolean flareAccel = false;

    public FlareAccel(Main main) {
        this.main = main;
        this.skillsManager = new SkillsManager();
    }

    public String getName() {
        return "§c§lFlare Accel";
    }

    private void setFire(Location location){
        if(location.getBlock().getType() == Material.AIR){
            location.getBlock().setType(Material.FIRE);
        }
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        Player player = e.getPlayer();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            if(!player.isOnGround()){
                player.sendMessage("§cVous devez être au sol pour utiliser cette compétence !");
                return;
            }

            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(player, GameElements.FlareAccel);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            Location base = player.getLocation();

            setFire(base);
            setFire(base.add(1, 0, 0));
            setFire(base.add(0, 0, 1));
            setFire(base.add(-1, 0, 0));
            setFire(base.add(0, 0, -1));
            setFire(base.add(1, 0, 1));
            setFire(base.add(-1, 0, 1));
            setFire(base.add(1, 0, -1));
            setFire(base.add(-1, 0, -1));

            if(base.getBlock().getType() == Material.AIR){
                base.getBlock().setType(Material.FIRE);
            }

            player.getLocation().getBlock().setType(Material.FIRE);
            Vector unitVector = new Vector(player.getLocation().getDirection().getX(), 0, player.getLocation().getDirection().getZ());
            unitVector = unitVector.normalize();
            player.setVelocity(unitVector.multiply(15));

            player.getWorld().playSound(player.getLocation(), Sound.FIREWORK_BLAST, 3.0F, 1.0F);

            base.getWorld().createExplosion(base.getX(), base.getY(), base.getZ(), 2, false, false);

            skillsManager.setFlareAccel(player, true);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> skillsManager.setFlareAccel(player, false), 2 * 20L);

            flareAccel = true;
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> flareAccel = false, 20L);
        }
    }

    @EventHandler
    public void event(PlayerMoveEvent e){
        if(skillsManager.isInFlareAccel(e.getPlayer())){
            Cuboid cuboid = new Cuboid(e.getPlayer().getLocation().add(2, 2, 2), e.getPlayer().getLocation().add(-2, -2, -2));
            for(Player p : Bukkit.getOnlinePlayers()){
                Location l = p.getLocation();
                if(cuboid.contains(l)){
                    if(p == e.getPlayer()){
                        return;
                    }
                    /*if(skillsManager.isFlamedByFlareAccel(p)){
                        return;
                    }*/
                    p.setFireTicks(120);
                    /*skillsManager.addFlamedByFlareAccel(p);
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> skillsManager.removeFlamedByFlareAccel(p), 2 * 20L);*/
                }
            }
        }
    }

    @EventHandler
    public void event(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION){
            if(flareAccel){
                e.setDamage(0);
            }
        }
    }
}
