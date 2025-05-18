package lab1002.Weapon;

public class Sword extends BaseWeapon {
    int SWORD_DISTANCE = 2;

    public Sword(int power) { super(power); }

    @Override
    public int getDistance() { return SWORD_DISTANCE; }
}
