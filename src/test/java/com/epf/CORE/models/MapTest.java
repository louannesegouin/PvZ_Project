package com.epf.CORE.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void constructorAndGetters() {
        Map map = new Map(1, 6, 9, "map.png");
        
        assertEquals(1, map.getId_Map());
        assertEquals(6, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("map.png", map.getChemin_image());
    }

    @Test
    void setters() {
        Map map = new Map();
        
        map.setId_Map(1);
        map.setLigne(6);
        map.setColonne(9);
        map.setChemin_image("map.png");

        assertEquals(1, map.getId_Map());
        assertEquals(6, map.getLigne());
        assertEquals(9, map.getColonne());
        assertEquals("map.png", map.getChemin_image());
    }

    @Test
    void invalidValues() {
        Map map = new Map();
        
        assertThrows(IllegalArgumentException.class, () -> map.setLigne(-1));
        assertThrows(IllegalArgumentException.class, () -> map.setColonne(-1));
    }
}
