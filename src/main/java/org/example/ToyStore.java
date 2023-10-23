package org.example;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {

    private int numberOfToysPlayed = 20;
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;
    private Toy toy4;
    private Toy toy5;
    private ToyGenerator toyGenerator;
    private  PriorityQueue<Toy> queue = new PriorityQueue<>();
    private Random random;

    public ToyStore() {

        /**
         * В данном магазине для розыгрыша предоставлены пять видов игрушек
         * Самые часто выпадающие это мячи - 50% выпадения от начального количества игрушек
         * Затем идут куклы - 20%
         * Настольные игры - 15%
         * Плюшевые медведи - 10%
         * И самый редкий приз - это самокаты, всего 5%
         */
        random = new Random();

        toy1 = new Toy(1, "Teddy bear", 10);
        toy2 = new Toy(2, "Doll", 20);
        toy3 = new Toy(3, "Ball", 50);
        toy4 = new Toy(4, "Board game", 15);
        toy5 = new Toy(5, "Scooter", 5);

        toyGenerator = new ToyGenerator(numberOfToysPlayed);
        toyGenerator.addToy(toy1);
        toyGenerator.addToy(toy2);
        toyGenerator.addToy(toy3);
        toyGenerator.addToy(toy4);
        toyGenerator.addToy(toy5);
        Map<Toy, Integer> toys = toyGenerator.getToys();


        /**
         * создаем очередь в рандомном порядке, для розыгрыша
         */
        int k = 0;
        while (k < numberOfToysPlayed) {
            int randomNumber = random.nextInt(toys.size())+1;
            for (Map.Entry<Toy, Integer> toy : toys.entrySet()) {
                if (toy.getKey().getId() == randomNumber && toy.getValue() != 0) {
                    toys.put(toy.getKey(), toy.getValue() - 1);
                    queue.add(toy.getKey());
                    k++;
                }
            }
        }
    }



    public Toy getLottery() {
        return queue.remove();
    }

    public void printInfo(){
        System.out.println();
        System.out.println("В розыгрыше принимают участие: " );
        for (Map.Entry<Toy, Integer> toy : toyGenerator.getToys().entrySet()){
            System.out.printf("%s - %d шт \n", toy.getKey().getNameOfToy(), toy.getValue());
        }
        System.out.println("_________________________________________");
    }
}
