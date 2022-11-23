package fr.notdark.orbconquest.skills.elements.glace;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.managers.SkillsManager;
import fr.notdark.orbconquest.tools.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class IceAura implements Listener {

    private final Main main;

    private SkillsManager skillsManager;

    public IceAura(Main main) {
        this.main = main;
        this.skillsManager = new SkillsManager();
    }

    public String getName() {
        return "§f§lIce Aura";
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getItem() == null) return;
        if(e.getItem().getItemMeta() == null) return;
        if(e.getItem().getItemMeta().getDisplayName() == null) return;

        SkillsManager skillsManager = new SkillsManager();

        if(e.getItem().getItemMeta().getDisplayName().equals(getName())){
            if(skillsManager.isIceAura(e.getPlayer())){
                e.getItem().getItemMeta().addEnchant(Enchantment.LURE, 1, true);
                skillsManager.addIceAura(e.getPlayer());
                BukkitTask iceAuraRunnable = new IceAuraRunnable(main, e.getPlayer()).runTaskTimer(main, 0, 20);
                skillsManager.addIceAuraRunnable(e.getPlayer(), iceAuraRunnable);
            }

            e.getItem().getItemMeta().removeEnchant(Enchantment.LURE);
            skillsManager.removeIceAura(e.getPlayer());
            skillsManager.getIceAuraRunnable(e.getPlayer()).cancel();
            skillsManager.removeIceAuraRunnable(e.getPlayer());
        }
    }

    private class IceAuraRunnable extends BukkitRunnable {

        private final Player player;
        private final Main main;
        private int timer = 0;

        public IceAuraRunnable(Main main, Player player) {
            this.player = player;
            this.main = main;
        }

        @Override
        public void run() {
            if(timer == 10){
                timer = 0;
                Cuboid cuboid = new Cuboid(player.getLocation().add(10, 10, 10), player.getLocation().add(-10, -10, -10));
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(cuboid.contains(player.getLocation())){
                        //TODO: Réduit l'AGI et la STR de tous les ennemis à 10 blocs de 20
                    }
                }
            }
            timer++;
        }
    }
}
