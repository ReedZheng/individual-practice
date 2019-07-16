package practicecourt.designpattern.statepattern.voucherstate.state;

public class Draft extends BaseState {

    @Override
    public void approve() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void subFor2ndApprove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void verify() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void reverse() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete() {
        System.out.print("当前状态 - " + toString());
        // xx判断
        Deleted deleted = new Deleted();
        getVoucher().setState(deleted);
        System.out.println(" delete后状态 - " + deleted);
    }

    @Override
    public void save() {
        System.out.print("当前状态 - " + toString());
        System.out.println(" save后状态 - " + toString());
    }

    @Override
    public void submit() {
        System.out.print("当前状态 - " + toString());
        // xx判断
        Submitted submitted = new Submitted();
        getVoucher().setState(submitted);
        System.out.println(" submit后状态 - " + submitted);
    }

    @Override
    public void reject() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Draft";
    }
}
