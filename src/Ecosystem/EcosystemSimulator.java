package Ecosystem;

import java.util.List;
import java.util.Scanner;

public class EcosystemSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ecosystem ecosystem = new Ecosystem();
        int choice;

        do {
            System.out.println("1. Add Plant");
            System.out.println("2. View Plants");
            System.out.println("3. Update Plant");
            System.out.println("4. Remove Plant");
            System.out.println("5. Add Animal");
            System.out.println("6. View Animals");
            System.out.println("7. Update Animal");
            System.out.println("8. Remove Animal");
            System.out.println("9. Save Ecosystem");
            System.out.println("10. Load Ecosystem");
            System.out.println("11. Check if animal can eat plant");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Plant
                    System.out.print("Enter plant name: ");
                    String plantName = scanner.nextLine();
                    System.out.print("Enter growth rate: ");
                    int growthRate = scanner.nextInt();
                    ecosystem.addPlant(new Plant(plantName, growthRate));
                    break;

                case 2: // View Plants
                    List<Plant> plants = ecosystem.getPlants();
                    System.out.println("Plants:");
                    for (int i = 0; i < plants.size(); i++) {
                        System.out.println(i + ": " + plants.get(i));
                    }
                    break;

                case 3: // Update Plant
                    System.out.print("Enter plant index to update: ");
                    int plantIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new plant name: ");
                    String newPlantName = scanner.nextLine();
                    System.out.print("Enter new growth rate: ");
                    int newGrowthRate = scanner.nextInt();
                    ecosystem.updatePlant(plantIndex, new Plant(newPlantName, newGrowthRate));
                    break;

                case 4: // Remove Plant
                    System.out.print("Enter plant index to remove: ");
                    int removePlantIndex = scanner.nextInt();
                    ecosystem.removePlant(removePlantIndex);
                    break;

                case 5: // Add Animal
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.nextLine();
                    System.out.print("Enter species: ");
                    String species = scanner.nextLine();
                    ecosystem.addAnimal(new Animal(animalName, species));
                    break;

                case 6: // View Animals
                    List<Animal> animals = ecosystem.getAnimals();
                    System.out.println("Animals:");
                    for (int i = 0; i < animals.size(); i++) {
                        System.out.println(i + ": " + animals.get(i));
                    }
                    break;

                case 7: // Update Animal
                    System.out.print("Enter animal index to update: ");
                    int animalIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new animal name: ");
                    String newAnimalName = scanner.nextLine();
                    System.out.print("Enter new species: ");
                    String newSpecies = scanner.nextLine();
                    ecosystem.updateAnimal(animalIndex, new Animal(newAnimalName, newSpecies));
                    break;

                case 8: // Remove Animal
                    System.out.print("Enter animal index to remove: ");
                    int removeAnimalIndex = scanner.nextInt();
                    ecosystem.removeAnimal(removeAnimalIndex);
                    break;

                case 9: // Save Ecosystem
                    System.out.print("Enter filename to save: ");
                    String saveFilename = scanner.nextLine();
                    ecosystem.saveToFile(saveFilename);
                    System.out.println("Ecosystem saved to " + saveFilename);
                    break;

                case 10: // Load Ecosystem
                    System.out.print("Enter filename to load: ");
                    String loadFilename = scanner.nextLine();
                    ecosystem = Ecosystem.loadFromFile(loadFilename);
                    System.out.println("Ecosystem loaded from " + loadFilename);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;
                case 11: // Check if animal can eat plant
                    System.out.print("Enter animal index: ");
                    int animalIdx = scanner.nextInt();
                    System.out.print("Enter plant index: ");
                    int plantIdx = scanner.nextInt();

                    Animal animalToCheck = ecosystem.getAnimals().get(animalIdx);
                    Plant plantToCheck = ecosystem.getPlants().get(plantIdx);

                    if (animalToCheck.canEat(plantToCheck)) {
                        System.out.println(animalToCheck.getName() + " can eat " + plantToCheck.getName());
                    } else {
                        System.out.println(animalToCheck.getName() + " cannot eat " + plantToCheck.getName());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}