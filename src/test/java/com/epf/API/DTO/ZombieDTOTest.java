package com.epf.API.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZombieDTOTest {

    @Test
    void constructorAndGetters() {
        ZombieDTO zombie = new ZombieDTO(1, "Zombie Basic", 100, 1, 20, 2, "zombie.png", 1);
        
        assertEquals(1, zombie.getId_zombie());
        assertEquals("Zombie Basic", zombie.getNom());
        assertEquals(100, zombie.getPoint_de_vie());
        assertEquals(1, zombie.getAttaque_par_seconde());
        assertEquals(20, zombie.getDegat_attaque());
        assertEquals(2, zombie.getVitesse_de_deplacement());
        assertEquals("zombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());
    }

    @Test
    void setters() {
        ZombieDTO zombie = new ZombieDTO();
        
        zombie.setId_zombie(1);
        zombie.setNom("Zombie Basic");
        zombie.setPoint_de_vie(100);
        zombie.setAttaque_par_seconde(1);
        zombie.setDegat_attaque(20);
        zombie.setVitesse_de_deplacement(2);
        zombie.setChemin_image("zombie.png");
        zombie.setId_map(1);

        assertEquals(1, zombie.getId_zombie());
        assertEquals("Zombie Basic", zombie.getNom());
        assertEquals(100, zombie.getPoint_de_vie());
        assertEquals(1, zombie.getAttaque_par_seconde());
        assertEquals(20, zombie.getDegat_attaque());
        assertEquals(2, zombie.getVitesse_de_deplacement());
        assertEquals("zombie.png", zombie.getChemin_image());
        assertEquals(1, zombie.getId_map());
    }
}
