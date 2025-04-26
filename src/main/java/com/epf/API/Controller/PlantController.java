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

    /**
     * Récupère toutes les plantes disponibles dans le jeu
     * Convertit chaque Plant en PlantDTO pour l'API
     * @return Une liste de PlantDTO avec le code 200 (OK)
     */
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

    /**
     * Récupère une plante spécifique par son ID
     * @param id L'identifiant unique de la plante recherchée
     * @return La PlantDTO correspondante si trouvée, sinon retourne 404 (Not Found)
     */
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

    /**
     * Crée une nouvelle plante dans la base de données
     * @param plantDTO Les données de la plante à créer
     * @return La PlantDTO créée avec le code 200 (OK)
     */
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

    /**
     * Met à jour une plante existante
     * @param id L'identifiant de la plante à modifier
     * @param plantDTO Les nouvelles données de la plante
     * @return La PlantDTO mise à jour avec le code 200 (OK)
     */
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

    /**
     * Supprime une plante de la base de données
     * @param id L'identifiant de la plante à supprimer
     * @return 200 (OK) si supprimée, 404 (Not Found) si la plante n'existe pas
     */
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

