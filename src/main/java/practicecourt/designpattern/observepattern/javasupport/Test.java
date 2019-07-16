package practicecourt.designpattern.observepattern.javasupport;

/**
 * https://blog.csdn.net/itachi85/article/details/50773358 https://blog.csdn.net/yanbober/article/details/45484749
 */
public class Test {

    public static void main(String[] args) {
        Weather weather = new Weather();
        WeatherReport wp = new WeatherReport(weather);

        weather.setWeatherCondition("晴");
        weather.setWeatherCondition("多云");
        weather.setWeatherCondition("晴");
        weather.setWeatherCondition("晴");
        weather.setWeatherCondition("雨");
    }
}
