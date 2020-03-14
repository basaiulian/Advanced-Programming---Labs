import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgrammingSolver implements Algorithm {
    private double usedCapacity;
    private List<Item> selectedItemList;
    private double totalProfit;
    private double totalValue;
    private double maxValue[][];

    public DynamicProgrammingSolver(Knapsack knapsack) {
        this.usedCapacity = 0;
        selectedItemList = new ArrayList<Item>();
        this.totalProfit = 0;
        this.totalValue = 0;

        int itemNumber = knapsack.countItems();
        double knapsackCapacity = knapsack.getCapacity();

        maxValue = new double[itemNumber + 1][(int) knapsackCapacity + 2];
        for (int i = 0; i <= itemNumber; i++) {
            maxValue[i][0] = 0;//row 0 = no item included
        }
        for (int j = 0; j <= knapsackCapacity; j++) {
            maxValue[0][j] = 0;//column 0 = used capacity is 0
        }

    }

    public List<Item> solve(Knapsack knapsack) {
        long dynamicProgrammingStartTime = System.nanoTime();

        int itemNumber = knapsack.countItems();
        double knapsackCapacity = knapsack.getCapacity();
        double currentItemWeight = 0;
        for (int i = 1; i <= itemNumber; i++) {
            for (int j = 1; j <= knapsackCapacity; j++) {

                currentItemWeight = knapsack.getItemList().get(i - 1).getWeight();
                if (j >= currentItemWeight) {
                    maxValue[i][j] = Math.max(knapsack.getItemList().get(i - 1).getValue() + (int) maxValue[i - 1][(int) (j - knapsack.getItemList().get(i - 1).getWeight())], maxValue[i - 1][j]);
                    maxValue[i][(int) knapsackCapacity + 1] = 1;
                    usedCapacity = usedCapacity + knapsack.getItemList().get(i - 1).getWeight();
                } else {
                    maxValue[i][j] = maxValue[i - 1][j];
                    maxValue[i][(int) knapsackCapacity + 1] = 0;
                }

            }

        }
        System.out.println("Value obtained: " + maxValue[itemNumber][(int) knapsackCapacity]);

        long dynamicProgrammingEndTime = System.nanoTime();
        long dynamicProgrammingTotalTime = dynamicProgrammingEndTime - dynamicProgrammingStartTime;

        System.out.println("Running time = " + dynamicProgrammingTotalTime + " nanoseconds");
        return knapsack.getItemList();
    }

}
