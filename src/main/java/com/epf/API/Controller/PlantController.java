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
                p.getId_plante(),
                p.getNom(),
                p.getPoint_de_vie(),
                p.getAttaque_par_seconde(),
                p.getDegat_attaque(),
                p.getCout(),
                p.getSoleil_par_seconde(),
                p.getEffet(),
                p.getChemin_image()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(plantDTOs);
    }

    // Récupérer une plante par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable("id") int id) {
        Plant plant = plantService.getAllPlants().stream()
            .filter(p -> p.getId_plante() == id)
            .findFirst()
            .orElse(null);
            
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }

        PlantDTO plantDTO = new PlantDTO(
            plant.getId_plante(),
            plant.getNom(),
            plant.getPoint_de_vie(),
            plant.getAttaque_par_seconde(),
            plant.getDegat_attaque(),
            plant.getCout(),
            plant.getSoleil_par_seconde(),
            plant.getEffet(),
            plant.getChemin_image()
        );
        
        return ResponseEntity.ok(plantDTO);
    }

    // Créer une nouvelle plante
    @PostMapping
    public ResponseEntity<PlantDTO> createPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getId_plante(),
            plantDTO.getNom(),
            plantDTO.getPoint_de_vie(),
            plantDTO.getAttaque_par_seconde(),
            plantDTO.getDegat_attaque(),
            plantDTO.getCout(),
            plantDTO.getSoleil_par_seconde(),
            plantDTO.getEffet(),
            plantDTO.getChemin_image()
        );

        plantService.create(plant);
        return ResponseEntity.ok(plantDTO);
    }

    // Mettre à jour une plante existante
    @PutMapping("/{id}")
    public ResponseEntity<PlantDTO> updatePlant(@PathVariable("id") int id, @RequestBody PlantDTO plantDTO) {
        Plant plant = new Plant(
            plantDTO.getId_plante(),
            plantDTO.getNom(),
            plantDTO.getPoint_de_vie(),
            plantDTO.getAttaque_par_seconde(),
            plantDTO.getDegat_attaque(),
            plantDTO.getCout(),
            plantDTO.getSoleil_par_seconde(),
            plantDTO.getEffet(),
            plantDTO.getChemin_image()
        );
        // S'assurer que l'ID correspond à celui du chemin
        plant.setId_plante(id);
        plantService.update(plant);
        return ResponseEntity.ok(plantDTO);
    }

    // Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable("id") int id) {
        Plant plant = plantService.getAllPlants().stream()
        .filter(p -> p.getId_plante() == id)
        .findFirst()
        .orElse(null);
    
        if (plant == null) {
            return ResponseEntity.notFound().build();
        }
        
        plantService.delete(plant);
        return ResponseEntity.ok().build();
    }
}

