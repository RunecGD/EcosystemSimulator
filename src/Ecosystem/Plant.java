package Ecosystem;

public class Plant {
    private String name;
    private int growthRate;

    public Plant(String name, int growthRate) {
        this.name = name;
        this.growthRate = growthRate;
    }

    public String getName() {
        return name;
    }

    public int getGrowthRate() {
        return growthRate;
    }

    @Override
    public String toString() {
        return "Plant{name='" + name + "', growthRate=" + growthRate + '}';
    }
}
