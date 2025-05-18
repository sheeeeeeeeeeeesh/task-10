package lab1002.Gamer;

import lab1002.Armor.Armor;
import lab1002.Weapon.Weapon;

public interface Equipment  {
    int CLOTHES_COUNT = 3;

    boolean change(Weapon weapon);
    void dress (Armor armor);
}
