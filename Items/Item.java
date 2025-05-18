package lab1002.Items;

public interface Item {
    int MIN_VALUE = 1;    // используется для качества и количества
    int MAX_VALUE = 10;

    int use();
    boolean isUsed();
}
