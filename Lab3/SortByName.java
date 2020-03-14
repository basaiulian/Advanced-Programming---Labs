import java.util.Comparator;

/**
 * The type Sort by name.
 */
public class SortByName implements Comparator<Item> {
    public int compare(Item item1, Item item2) {
        return item1.getName().compareTo(item2.getName());
    }
}

