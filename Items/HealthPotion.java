package lab1002.Items;

public class HealthPotion extends Potions{
    public HealthPotion(int count, int value) {
        super(count, value);
    }

    @Override
    public int use() {
        if (this.count == 0) return 0;

        this.count--;
        return this.value;
    }

    @Override
    public boolean isUsed() { return count == 0; }
}
