package lab1002.Gamer;

import lab1002.Items.BaseItem;

public interface Inventory {
    int ITEMS_COUNT = 5;

    boolean putInto (BaseItem item, int integer);
    boolean useItem (int integer);
}
