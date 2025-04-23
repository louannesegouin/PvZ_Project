package com.epf.API.Controller;

import com.epf.API.DTO.MapDTO;
import com.epf.CORE.interfaceService.MapService;
import com.epf.CORE.interfaceService.ZombieService;
import com.epf.CORE.models.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class MapControllerTest {

    @Mock
    private MapService mapService;
    
    @Mock
    private ZombieService zombieService;

    private MapController mapController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mapController = new MapController(mapService, zombieService);
    }

    @Test
    void getAllMaps_ShouldReturnListOfMaps() {
        // Arrange
        Map map1 = new Map(1, 6, 9, "map.png");
        Map map2 = new Map(2, 6, 8, "map2.png");
        when(mapService.getAllMaps()).thenReturn(Arrays.asList(map1, map2));

        // Act
        ResponseEntity<List<MapDTO>> response = mapController.getAllMaps();

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void getMapById_WithValidId_ShouldReturnMap() {
        // Arrange
        Map map = new Map(1, 6, 9, "map.png");
        when(mapService.getAllMaps()).thenReturn(Arrays.asList(map));

        // Act
        ResponseEntity<MapDTO> response = mapController.getMapById(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void getMapById_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        when(mapService.getAllMaps()).thenReturn(Arrays.asList());

        // Act
        ResponseEntity<MapDTO> response = mapController.getMapById(999);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void createMap_ShouldReturnCreatedMap() {
        // Arrange
        MapDTO mapDTO = new MapDTO(1, 6, 9, "map.png");

        // Act
        ResponseEntity<MapDTO> response = mapController.createMap(mapDTO);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(mapService).create(any(Map.class));
    }

    @Test
    void deleteMap_WithValidId_ShouldReturnOk() {
        // Arrange
        Map map = new Map(1, 6, 9, "map.png");
        when(mapService.getAllMaps()).thenReturn(Arrays.asList(map));

        // Act
        ResponseEntity<Void> response = mapController.deleteMap(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(mapService).delete(any(Map.class));
    }
}
