package lab1002.Weapon;

public abstract class BaseWeapon implements Weapon{
    protected double power;

    public BaseWeapon (double power) { this.power = Math.abs(power); }
    @Override
    public double getPower() { return this.power; }

    @Override
    abstract public int getDistance();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ", power: " + Double.toString(this.power) +
                ", distance: " + Integer.toString(this.getDistance());
    }
}
