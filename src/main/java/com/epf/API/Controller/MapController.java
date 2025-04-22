package com.epf.API.Controller;

import com.epf.API.DTO.MapDTO;
import com.epf.CORE.interfaceService.MapService;
import com.epf.CORE.interfaceService.ZombieService;
import com.epf.CORE.models.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/maps")
@CrossOrigin(origins = "http://localhost:5173")
public class MapController {
    private final MapService mapService;
    private final ZombieService zombieService;

    public MapController(MapService mapService, ZombieService zombieService) {
        this.mapService = mapService;
        this.zombieService = zombieService;
    }

    // Récupérer toutes les maps 
    @GetMapping
    public ResponseEntity<List<MapDTO>> getAllMaps() {
        List<Map> maps = mapService.getAllMaps();
        List<MapDTO> mapDTOs = maps.stream()
                .map(m -> new MapDTO(
                    m.getId_Map(),
                    m.getLigne(),
                    m.getColonne(),
                    m.getChemin_image()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(mapDTOs);
    }

    // Récupérer une map par son ID
    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getMapById(@PathVariable("id") int id) {
        Map map = mapService.getAllMaps().stream()
            .filter(m -> m.getId_Map() == id)
            .findFirst()
            .orElse(null);
            
        if (map == null) {
            return ResponseEntity.notFound().build();
        }

        MapDTO mapDTO = new MapDTO(
            map.getId_Map(),
            map.getLigne(),
            map.getColonne(),
            map.getChemin_image()
        );
        
        return ResponseEntity.ok(mapDTO);
    }

    // Créer une nouvelle map
    @PostMapping
    public ResponseEntity<MapDTO> createMap(@RequestBody MapDTO mapDTO) {
        Map map = new Map(
            mapDTO.getId_map(),
            mapDTO.getLigne(),
            mapDTO.getColonne(),
            mapDTO.getChemin_image()
        );
        mapService.create(map);
        return ResponseEntity.ok(mapDTO);
    }

    // Mettre à jour une map existante
    @PutMapping("/{id}")
    public ResponseEntity<MapDTO> updateMap(@PathVariable("id") int id, @RequestBody MapDTO mapDTO) {
        Map map = new Map(
            id,
            mapDTO.getLigne(),
            mapDTO.getColonne(),
            mapDTO.getChemin_image()
        );
        // On s'assure que l'ID de la map correspond à celui passé en paramètre
        mapService.update(map);
        return ResponseEntity.ok(mapDTO);
    }

    // Supprimer une map
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable("id_map") int id) {
        Map map = mapService.getAllMaps().stream()
        .filter(m -> m.getId_Map() == id)
        .findFirst()
        .orElse(null);
    
        if (map == null) {
            return ResponseEntity.notFound().build();
        }
        
        zombieService.deleteZombieFromMap(map);
        mapService.delete(map);
        return ResponseEntity.ok().build();
    }
}
