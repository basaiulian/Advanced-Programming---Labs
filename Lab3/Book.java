/**
 * The type Book.
 */
public class Book implements Item {
    private String name;
    private int pageNumber;
    private double value;

    /**
     * Instantiates a new Book.
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param name the name
     */
    public Book(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Book.
     *
     * @param name       the name
     * @param pageNumber the page number
     */
    public Book(String name, int pageNumber) {
        this.pageNumber = pageNumber;
        this.name = name;
    }

    /**
     * Instantiates a new Book.
     *
     * @param name       the name
     * @param pageNumber the page number
     * @param value      the value
     */
    public Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    /**
     * Gets page number.
     *
     * @return the page number
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets page number.
     *
     * @param pageNumber the page number
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
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

    @Override
    public double getWeight() {
        return pageNumber / 100;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pageNumber=" + pageNumber + "(" + this.getWeight() + ")" +
                ", value=" + value +
                "}";
    }

}
