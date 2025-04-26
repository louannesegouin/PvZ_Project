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

    /**
     * Récupère tous les zombies disponibles dans le jeu
     * Convertit chaque Zombie en ZombieDTO pour l'API
     * @return Une liste de ZombieDTO avec le code 200 (OK)
     */
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

    /**
     * Récupère un zombie spécifique par son ID
     * @param id L'identifiant unique du zombie recherché
     * @return Le ZombieDTO correspondant si trouvé, sinon retourne 404 (Not Found)
     */
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

    /**
     * Crée un nouveau zombie dans la base de données
     * @param zombieDTO Les données du zombie à créer
     * @return Le ZombieDTO créé avec le code 200 (OK)
     */
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

    /**
     * Met à jour un zombie existant
     * @param id L'identifiant du zombie à modifier
     * @param zombieDTO Les nouvelles données du zombie
     * @return Le ZombieDTO mis à jour avec le code 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<ZombieDTO> updateZombie(@PathVariable("id") int id, @RequestBody ZombieDTO zombieDTO) {
        // S'assurer que l'ID correspond à celui du chemin
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

        zombieService.update(zombie);
        return ResponseEntity.ok(zombieDTO);
    }

    /**
     * Supprime un zombie de la base de données
     * @param id L'identifiant du zombie à supprimer
     * @return 200 (OK) si supprimé, 404 (Not Found) si le zombie n'existe pas
     */
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

    /**
     * Récupère tous les zombies associés à une map spécifique
     * @param id_map L'identifiant de la map
     * @return Une liste de ZombieDTO présents sur la map avec le code 200 (OK)
     */
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
