package be.intecbrussel;

import java.io.Serializable;

public class FavoriteAnimal implements Serializable {
    public String name;
    public boolean edible;

    public FavoriteAnimal(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "FavoriteAnimal{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
