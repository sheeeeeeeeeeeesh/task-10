package lab1002.Armor;

public abstract class BaseArmor implements Armor {
    protected int durability;

    public BaseArmor(int durability) { this.durability = Math.abs(durability); }

    @Override
    public Boolean isBroken() {
        return this.durability == 0;
    };

    // Поглощение урона, нанесенного герою
    // Значение поглощённого урона не может превышать значение прочности элемента брони
    // Функция возвращает урон, который элемент брони не смог поглотить
    @Override
    public int destroyBy(int damage) {
        int temp = this.durability - damage;
        if (temp <= 0) {
            this.durability = 0;
            return -temp;
        } else {
            this.durability = temp;
            return 0;
        }
    }

    @Override
    public abstract int getPosition();

    @Override
    public String toString() {
        return Integer.toString(getPosition()) + this.getClass().getSimpleName() +
                ", durability: " + Integer.toString(this.durability) +
                ", isBroken: " + Boolean.toString(this.isBroken());
    }
}
