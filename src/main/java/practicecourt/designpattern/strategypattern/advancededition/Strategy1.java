package practicecourt.designpattern.strategypattern.advancededition;

/**
 * @Description:
 * @Date: 2018/11/25
 */
@StratefyFlag(name = "strategy1")
public class Strategy1 implements BaseStrategy {

    @Override
    public void introduce() {
        System.out.println("这是策略1");
    }
}
