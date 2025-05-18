package lab1002.Armor;

import lab1001.BaseShape;

public class Helmet extends BaseArmor {
    final private int HELMET_POSITION = 3;

    public Helmet(int durability) { super(durability); }

    @Override
    public int getPosition() { return HELMET_POSITION; }
}