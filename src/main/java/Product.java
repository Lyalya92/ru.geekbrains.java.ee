public class Product {
    private static int counter = 0;
    private int id;
    private String title;
    private float cost;

    public Product(String title, float cost) {
        this.id = ++counter;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }
}
