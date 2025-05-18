package lab1002.Armor;

public interface Armor {
    int MIN_VALUE = 5;
    int MAX_VALUE = 50;

    Boolean isBroken();
    int destroyBy(int damage);
    int getPosition();
}