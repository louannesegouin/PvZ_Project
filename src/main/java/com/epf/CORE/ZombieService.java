package com.epf.CORE;

import java.util.List;
import java.util.Optional;

public interface ZombieService {
    Zombie create(Zombie zombie);                         // Créer un nouveau zombie
    Optional<Zombie> findById(Long id);                   // Trouver un zombie par son ID
    List<Zombie> findAll();                               // Récupérer tous les zombies
    Zombie update(Zombie zombie);                         // Mettre à jour un zombie
    boolean deleteById(Long id);                          // Supprimer un zombie par son ID
}
