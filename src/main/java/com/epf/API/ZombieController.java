package com.epf.API;

import com.epf.CORE.Zombie;
import com.epf.CORE.ZombieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    // Méthode utilitaire pour convertir une entité Zombie en ZombieDTO
    private ZombieDTO convertToDTO(Zombie zombie) {
        return new ZombieDTO(
                zombie.getId(),
                zombie.getName(),
                zombie.getHealth(),
                zombie.getDamagepersec(),
                zombie.getDamage(),
                zombie.getSpeed(),
                zombie.getPathimage(),
                zombie.getIdmap()
        );
    }

    // Méthode utilitaire pour convertir un ZombieDTO en entité Zombie
    private Zombie convertToEntity(ZombieDTO zombieDTO) {
        return new Zombie(
                zombieDTO.getId(),
                zombieDTO.getName(),
                zombieDTO.getHealth(),
                zombieDTO.getDamagepersec(),
                zombieDTO.getDamage(),
                zombieDTO.getSpeed(),
                zombieDTO.getPathimage(),
                zombieDTO.getIdmap()
        );
    }

    // Récupérer tous les zombies
    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAllZombies() {
        List<Zombie> zombies = zombieService.findAll();
        List<ZombieDTO> zombieDTOs = zombies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(zombieDTOs, HttpStatus.OK);
    }

    // Récupérer un zombie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getZombieById(@PathVariable Long id) {
        Optional<Zombie> zombieOpt = zombieService.findById(id);
        if (zombieOpt.isPresent()) {
            ZombieDTO dto = convertToDTO(zombieOpt.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Créer un nouveau zombie
    @PostMapping
    public ResponseEntity<Void> createZombie(@RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = convertToEntity(zombieDTO);
        zombieService.create(zombie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Mettre à jour un zombie
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZombie(@PathVariable Long id, @RequestBody ZombieDTO zombieDTO) {
        Zombie zombie = convertToEntity(zombieDTO);
        // S'assurer que l'ID de l'entité correspond à l'ID du chemin
        zombie.setId(id);
        zombieService.update(zombie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Supprimer un zombie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable Long id) {
        boolean deleted = zombieService.deleteById(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
