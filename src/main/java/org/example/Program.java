package org.example;

public class Program {
    public static void main(String[] args) {

        ToyStore toyStore = new ToyStore();

        /**
         *   В магазине игрушек разыгрывается 20 различных игрушек
         *   (Если хотите увеличить количество разыгрываемых игрушек зайдите в магазин ToyStore
         *   и увеличьте значение numberOfToysPlayed)
         *   На данном этапе происходит розыгрыш 10 штук
         */

        toyStore.printInfo();
        lotteryTenGame(toyStore);

        /**
         *   На данном этапе происходит розыгрыш вторых 10 штук
         */
        lotteryTenGame(toyStore);

    }

    public static void lotteryTenGame(ToyStore toyStore) {
        System.out.println();

        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
        System.out.println(toyStore.getLottery());
    }
}