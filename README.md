# Plants vs Zombies - Projet Java

## Description du projet

Ce projet est une implémentation simplifiée du jeu "Plants vs Zombies" en Java. Le jeu consiste en une grille où les joueurs doivent défendre leur jardin contre des vagues de zombies en plaçant stratégiquement différentes plantes.

## Fonctionnalités principales

- Système de grille représentant la map de jeu
- Différents types de plantes avec certaines capacités
- Différents types de zombies
- Système de pièces basé sur les soleils
- Système de vagues de zombies
- Interface graphique intuitive

## Structure du projet

```
src/
├── main/
│   ├── java/
│   │   ├── Game/
│   │   │   ├── Character/
│   │   │   │   ├── Personnage.java
│   │   │   │   ├── Plants/
│   │   │   │   │   ├── Plant.java
│   │   │   │   │   ├── Tournesol.java
│   │   │   │   │   ├── TirePois.java
│   │   │   │   │   └── Noix.java
│   │   │   │   └── Zombies/
│   │   │   │       ├── Zombie.java
│   │   │   │       └── BasicZombie.java
│   │   │   ├── Cases/
│   │   │   │   └── Case.java
│   │   │   └── Sun/
│   │   │       └── Sun.java
│   │   ├── Controller/
│   │   │   └── GameController.java
│   │   └── View/
│   │       └── GameView.java
│   └── resources/
│       ├── images/
│       └── sounds/
└── test/
    └── java/
```

## Comment jouer

1. Collectez des soleils pour obtenir des ressources
2. Placez stratégiquement vos plantes sur la grille
3. Défendez votre jardin contre les vagues de zombies
4. Survivez le plus longtemps possible !

## Installation et lancement détaillé

### Prérequis

- Java 17 ou supérieur
- Maven 3.6 ou supérieur
- MySQL 8.0 ou supérieur

### Configuration de l'environnement

1. Cloner le dépôt
2. Configurer la base de données dans `DataBaseConfiguration.java`
3. Exécuter la commande : `mvn clean package`
4. Déployer le fichier WAR sur un serveur Tomcat
