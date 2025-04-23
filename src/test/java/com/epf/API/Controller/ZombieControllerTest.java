package com.epf.API.Controller;

import com.epf.API.DTO.ZombieDTO;
import com.epf.CORE.interfaceService.ZombieService;
import com.epf.CORE.models.Zombie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ZombieControllerTest {

    @Mock
    private ZombieService zombieService;

    private ZombieController zombieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        zombieController = new ZombieController(zombieService);
    }

    @Test
    void getAllZombies_ShouldReturnListOfZombies() {
        // Arrange
        Zombie zombie1 = new Zombie(1, "Zombie Basic", 100, 10, 6, 2, "zombie_basic.png", 1);
        Zombie zombie2 = new Zombie(2, "Zombie Cone", 150, 10, 7, 6, "zombie_cone.png", 2);
        when(zombieService.getAllZombies()).thenReturn(Arrays.asList(zombie1, zombie2));

        // Act
        ResponseEntity<List<ZombieDTO>> response = zombieController.getAllZombies();

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(2, response.getBody().size());
        assertEquals("Zombie Basic", response.getBody().get(0).getNom());
    }

    @Test
    void getZombieById_WithValidId_ShouldReturnZombie() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie Basic", 100, 10, 6, 2, "zombie_basic.png", 1);
        when(zombieService.getAllZombies()).thenReturn(Arrays.asList(zombie));

        // Act
        ResponseEntity<ZombieDTO> response = zombieController.getZombieById(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Zombie Basic", response.getBody().getNom());
    }

    @Test
    void getZombieById_WithInvalidId_ShouldReturnNotFound() {
        // Arrange
        when(zombieService.getAllZombies()).thenReturn(Arrays.asList());

        // Act
        ResponseEntity<ZombieDTO> response = zombieController.getZombieById(999);

        // Assert
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void createZombie_ShouldReturnCreatedZombie() {
        // Arrange
        ZombieDTO zombieDTO = new ZombieDTO(1, "Zombie Basic", 100, 10, 6, 2, "zombie_basic.png", 1);

        // Act
        ResponseEntity<ZombieDTO> response = zombieController.createZombie(zombieDTO);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals("Zombie Basic", response.getBody().getNom());
        verify(zombieService).create(any(Zombie.class));
    }

    @Test
    void deleteZombie_WithValidId_ShouldReturnOk() {
        // Arrange
        Zombie zombie = new Zombie(1, "Zombie Basic", 100, 10, 6, 2, "zombie_basic.png", 1);
        when(zombieService.getAllZombies()).thenReturn(Arrays.asList(zombie));

        // Act
        ResponseEntity<Void> response = zombieController.deleteZombie(1);

        // Assert
        assertTrue(response.getStatusCode().is2xxSuccessful());
        verify(zombieService).delete(any(Zombie.class));
    }
}
