import java.util.List;

public interface Algorithm {
    public default List<Item> solve(Knapsack knapsack) {
        return null;
    }
}
