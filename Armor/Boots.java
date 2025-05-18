package lab1002.Armor;

public class Boots extends BaseArmor{
    final int BOOTS_POSITION = 1;

    public Boots(int durability) { super(durability); }

    @Override
    public int getPosition() { return this.BOOTS_POSITION; }
}
