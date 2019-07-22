package practicecourt.designpattern.observepattern.javasupport;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 */
public class WeatherReport implements Observer {

    public WeatherReport(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Weather weather = (Weather)o;
        System.out.println("天气状况发生变化（当前：" + weather.getWeatherCondition() + "）");
    }
}
