package practicecourt.java8.streamdemo;

/**
 * @Description:
 * @Date: 2018/12/6
 */
public class Traders {

    private String name;
    private String city;

    public Traders(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Traders{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }
}
