package com.epf.API.Controller;

import com.epf.API.DTO.ZombieDTO;
import com.epf.CORE.interfaceService.ZombieService;
import com.epf.CORE.models.Zombie;
import com.epf.CORE.models.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
@CrossOrigin(origins = "http://localhost:5173")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Récupérer tous les zombies
    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAllZombies() {
        List<Zombie> zombies = zombieService.getAllZombies();
        List<ZombieDTO> zombieDTOs = zombies.stream()
            .map(z -> new ZombieDTO(
                z.getId_zombie(),
                z.getNom(),
                z.getPoint_de_vie(),
                z.getAttaque_par_seconde(),
                z.getDegat_attaque(),
                z.getVitesse_de_deplacement(),
                z.getChemin_image(),
                z.getId_map()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(zombieDTOs);
    }

    // Récupérer un zombie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombieById(@PathVariable("id") int id) {
        Zombie zombie = zombieService.getAllZombies().stream()
            .filter(z -> z.getId_zombie() == id)
            .findFirst()
            .orElse(null);
            
        if (zombie == null) {
            return ResponseEntity.notFound().build();
        }

        ZombieDTO zombieDTO = new ZombieDTO(
            zombie.getId_zombie(),
            zombie.getNom(),
            zombie.getPoint_de_vie(),
            zombie.getAttaque_par_seconde(),
            zombie.getDegat_attaque(),
            zombie.getVitesse_de_deplacement(),
            zombie.getChemin_image(),
            zombie.getId_map()
        );
        
        return ResponseEntity.ok(zombieDTO);
    }

    // Créer un nouveau zombie
    @PostMapping
    public ResponseEntity<ZombieDTO> createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = new Zombie(
            zombieDTO.getId_zombie(),
            zombieDTO.getNom(),
            zombieDTO.getPoint_de_vie(),
            zombieDTO.getAttaque_par_seconde(),
            zombieDTO.getDegat_attaque(),
            zombieDTO.getVitesse_de_deplacement(),
            zombieDTO.getChemin_image(),
            zombieDTO.getId_map()
        );

        zombieService.create(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    // Mettre à jour un zombie existant
    @PutMapping("/{id}")
    public ResponseEntity<ZombieDTO> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        // S'assurer que l'ID correspond à celui du chemin
        Zombie zombie = new Zombie(
            id,
            zombieDTO.getNom(),
            zombieDTO.getPoint_de_vie(),
            zombieDTO.getAttaque_par_seconde(),
            zombieDTO.getDegat_attaque(),
            zombieDTO.getVitesse_de_deplacement(),
            zombieDTO.getChemin_image(),
            zombieDTO.getId_map()
        );

        zombieService.update(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    // Supprimer un zombie 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable("id") int id_map) {
        Zombie zombie = zombieService.getAllZombies().stream()
        .filter(z -> z.getId_zombie() == id_map)
        .findFirst()
        .orElse(null);
    
        if (zombie == null) {
            return ResponseEntity.notFound().build();
        }
        
        zombieService.delete(zombie);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/map/{id_map}")
    public ResponseEntity<List<ZombieDTO>> getZombiesFromMap(@PathVariable("id_map") int id_map) {
        Map map = new Map();
        map.setId_Map(id_map);
        List<Zombie> zombies = zombieService.getZombiesFromMap(map);
        List<ZombieDTO> zombieDTOs = zombies.stream()
            .map(z -> new ZombieDTO(
                z.getId_zombie(),
                z.getNom(),
                z.getPoint_de_vie(),
                z.getAttaque_par_seconde(),
                z.getDegat_attaque(),
                z.getVitesse_de_deplacement(),
                z.getChemin_image(),
                z.getId_map()
            ))
            .collect(Collectors.toList());
        return ResponseEntity.ok(zombieDTOs);
    }
}
