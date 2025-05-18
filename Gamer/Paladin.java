package lab1002.Gamer;

import lab1002.Items.Food;
import lab1002.Items.HealthPotion;
import lab1002.Weapon.Weapon;

public class Paladin extends Hero {
    private int forcePower = 1;
    public Paladin(String username, int initialHealth) {
        super(username, initialHealth);
    }

    // Возвращает false если герой не попал по рпотивнику
    // Возвращает true, если герой попадет по противнку
    @Override
    public boolean action(Player enemy, int distanceBetweenEnemies) {
        int force = this.forcePower;
        int availableDistance = 1;
        if (this.weapon != null) {
            availableDistance = this.weapon.getDistance();
            force = (int) this.weapon.getPower() * this.forcePower;
        }

        if (availableDistance >= distanceBetweenEnemies) {
            enemy.damage(force);
            return true;
        }
        return false;
    }


    // Возвращает true, если удалось сменить оружие
    // Возвразает false если не удалось сментть оружие
    @Override
    public boolean change(Weapon weapon) {
        if (weapon.getDistance() != 2) return false;
        this.weapon = weapon;
        return true;
    }

    @Override
    public boolean useItem(int position) {
        if (this.items[Math.abs(position) - 1] instanceof HealthPotion) {
            this.recoverHealth(position);
            return true;
        }
        else if (this.items[Math.abs(position) - 1] instanceof Food) {
            int energy = this.items[Math.abs(position)].use();
            System.out.println("Paladin is happily eating food");
            return true;
        }
        return false;
    }
}
