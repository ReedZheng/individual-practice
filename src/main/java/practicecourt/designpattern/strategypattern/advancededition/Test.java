package practicecourt.designpattern.strategypattern.advancededition;

import java.util.Optional;

public class Test {

    public static void main(String[] args) throws Exception {
        BaseStrategy strategy = Context.selectStrategy("strategy2");
        Optional<BaseStrategy> optionalBaseStrategy = Optional.ofNullable(strategy);
        optionalBaseStrategy.ifPresent(BaseStrategy::introduce);
    }
}
