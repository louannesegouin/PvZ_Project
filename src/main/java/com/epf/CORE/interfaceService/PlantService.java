package com.epf.CORE.interfaceService;

import java.util.List;
import com.epf.CORE.models.Plant;

public interface PlantService {
    void create(Plant plant);                         // Créer une nouvelle plante
    List<Plant> getAllPlants();                       // Récupérer toutes les plantes
    void update(Plant plant);                         // Mettre à jour une plante
    void delete(Plant plant);                         // Supprimer une plante
}
