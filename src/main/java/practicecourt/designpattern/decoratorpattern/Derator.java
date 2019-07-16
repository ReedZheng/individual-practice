package practicecourt.designpattern.decoratorpattern;

public abstract class Derator extends Component {

    public Component component;

    public Derator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
