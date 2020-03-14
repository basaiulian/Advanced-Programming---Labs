import java.util.ArrayList;
import java.util.List;

/**
 * The interface Item.
 */
public interface Item {
    /**
     * The constant name.
     */
    static final String name = null;
    /**
     * The constant weight.
     */
    static final double weight = 0;
    /**
     * The constant value.
     */
    static final double value = 0;

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets value.
     *
     * @return the value
     */
    double getValue();

    /**
     * Gets weight.
     *
     * @return the weight
     */
    double getWeight();

    /**
     * Profit factor double.
     *
     * @return the double
     */
    default double profitFactor() {
        return getValue() / getWeight();
    }


}
