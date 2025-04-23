package com.epf.API.DTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapDTOTest {

    @Test
    void constructorAndGetters() {
        MapDTO map = new MapDTO(1, 6, 9, "map.png");
        
        assertEquals(1, map.getId_map());
        assertEquals(6, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("map.png", map.getChemin_image());
    }

    @Test
    void setters() {
        MapDTO map = new MapDTO();
        
        map.setId_map(1);
        map.setLigne(6);
        map.setColonne(9);
        map.setChemin_image("map.png");

        assertEquals(1, map.getId_map());
        assertEquals(6, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("map.png", map.getChemin_image());
    }
}
