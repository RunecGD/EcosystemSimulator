package Ecosystem;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private List<Plant> plants;
    private List<Animal> animals;

    public Ecosystem() {
        this.plants = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void updatePlant(int index, Plant plant) {
        if (index >= 0 && index < plants.size()) {
            plants.set(index, plant);
        }
    }

    public void removePlant(int index) {
        if (index >= 0 && index < plants.size()) {
            plants.remove(index);
        }
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void updateAnimal(int index, Animal animal) {
        if (index >= 0 && index < animals.size()) {
            animals.set(index, animal);
        }
    }

    public void removeAnimal(int index) {
        if (index >= 0 && index < animals.size()) {
            animals.remove(index);
        }
    }

    // Сохранение в файл
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Сохранение растений
            writer.write("Plants:\n");
            for (Plant plant : plants) {
                writer.write(plant.getName() + "," + plant.getGrowthRate() + "\n");
            }
            // Сохранение животных
            writer.write("Animals:\n");
            for (Animal animal : animals) {
                writer.write(animal.getName() + "," + animal.getSpecies() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Загрузка из файла
    public static Ecosystem loadFromFile(String filename) {
        Ecosystem ecosystem = new Ecosystem();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // Чтение растений
            if ((line = reader.readLine()) != null && line.equals("Plants:")) {
                while ((line = reader.readLine()) != null && !line.equals("Animals:")) {
                    String[] parts = line.split(",");
                    ecosystem.addPlant(new Plant(parts[0], Integer.parseInt(parts[1])));
                }
            }
            // Чтение животных
            if (line.equals("Animals:")) {
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    ecosystem.addAnimal(new Animal(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ecosystem;
    }
}