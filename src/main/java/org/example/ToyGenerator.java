package org.example;

import java.util.*;

public class ToyGenerator {
    private Map<Toy, Integer> toys;

    private int numberOfToysPlayed;

    /**
     * Данный генератор получает на вход количество разыгрываемых игрушек
     * и отдает готовый HashMap с количеством игрушек для розыгрыша, по каждой категории
     * @param numberOfToysPlayed
     */
    public ToyGenerator(int numberOfToysPlayed) {
        toys = new HashMap<>();

        this.numberOfToysPlayed = numberOfToysPlayed;
    }

    public void addToy(Toy toy) {
        toys.putIfAbsent(toy, 0);
    }

    private void fillToysMap() {

        int totalFrequency = 0;
        for (Map.Entry<Toy, Integer> toy : toys.entrySet()) {
            totalFrequency += toy.getKey().getFrequency();
        }

        if (totalFrequency == 100) {
            int count = 0;
            int sumToys = 0;
            for (Map.Entry<Toy, Integer> toy : toys.entrySet()) {
                int numberOfToy = 0;
                count++;
                if (count != toys.size()) {
                    numberOfToy = numberOfToysPlayed * toy.getKey().getFrequency() / totalFrequency;
                    sumToys += numberOfToy;
                } else {
                    numberOfToy = numberOfToysPlayed - sumToys;
                }
                toys.put(toy.getKey(), numberOfToy);
            }
        } else {
            throw new RuntimeException("ГДЕ-ТО ВЫ ОШИБЛИСЬ И ОБЩАЯ ЧАСТОТА НЕ РАВНА 100%");
        }

    }

    public Map<Toy,Integer> getToys(){
        fillToysMap();
        return toys;
    }

}