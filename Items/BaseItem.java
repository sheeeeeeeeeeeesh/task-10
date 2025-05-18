package lab1002.Items;

public abstract class BaseItem implements Item{
    protected int count;
    protected int value;

    public BaseItem(int count, int value) {
        this.count = Math.abs(count);
        this.value = Math.abs(value);
    }

    @Override
    public int use() {
        if (this.count == 0) return 0;

        this.count--;
        return this.value;
    }

    public int getCount() { return this.count; }

    @Override
    public boolean isUsed() { return count == 0; }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", count: " + Integer.toString(this.count) +
                ", isUsed: " + Boolean.toString(this.isUsed());
    }
}