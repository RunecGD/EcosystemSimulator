package Ecosystem;

public class Animal {
    private String name;
    private String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
    public boolean canEat(Plant plant) {
        // Пример: все животные могут есть растения с определенной скоростью роста
        return plant.getGrowthRate() < 10; // Условие для примера
    }

    @Override
    public String toString() {
        return "Animal{name='" + name + "', species='" + species + "'}";
    }
}
