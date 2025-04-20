package com.epf.API.Controller;

import com.epf.API.DTO.PlantDTO;
import com.epf.CORE.interfaceService.PlantService;
import com.epf.CORE.models.Plant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")
@CrossOrigin(origins = "http://localhost:5173")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // Récupérer toutes les plantes
    @GetMapping
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        List<Plant> plants = plantService.getAllPlants();
        List<PlantDTO> plantDTOs = plants.stream()
            .map(p -> new PlantDTO(
                p.getIdPlant(),
                p.getName(),
                p.getHealth(),
                p.getDamage(),
                p.getDamagepersec(),
                p.getCost(),
                p.getSunpersec(),
                p.getEffect(),
                p.getPathimage()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(plantDTOs);
    }

    // Récupérer une plante par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable("id") int id) {
        Plant plant = plantService.getAllPlants().stream()
            .filter(p -> p.getIdPlant() == id)
            .findFirst()
            .orElse(null);
            
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }

        PlantDTO plantDTO = new PlantDTO(
            plant.getIdPlant(),
            plant.getName(),
            plant.getHealth(),
            plant.getDamage(),
            plant.getDamagepersec(),
            plant.getCost(),
            plant.getSunpersec(),
            plant.getEffect(),
            plant.getPathimage()
        );
        
        return ResponseEntity.ok(plantDTO);
    }

    // Créer une nouvelle plante
    @PostMapping
    public ResponseEntity<PlantDTO> createPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getId(),
            plantDTO.getName(),
            plantDTO.getHealth(),
            plantDTO.getDamage(),
            plantDTO.getDamagepersec(),
            plantDTO.getCost(),
            plantDTO.getSunpersec(),
            plantDTO.getEffect(),
            plantDTO.getPathimage()
        );

        plantService.create(plant);
        return ResponseEntity.ok(plantDTO);
    }

    // Mettre à jour une plante existante
    @PutMapping("/{id}")
    public ResponseEntity<PlantDTO> updatePlant(@PathVariable("id") int id, @RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getId(),
            plantDTO.getName(),
            plantDTO.getHealth(),
            plantDTO.getDamage(),
            plantDTO.getDamagepersec(),
            plantDTO.getCost(),
            plantDTO.getSunpersec(),
            plantDTO.getEffect(),
            plantDTO.getPathimage()
        );
        // S'assurer que l'ID correspond à celui du chemin
        plant.setIdPlant(id);
        plantService.update(plant);
        return ResponseEntity.ok(plantDTO);
    }

    // Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable("id") int id) {
        Plant plant = plantService.getAllPlants().stream()
        .filter(p -> p.getIdPlant() == id)
        .findFirst()
        .orElse(null);
    
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }
        
        plantService.delete(plant);
        return ResponseEntity.ok().build();
    }
}

