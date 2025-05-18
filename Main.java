package lab1002;

import lab1002.Gamer.Paladin;
import lab1002.Items.Food;
import lab1002.Items.HealthPotion;

public class Main {
    public static void main(String[] args) {
        Paladin paladin = new Paladin("paladin", 90);

        Paladin evilPaladin = new Paladin("evil_paladin", 100);

        if (paladin.action(evilPaladin, 3)) {
            System.out.println("Паладин ударил злого паладина!");
        } else System.out.println("Паладин НЕ ударирл злого паладина!");

        if (evilPaladin.action(paladin, 2)) {
            System.out.println("Злой паладин ударил паладина!");
        } else System.out.println("Злой паладин НЕ ударирл паладина!");

        HealthPotion healthPotion1 = new HealthPotion(1, 4);
        Food apple = new Food(1, 5);


    }
}
