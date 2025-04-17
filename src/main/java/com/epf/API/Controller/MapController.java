package com.epf.API.Controller;

import com.epf.API.DTO.MapDTO;
import com.epf.CORE.interfaceService.MapService;
import com.epf.CORE.models.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    // Conversion d'une entité Map en MapDTO
    private MapDTO convertToDTO(Map gameMap) {
        return new MapDTO(
                gameMap.getId(),
                gameMap.getRows(),
                gameMap.getColumns(),
                gameMap.getPathimage()
        );
    }

    // Conversion d'un MapDTO en entité Map
    private Map convertToEntity(MapDTO mapDTO) {
        return new Map(
                mapDTO.getId(),
                mapDTO.getRows(),
                mapDTO.getColumns(),
                mapDTO.getPathimage()
        );
    }

    // Récupérer toutes les maps
    @GetMapping
    public ResponseEntity<List<MapDTO>> getAllMaps() {
        List<Map> maps = mapService.findAll();
        List<MapDTO> mapDTOs = maps.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(mapDTOs, HttpStatus.OK);
    }

    // Récupérer une map par son ID
    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable Long id) {
        Optional<Map> mapOptional = mapService.findById(id);
        if (mapOptional.isPresent()) {
            MapDTO dto = convertToDTO(mapOptional.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Créer une nouvelle map
    @PostMapping
    public ResponseEntity<Void> createMap(@RequestBody MapDTO mapDTO) {
        Map map = convertToEntity(mapDTO);
        mapService.create(map);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Mettre à jour une map existante
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMap(@PathVariable Long id, @RequestBody MapDTO mapDTO) {
        Map map = convertToEntity(mapDTO);
        // On s'assure que l'ID de la map correspond à celui passé en paramètre
        map.setId(id);
        mapService.update(map);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Supprimer une map
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable Long id) {
        boolean deleted = mapService.deleteById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
