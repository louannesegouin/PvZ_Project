package com.epf.CORE.interfaceService;

import java.util.List;
import com.epf.CORE.models.Zombie;
import com.epf.CORE.models.Map;

public interface ZombieService {
    void create(Zombie zombie);                         // Créer un nouveau zombie                  // Trouver un zombie par son ID
    List<Zombie> getAllZombies();                               // Récupérer tous les zombies
    List<Zombie> getZombiesFromMap(Map map);
    void update(Zombie zombie);                         // Mettre à jour un zombie
    void delete(Zombie zombie);                          // Supprimer un zombie par son ID
    void deleteZombieFromMap(Map map); // Supprimer un zombie d'une carte spécifique
}
