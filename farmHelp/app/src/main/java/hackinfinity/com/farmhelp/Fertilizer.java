package hackinfinity.com.farmhelp;

/**
 * Created by mohit on 11/11/17.
 */

public class Fertilizer {
    private int id;
    private int serviceProviderId;
    private String name;
    private String composition;
    private double price;

    public Fertilizer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(int serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fertilizer{" +
                "id=" + id +
                ", serviceProviderId=" + serviceProviderId +
                ", name='" + name + '\'' +
                ", composition='" + composition + '\'' +
                ", price=" + price +
                '}';
    }
}
