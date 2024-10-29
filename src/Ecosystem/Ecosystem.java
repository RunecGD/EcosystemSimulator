package Ecosystem;

import java.util.ArrayList;
import java.util.List;

public class Ecosystem {
    private List<Plant> plants;
    private List<Animal> animals;

    public Ecosystem() {
        this.plants = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    // Добавление растений
    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    // Чтение всех растений
    public List<Plant> getPlants() {
        return plants;
    }

    // Обновление растения
    public void updatePlant(int index, Plant plant) {
        if (index >= 0 && index < plants.size()) {
            plants.set(index, plant);
        }
    }

    // Удаление растения
    public void removePlant(int index) {
        if (index >= 0 && index < plants.size()) {
            plants.remove(index);
        }
    }

    // То же для животных
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
}
