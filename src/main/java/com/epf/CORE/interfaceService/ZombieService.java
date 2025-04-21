package com.epf.CORE.interfaceService;

import java.util.List;
import com.epf.CORE.models.Zombie;

public interface ZombieService {
    void create(Zombie zombie);                         // Créer un nouveau zombie                  // Trouver un zombie par son ID
    List<Zombie> getAllZombies();                               // Récupérer tous les zombies
    void update(Zombie zombie);                         // Mettre à jour un zombie
    void delete(Zombie zombie);                          // Supprimer un zombie par son ID
}
