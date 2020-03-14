/**
 * The type Food.
 */
public class Food implements Item {
    private String name;
    private double weight;

    /**
     * Instantiates a new Food.
     */
    public Food() {
    }

    /**
     * Instantiates a new Food.
     *
     * @param name the name
     */
    public Food(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Food.
     *
     * @param name   the name
     * @param weight the weight
     */
    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Instantiates a new Food.
     *
     * @param name   the name
     * @param weight the weight
     * @param value  the value
     */
    public Food(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return weight * 2;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
