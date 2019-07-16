package practicecourt.designpattern.observepattern.javasupport;

import java.util.Observable;

/**
 * 被观察者
 */
public class Weather extends Observable {

    private String weatherCondition = "";

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        if (!this.weatherCondition.equals(weatherCondition)) {
            this.weatherCondition = weatherCondition;
            setChanged();
            notifyObservers("kkk");
        }
    }
}
