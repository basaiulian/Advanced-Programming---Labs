import java.util.ArrayList;
import java.util.List;

/**
 * The type Knapsack.
 */
public class Knapsack {
    private double capacity;
    private List<Item> items;

    /**
     * Instantiates a new Knapsack.
     */
    public Knapsack() {
        items = new ArrayList<>();
    }

    /**
     * Instantiates a new Knapsack.
     *
     * @param capacity the capacity
     */
    public Knapsack(double capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    /**
     * Instantiates a new Knapsack.
     *
     * @param capacity the capacity
     * @param items    the items
     */
    public Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    /**
     * Get item list list.
     *
     * @return the list
     */
    public List<Item> getItemList() {
        return items;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Add item.
     *
     * @param item the item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    public int countItems() {
        int counter = 0;
        for (Item item : items) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "capacity=" + capacity +
                ", items=" + items +
                '}';
    }

}
