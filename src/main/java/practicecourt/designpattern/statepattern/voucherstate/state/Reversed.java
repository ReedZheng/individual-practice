package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public class Reversed extends BaseState {

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

    }

    @Override
    public void approve() {

    }

    @Override
    public void subFor2ndApprove() {

    }

    @Override
    public void verify() {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void save() {
        System.out.print("当前状态 - " + toString());
        System.out.println(" save后状态 - " + toString());
    }

    @Override
    public Voucher getVoucher() {
        return super.getVoucher();
    }

    @Override
    public void setVoucher(Voucher voucher) {
        super.setVoucher(voucher);
    }

    @Override
    public String toString() {
        return "Reversed";
    }
}
