package com.epf;

// Imports nécessaires pour les fonctionnalités Spring et les modèles de données
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.epf.CORE.models.Map;
import com.epf.CORE.models.Plant;
import com.epf.CORE.models.Zombie;
import com.epf.PERSISTANCE.Config.DataBaseConfiguration;
import com.epf.PERSISTANCE.ImplementationDAO.MapDaoImpl;
import com.epf.PERSISTANCE.ImplementationDAO.PlantDaoImpl;
import com.epf.PERSISTANCE.ImplementationDAO.ZombieDaoImpl;

// Annotation indiquant à Spring de scanner ce package pour trouver les composants
@ComponentScan(basePackages = "com.epf")
public class Main {
    /**
     * Méthode qui affiche la liste des plantes avec leurs caractéristiques
     * @param plants Liste des plantes à afficher
     */
    private static void displayPlants(List<Plant> plants) {
        System.out.println("\n=== PLANTES ===");
        for (Plant plant : plants) {
            // Affichage des attributs de chaque plante
            System.out.println("ID: " + plant.getId_plante());
            System.out.println("Nom: " + plant.getNom());
            System.out.println("PV: " + plant.getPoint_de_vie());
            System.out.println("Coût: " + plant.getCout());
            System.out.println("Dégâts: " + plant.getDegat_attaque());
            System.out.println("Attaque/s: " + plant.getAttaque_par_seconde());
            System.out.println("Soleil/s: " + plant.getSoleil_par_seconde());
            System.out.println("Effet: " + plant.getEffet());
            System.out.println("--------------------");
        }
    }

    /**
     * Méthode qui affiche la liste des zombies avec leurs caractéristiques
     * @param zombies Liste des zombies à afficher
     */
    private static void displayZombies(List<Zombie> zombies) {
        System.out.println("\n=== ZOMBIES ===");
        for (Zombie zombie : zombies) {
            // Affichage des attributs de chaque zombie
            System.out.println("ID: " + zombie.getId_zombie());
            System.out.println("Nom: " + zombie.getNom());
            System.out.println("PV: " + zombie.getPoint_de_vie());
            System.out.println("Attaque/s: " + zombie.getDegat_attaque());
            System.out.println("Dégâts: " + zombie.getAttaque_par_seconde());
            System.out.println("Vitesse: " + zombie.getVitesse_de_deplacement());
            System.out.println("id_map: " + zombie.getId_map());
            System.out.println("--------------------");
        }
    }

    /**
     * Méthode qui affiche la liste des maps avec leurs caractéristiques
     * @param maps Liste des maps à afficher
     */
    private static void displayMaps(List<Map> maps) {
        System.out.println("\n=== MAPS ===");
        for (Map map : maps) {
            // Affichage des attributs de chaque map
            System.out.println("ID: " + map.getId_Map());
            System.out.println("Lignes: " + map.getLigne());
            System.out.println("Colonnes: " + map.getColonne());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        // Création du contexte Spring avec la configuration de la base de données
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfiguration.class)) {
            // Récupération des DAO (Data Access Objects) depuis le contexte Spring
            PlantDaoImpl daoPlant = context.getBean(PlantDaoImpl.class);
            ZombieDaoImpl daoZombie = context.getBean(ZombieDaoImpl.class);
            MapDaoImpl daoGameMap = context.getBean(MapDaoImpl.class);
            
            // Récupération des données depuis la base de données
            List<Plant> plants = daoPlant.getAllPlants();
            List<Map> maps = daoGameMap.getAllMaps();
            List<Zombie> zombies = daoZombie.getAllZombies();
            // Ligne commentée pour récupérer les zombies d'une map spécifique
            //List<Zombie> zombiesFromMap = daoZombie.getZombiesFromMap(maps.get(0));
            
            // Effacement de la console pour plus de clarté
            System.out.println("\033c");

            // Affichage des données récupérées
            displayPlants(plants);
            displayZombies(zombies);
            //displayZombies(zombiesFromMap);
            displayMaps(maps);
        }
    }
}