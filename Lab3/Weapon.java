/**
 * The type Weapon.
 */
public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;

    /**
     * Instantiates a new Weapon.
     */
    public Weapon() {
    }

    /**
     * Instantiates a new Weapon.
     *
     * @param type the type
     */
    public Weapon(WeaponType type) {
        this.type = type;
    }

    /**
     * Instantiates a new Weapon.
     *
     * @param type   the type
     * @param weight the weight
     */
    public Weapon(WeaponType type, double weight) {
        this.type = type;
        this.weight = weight;
    }

    /**
     * Instantiates a new Weapon.
     *
     * @param type   the type
     * @param weight the weight
     * @param value  the value
     */
    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public WeaponType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(WeaponType type) {
        this.type = type;
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
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return type.name();
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type=" + type +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
