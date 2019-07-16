package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public class Verified extends BaseState {

    @Override
    public void submit() {

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
        System.out.print("当前状态 - " + toString());
        // xx判断
        Reversed reversed = new Reversed();
        getVoucher().setState(reversed);
        System.out.println(" reverse后状态 - " + reversed);
    }

    @Override
    public void delete() {

    }

    @Override
    public void save() {

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
        return "Verified";
    }
}
