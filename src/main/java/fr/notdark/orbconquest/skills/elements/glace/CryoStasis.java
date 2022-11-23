package fr.notdark.orbconquest.skills.elements.glace;

import fr.notdark.orbconquest.Main;
import fr.notdark.orbconquest.managers.SkillsManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class CryoStasis implements Listener {

    private final Main main;

    public CryoStasis(Main main) {
        this.main = main;
    }

    public String getName() {
        return "§f§lCryo Stasis";
    }

    private List<Block> blocks = new ArrayList<>();
    private void setIce(Location location){
        if(location.getBlock().getType() == Material.AIR){
            location.getBlock().setType(Material.ICE);
            blocks.add(location.getBlock());
        }
    }

    @EventHandler
    public void event(PlayerInteractEvent e){
        if(e.getPlayer().getItemInHand() == null) return;
        if(e.getPlayer().getItemInHand().getItemMeta() == null) return;
        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName() == null) return;

        if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(getName())){
            Player player = e.getPlayer();

            Location base = player.getLocation();

            setIce(base.add(1, 0, 0));
            setIce(base.add(-1, 0, 0));
            setIce(base.add(0, 0, 1));
            setIce(base.add(0, 0, -1));

            setIce(base.add(1, 1, 0));
            setIce(base.add(-1, 1, 0));
            setIce(base.add(0, 1, 1));
            setIce(base.add(0, 1, -1));

            setIce(base.add(0, 2, 0));

            Bukkit.getScheduler().runTaskLater(main, new Runnable() {
                @Override
                public void run() {
                    for(Block block : blocks){
                        block.setType(Material.AIR);
                    }
                    blocks.clear();
                }
            }, 100L);

        }
    }

    @EventHandler
    public void event(BlockBreakEvent e){
        if(blocks.contains(e.getBlock())){
            e.setCancelled(true);
        }
    }
}
