package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public class Approved extends BaseState {

    @Override
    public void submit() {

    }

    @Override
    public void reject() {
        System.out.print("当前状态 - " + toString());
        // xx判断
        Rejected rejected = new Rejected();
        getVoucher().setState(rejected);
        System.out.println(" reject后状态 - " + rejected);
    }

    @Override
    public void approve() {

    }

    @Override
    public void subFor2ndApprove() {

    }

    @Override
    public void verify() {
        System.out.print("当前状态 - " + toString());
        // xx判断
        Verified verified = new Verified();
        getVoucher().setState(verified);
        System.out.println(" verify后状态 - " + verified);
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
        // xx判断
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
        return "Approved";
    }
}
