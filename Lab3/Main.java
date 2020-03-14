import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Item book1 = new Book("Dragon Rising", 324, 5);
        Item book2 = new Book("A Blade in the Dark", 394, 5);
        Item food1 = new Food("Cabbage", 2, 4);
        Item food2 = new Food("Rabbit", 2, 4);

        Item weapon1 = new Weapon(WeaponType.SWORD, 5, 10);

        System.out.println("Book name: " + book1.getName() + " ; Weight: " + book1.getWeight() + "(" + ((Book) book1).getPageNumber() + " pages)" + " ; Profit factor: " + book1.profitFactor());
        System.out.println("Book name: " + book2.getName() + " ; Weight: " + book2.getWeight() + "(" + ((Book) book2).getPageNumber() + " pages)" + " ; Profit factor: " + book2.profitFactor());
        System.out.println("Food name: " + food1.getName() + " ; Weight: " + food1.getWeight() + " ; Value: " + food1.getValue() + " ; Profit factor: " + food1.profitFactor());
        System.out.println("Food name: " + food2.getName() + " ; Weight: " + food2.getWeight() + " ; Value: " + food2.getValue() + " ; Profit factor: " + food2.profitFactor());
        System.out.println("Weapon type: " + weapon1.getName() + " ; Weight: " + weapon1.getWeight() + " ; Value: " + weapon1.getValue() + " ; Profit factor: " + weapon1.profitFactor());

        Knapsack knapsack1 = new Knapsack(10);
        knapsack1.addItem(book1);
        knapsack1.addItem(book2);
        knapsack1.addItem(weapon1);
        knapsack1.addItem(food1);
        knapsack1.addItem(food2);

        System.out.println(knapsack1);

        SortByName sortName = new SortByName();

        Collections.sort(knapsack1.getItemList(), sortName);

        System.out.println("Sorted by name: " + knapsack1);

        System.out.println("\n[Optional] Greedy solver\n");

        System.out.println("Greedy criteria: value");

        Collections.sort(knapsack1.getItemList(), Comparator.comparingDouble(Item::getValue));

        System.out.println("Sorted by value(ascending order): " + knapsack1);

        Collections.reverse(knapsack1.getItemList());

        System.out.println("Sorted by value(descending order): " + knapsack1.getItemList());

        Algorithm greedy1 = new GreedySolver();

        //System.out.println(((GreedySolver) greedy).getTotalWeight(knapsack1.getItemList())); GREUTATE TOTALA

        greedy1.solve(knapsack1);

        System.out.println(greedy1);

        System.out.println("Greedy criteria: profit");

        Algorithm greedy2 = new GreedySolver();

        Collections.sort(knapsack1.getItemList(), Comparator.comparingDouble(Item::profitFactor));

        System.out.println("Sorted by profit(ascending order): " + knapsack1);

        Collections.reverse(knapsack1.getItemList());

        System.out.println("Sorted by profit(descending order): " + knapsack1.getItemList());


        greedy2.solve(knapsack1);


        System.out.println(greedy2);

        System.out.println("\n[Optional] Dynamic programming solver\n");

        Collections.sort(knapsack1.getItemList(), Comparator.comparingDouble(Item::profitFactor));
        Collections.reverse(knapsack1.getItemList());

        System.out.println("Sorted by profitFactor(ascending order): " + knapsack1.getItemList());

        Algorithm dynamicPrograming = new DynamicProgrammingSolver(knapsack1);

        dynamicPrograming.solve(knapsack1);


    }
}
