package fr.notdark.orbconquest.skills.elements.feu;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.enums.GameSorts;
import fr.notdark.orbconquest.events.customs.handlers.ElementsEventHandler;
import fr.notdark.orbconquest.managers.SkillsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireBall implements Listener {


    public String getName() {
        return "§c§lFire Ball";
    }

    boolean isFireball = false;

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        SkillsManager skillsManager = new SkillsManager();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            if(skillsManager.isInElementsCooldown(e.getPlayer(), GameSorts.Fireball)){
                e.getPlayer().sendMessage("§cVous devez attendre " + skillsManager.secondsLeftElementsCooldown(e.getPlayer(), GameSorts.Fireball) +"s avant de pouvoir utiliser cette compétence !");
                return;
            }

            ElementsEventHandler elementsEventHandler = new ElementsEventHandler(e.getPlayer(), GameSorts.Fireball);
            Bukkit.getPluginManager().callEvent(elementsEventHandler);

            SmallFireball fire = e.getPlayer().launchProjectile(SmallFireball.class);
            fire.setBounce(false);
            skillsManager.addElementsCooldown(e.getPlayer(), GameSorts.Fireball, 10);
        }
    }

    @EventHandler
    public void event(ProjectileHitEvent e){
        if(e.getEntity() instanceof SmallFireball){
            World world = e.getEntity().getWorld();
            Location location = e.getEntity().getLocation();
            world.createExplosion(location.getX(), location.getY(), location.getZ(), 4, false, false);
            e.getEntity().getLocation().getBlock().setType(Material.AIR);
            for(Entity entity : e.getEntity().getNearbyEntities(5, 5, 5)){
                entity.setVelocity(new Location(entity.getWorld(), 0, 1, 0).toVector());
            }
            isFireball = true;
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> isFireball = false, 20L);
        }
    }

    @EventHandler
    public void event(EntityDamageEvent e){
        if(e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION){
            if(isFireball){
                e.setDamage(0);
            }
        }
    }

    @EventHandler
    public void event(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof SmallFireball){
            if(e.getEntity() instanceof LivingEntity){
                e.setDamage(0);
            }
        }
    }
}
