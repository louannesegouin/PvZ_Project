package com.epf.API.Controller;

import com.epf.API.DTO.PlantDTO;
import com.epf.CORE.interfaceService.PlantService;
import com.epf.CORE.models.Plant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // Conversion de l'entité Plant en PlantDTO
    private PlantDTO convertToDTO(Plant plant) {
        // On utilise le constructeur de PlantDTO puis on affecte damagerpersec via le setter
        PlantDTO dto = new PlantDTO(
                plant.getId(),
                plant.getName(),
                plant.getHealth(),
                plant.getDamage(),
                plant.getCost(),
                plant.getSunpersec(),
                plant.getEffect(),
                plant.getPathimage()
        );
        dto.setDamagerpersec(plant.getDamagerpersec());
        return dto;
    }

    // Conversion de PlantDTO en entité Plant
    private Plant convertToEntity(PlantDTO dto) {
        Plant plant = new Plant();
        plant.setId(dto.getId());
        plant.setName(dto.getName());
        plant.setHealth(dto.getHealth());
        plant.setDamage(dto.getDamage());
        plant.setCost(dto.getCost());
        plant.setSunpersec(dto.getSunpersec());
        plant.setEffect(dto.getEffect());
        plant.setPathimage(dto.getPathimage());
        plant.setDamagerpersec(dto.getDamagerpersec());
        return plant;
    }

    // Récupérer toutes les plantes
    @GetMapping
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        List<Plant> plants = plantService.findAll();
        List<PlantDTO> dtos = plants.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    // Récupérer une plante par son ID
    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlantById(@PathVariable Long id) {
        Optional<Plant> plantOptional = plantService.findById(id);
        if (plantOptional.isPresent()) {
            return new ResponseEntity<>(convertToDTO(plantOptional.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Créer une nouvelle plante
    @PostMapping
    public ResponseEntity<Void> createPlant(@RequestBody PlantDTO plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plantService.create(plant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Mettre à jour une plante existante
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlant(@PathVariable Long id, @RequestBody PlantDTO plantDTO) {
        Plant plant = convertToEntity(plantDTO);
        plant.setId(id);  // S'assurer que l'ID correspond à celui du chemin
        plantService.update(plant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Supprimer une plante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        boolean deleted = plantService.deleteById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

