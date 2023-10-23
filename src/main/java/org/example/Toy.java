package org.example;

public class Toy implements Comparable<Toy> {
    protected int id;
    protected String nameOfToy;
    protected int frequency;

    public Toy(int id, String nameOfToy, int frequency) {
        this.id = id;
        this.nameOfToy = nameOfToy;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getNameOfToy() {
        return nameOfToy;
    }

    public void setNameOfToy(String nameOfToy) {
        this.nameOfToy = nameOfToy;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Выпала игрушка " + nameOfToy;
    }

    @Override
    public int compareTo(Toy toy) {
        if (toy.getId() == this.id)
            return 0;
        return -1;
    }
}
