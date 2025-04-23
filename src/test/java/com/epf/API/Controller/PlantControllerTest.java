package com.epf.API.Controller;

import com.epf.API.DTO.PlantDTO;
import com.epf.CORE.interfaceService.PlantService;
import com.epf.CORE.models.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class PlantControllerTest {

    @Mock
    private PlantService plantService;

    private PlantController plantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        plantController = new PlantController(plantService);
    }

    @Test
    void getAllPlants_ShouldReturnListOfPlants() {
        // Arrange
        Plant plant1 = new Plant(1, "Tournesol", 100, 0, 0, 50, 25, "Produit du soleil", "tournesol.png");
        Plant plant2 = new Plant(2, "Pois", 100, 1, 20, 100, 0, "Tire des pois", "pois.png");
        when(plantService.getAllPlants()).thenReturn(Arrays.asList(plant1, plant2));

        // Act
        ResponseEntity<List<PlantDTO>> response = plantController.getAllPlants();

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(2, response.getBody().size());
        assertEquals("Tournesol", response.getBody().get(0).getNom());
        assertEquals("Pois", response.getBody().get(1).getNom());
    }

    @Test
    void getPlantById_WithValidId_ShouldReturnPlant() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 100, 0, 0, 50, 25, "Produit du soleil", "tournesol.png");
        when(plantService.getAllPlants()).thenReturn(Arrays.asList(plant));

        // Act
        ResponseEntity<PlantDTO> response = plantController.getPlantById(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Tournesol", response.getBody().getNom());
    }

    @Test
    void getPlantById_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        when(plantService.getAllPlants()).thenReturn(Arrays.asList());

        // Act
        ResponseEntity<PlantDTO> response = plantController.getPlantById(999);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void createPlant_ShouldReturnCreatedPlant() {
        // Arrange
        PlantDTO plantDTO = new PlantDTO(1, "Tournesol", 100, 0, 0, 50, 25, "Produit du soleil", "tournesol.png");

        // Act
        ResponseEntity<PlantDTO> response = plantController.createPlant(plantDTO);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Tournesol", response.getBody().getNom());
        verify(plantService).create(any(Plant.class));
    }

    @Test
    void deletePlant_WithValidId_ShouldReturnOk() {
        // Arrange
        Plant plant = new Plant(1, "Tournesol", 100, 0, 0, 50, 25, "Produit du soleil", "tournesol.png");
        when(plantService.getAllPlants()).thenReturn(Arrays.asList(plant));

        // Act
        ResponseEntity<Void> response = plantController.deletePlant(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(plantService).delete(any(Plant.class));
    }
}
