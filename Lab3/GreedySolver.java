import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedySolver implements Algorithm {
    private double totalWeight;
    private List<Item> selectedItemList;
    private double usedCapacity;
    private double totalProfit;
    private double totalValue;

    public GreedySolver() {
        this.totalWeight = 0;
        selectedItemList = new ArrayList<Item>();
        this.usedCapacity = 0;
        this.totalProfit = 0;
        this.totalValue = 0;
    }

    public double getTotalWeight(List<Item> itemList) {
        for (Item index : itemList) {
            totalWeight = totalWeight + index.getWeight();
        }
        return totalWeight;
    }

    public List<Item> solve(Knapsack knapsack) {
        long greedyStartTime = System.nanoTime();

        double totalWeight = getTotalWeight(knapsack.getItemList());
        double currentCapacity = knapsack.getCapacity();
//        Aici tratez cazul in care toate obiectele incap
        if (totalWeight <= knapsack.getCapacity()) {
            for (Item index : knapsack.getItemList()) {
                selectedItemList.add(index);
            }
        } else {
            for (Item index : knapsack.getItemList()) {
                if (currentCapacity < 0) {
                    break;
                } else if (index.getWeight() <= currentCapacity) {
                    System.out.println("Adaug " + index.getName() + "...");
                    selectedItemList.add(index);
                    currentCapacity = currentCapacity - index.getWeight();
                }
            }

        }

        for (Item index : selectedItemList) {
            totalProfit = totalProfit + index.profitFactor();
            totalValue = totalValue + index.getValue();
        }

        this.usedCapacity = knapsack.getCapacity() - currentCapacity;
        long greedyEndTime = System.nanoTime();

        long greedyTotalTime = greedyEndTime - greedyStartTime;

        System.out.println("Running time = " + greedyTotalTime + " nanoseconds");

        return selectedItemList;
    }

    @Override
    public String toString() {
        return "GreedySolver{" +
                "selectedItemList=" + selectedItemList +
                ", usedCapacity=" + usedCapacity +
                ", totalProfit=" + totalProfit +
                ", totalValue=" + totalValue +
                '}';
    }
}
