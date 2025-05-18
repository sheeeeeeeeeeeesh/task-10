package lab1002.Armor;

public class Dress extends BaseArmor{
    final private int DRESS_POSITION = 2;

    public Dress (int durability) { super(durability); }

    @Override
    public int getPosition() { return DRESS_POSITION; }
}
