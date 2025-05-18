package lab1002.Gamer;


public interface Healthy {
    int MAX_HEALTH = 100;

    boolean isDied();
    void recoverHealth(int potions);
}
