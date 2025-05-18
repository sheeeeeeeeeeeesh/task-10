package lab1002.Items;

public class Food extends BaseItem {
    public Food(int count, int value) {
        super(count, value);
    }

    public int eat() {
        return this.use();
    }
}
