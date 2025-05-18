package lab1002.Gamer;

import lab1002.Armor.Armor;
import lab1002.Items.BaseItem;
import lab1002.Weapon.Weapon;
/////////////////////////////////////////////
import java.util.Scanner;
import lab1002.Items.HealthPotion;

public abstract class Hero implements Player, Healthy, Equipment, Inventory {
    protected String username;
    protected int health;
    protected Weapon weapon = null;
    protected Armor[] armor;
    protected BaseItem[] items = {null, null, null, null, null};

    public Hero (String username, int initialHealth){
        setUsername(username);
        this.health = Math.abs(initialHealth);
    }

    private void loseHealth (int amount) {
        this.health -= damage(amount);
    }

    @Override
    public String getUsername (){
        return this.username;
    }


    // Возвращает остаток, на который не хватило брони или 0
    // Функция наносит урон по броне
    // Функция возвращает 1, если урон поглощёг
    // Функция возвращает 0, если урпон не поглощён
    @Override
    public int damage(int amount) {
        for (Armor element : this.armor) {
            amount = element.destroyBy(amount);
            if (amount == 0) return 1;
        }
        this.loseHealth(amount);
        return 0;
    }

    // Функция проверяет жив ли враг
    // Если враг мертв, то возвращает true, иначе false
    @Override
    public boolean isDied(){
        return this.health <= 0;
    }


    // функция восстанавливает здоровье героя
    @Override
    public void recoverHealth(int position){
        if (this.health == MAX_HEALTH ||
                Math.abs(position) > ITEMS_COUNT ||
                !(this.items[position- 1] instanceof HealthPotion)) throw new RuntimeException("Cannot recover health");

        this.health += this.items[position - 1].use();
        this.health = Math.min(MAX_HEALTH, this.health);
    }


    //функция надевает на героя предмет одеджы на определенную позицию
    @Override
    public void dress(Armor armor) {
        int index = armor.getPosition() - 1;
        this.armor[index] = armor;
    }

    // функция добавляет предмет добавляет один предмет в позицию position
    // если предмет был помещен в позицию, возвращает true
    // если предмет не был помещён в позицию, возвращает false
    @Override
    public boolean putInto(BaseItem item, int position) {
        Scanner scanner = new Scanner(System.in);

        if (Math.abs(position) > ITEMS_COUNT) return false;

        if (this.items[Math.abs(position) - 1] != null && this.items[Math.abs(position) - 1].getCount() != 0) {
            System.out.println("Позиция уже заняте. Хотите зменить предмет в инвентаре? (Д/Н)");
            String answer = scanner.nextLine();
            char Char = answer.charAt(0);
            if (Char == 'Д') {
                this.items[Math.abs(position) - 1] = item;
            } else return false;
        }
        return true;
    }

    @Override
    public abstract boolean action(Player player, int distance);
    @Override
    public abstract boolean change(Weapon weapon);
    @Override
    public abstract boolean useItem(int amount);


    // функции не было в задании
    private void setUsername(String username) {
        if (username == null) throw new RuntimeException("Username cannot be null");
        this.username = username;
    }

    private String showWeapon() {
        if (this.weapon == null) return "no";
        else return weapon.toString();
    }

    private String showInventory() {
        StringBuilder sb = new StringBuilder();
        for (BaseItem item : this.items) {
            if (item == null) {
                sb.append("no ");
                continue;
            }
            sb = sb.append(item.toString()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getUsername() +
                ", health: " + Integer.toString(this.health) +
                ", weapon: " + this.showWeapon() +
                ", inventory: " + this.showInventory();

    }
}
