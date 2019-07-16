package practicecourt.designpattern.strategypattern.advancededition;

/**
 * @Description:
 * @Date: 2018/11/25
 */
@StratefyFlag(name = "strategy3")
public class Strategy3 implements BaseStrategy {

    @Override
    public void introduce() {
        System.out.println("这是策略3");
    }
}
