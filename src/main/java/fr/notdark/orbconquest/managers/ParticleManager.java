package fr.notdark.orbconquest.managers;

import fr.notdark.orbconquest.Main;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.Location;

public class ParticleManager {

    private final Main main;

    public ParticleManager(Main main) {
        this.main = main;
    }

    public void spawnParticle(Location location, Packet packet){
        main.getParticles().sendPacket(location, 30D, packet);
    }

    public void spawnCircle(Location location, Packet packet){
        Location loc = location.add(0, 1, 0);
        for (double i = 0; i <= Math.PI; i += Math.PI / 15) {
            double radius = Math.sin(i) * 10;
            double y = Math.cos(i) * 10;
            for (double a = 0; a < Math.PI * 2; a+= Math.PI / 15) {
                double x = Math.cos(a) * radius;
                double z = Math.sin(a) * radius;
                loc.add(x, y, z);
                main.getParticles().sendPacket(loc, 30D, packet);
                loc.subtract(x, y, z);
            }
        }
    }

}
