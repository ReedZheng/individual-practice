package practicecourt.designpattern.strategypattern.advancededition;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;

/**
 *
 */
public class Context {

    private static Map<String, Class> strategies = new HashMap<>();

    static {
        // 参数表示在该包下进行扫描
        Reflections reflections = new Reflections(
            "practicecourt.designpattern.strategypattern.advancededition");
        // 获取该包下annotation为参数类型的类并放入set集合中
        Set<Class<?>> typesAnnotatedWith = reflections
            .getTypesAnnotatedWith(
                practicecourt.designpattern.strategypattern.advancededition.StratefyFlag.class);
        typesAnnotatedWith.forEach(item -> {
            strategies.put(item.getAnnotation(StratefyFlag.class).name(), item);
        });
    }

    public static BaseStrategy selectStrategy(String strategyName) throws Exception {
        BaseStrategy strategy = null;
        if (strategies.containsKey(strategyName)) {
            strategy = (BaseStrategy) strategies.get(strategyName).newInstance();
        }
        return strategy;
    }

    public static void main(String[] args) {
        new Context();
    }
}
