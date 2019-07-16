package practicecourt.designpattern.decoratorpattern;

/**
 * @Description:
 * @Date: 2018/11/26
 */
public class ConcreteComponent extends Component {

    @Override
    public void operate() {
        System.out.println("未加工的奶茶");
    }
}
