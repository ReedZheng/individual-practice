package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public class Submitted extends BaseState {

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
        System.out.print("当前状态 - " + toString());
        // xx判断
        Approved approved = new Approved();
        getVoucher().setState(approved);
        System.out.println(" approve后状态 - " + approved);
    }

    @Override
    public void subFor2ndApprove() {
        System.out.print("当前状态 - " + toString());
        // xx判断
        SubFor2ndApprove subFor2ndApprove = new SubFor2ndApprove();
        getVoucher().setState(subFor2ndApprove);
        System.out.println(" subFor2ndApprove后状态 - " + subFor2ndApprove);
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
        return "Submitted";
    }
}
