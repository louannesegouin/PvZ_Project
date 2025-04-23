package com.epf.API.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlantDTOTest {

    @Test
    void constructorAndGetters() {
        PlantDTO plant = new PlantDTO(1, "Tournesol", 100, 0.0, 0, 50, 25.0, "Produit du soleil", "tournesol.png");
        
        assertEquals(1, plant.getId_plante());
        assertEquals("Tournesol", plant.getNom());
        assertEquals(100, plant.getPoint_de_vie());
        assertEquals(0.0, plant.getAttaque_par_seconde());
        assertEquals(0, plant.getDegat_attaque());
        assertEquals(50, plant.getCout());
        assertEquals(25.0, plant.getSoleil_par_seconde());
        assertEquals("Produit du soleil", plant.getEffet());
        assertEquals("tournesol.png", plant.getChemin_image());
    }

    @Test
    void setters() {
        PlantDTO plant = new PlantDTO();
        
        plant.setId_plante(1);
        plant.setNom("Tournesol");
        plant.setPoint_de_vie(100);
        plant.setAttaque_par_seconde(0.0);
        plant.setDegat_attaque(0);
        plant.setCout(50);
        plant.setSoleil_par_seconde(25.0);
        plant.setEffet("Produit du soleil");
        plant.setChemin_image("tournesol.png");

        assertEquals(1, plant.getId_plante());
        assertEquals("Tournesol", plant.getNom());
        assertEquals(100, plant.getPoint_de_vie());
        assertEquals(0.0, plant.getAttaque_par_seconde());
        assertEquals(0, plant.getDegat_attaque());
        assertEquals(50, plant.getCout());
        assertEquals(25.0, plant.getSoleil_par_seconde());
        assertEquals("Produit du soleil", plant.getEffet());
        assertEquals("tournesol.png", plant.getChemin_image());
    }
}
