package com.epf;

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

@ComponentScan(basePackages = "com.epf")
public class Main {
    private static void displayPlants(List<Plant> plants) {
        System.out.println("\n=== PLANTES ===");
        for (Plant plant : plants) {
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

    private static void displayZombies(List<Zombie> zombies) {
        System.out.println("\n=== ZOMBIES ===");
        for (Zombie zombie : zombies) {
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

    private static void displayMaps(List<Map> maps) {
        System.out.println("\n=== MAPS ===");
        for (Map map : maps) {
            System.out.println("ID: " + map.getId());
            System.out.println("Lignes: " + map.getRows());
            System.out.println("Colonnes: " + map.getColumns());
            System.out.println("--------------------");
        }
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataBaseConfiguration.class)) {
            PlantDaoImpl daoPlant = context.getBean(PlantDaoImpl.class);
            ZombieDaoImpl daoZombie = context.getBean(ZombieDaoImpl.class);
            MapDaoImpl daoGameMap = context.getBean(MapDaoImpl.class);
                        
            // Récupération et affichage des données
            List<Plant> plants = daoPlant.getAllPlants();
            List<Map> maps = daoGameMap.getAllMaps();
            List<Zombie> zombies = daoZombie.getAllZombies();
            //List<Zombie> zombiesFromMap = daoZombie.getZombiesFromMap(maps.get(0));
            
            System.out.println("\033c"); // Clear console

            displayPlants(plants);
            displayZombies(zombies);
            //displayZombies(zombiesFromMap);
            displayMaps(maps);
        }
    }
}