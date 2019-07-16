package practicecourt.designpattern.decoratorpattern;

/**
 * @Description:
 * @Date: 2018/11/26
 */
public abstract class Decorator extends Component {

    public Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operate() {
        component.operate();
    }
}
