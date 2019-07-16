package practicecourt.designpattern.statepattern.voucherstate;

import practicecourt.designpattern.statepattern.voucherstate.state.BaseState;

public class Voucher {

    private BaseState state;

    public Voucher(BaseState state) {
        setState(state);
    }

    public void submit() {
        System.out.println("submit voucher..");
        state.submit();
    }

    public void reject() {
        System.out.println("reject voucher..");
        state.reject();
    }

    public void approve() {
        System.out.println("approve voucher..");
        state.approve();
    }

    public void subFor2ndApprove() {
        System.out.println("subFor2ndApprove voucher..");
        state.subFor2ndApprove();
    }

    public void verify() {
        System.out.println("verify voucher..");
        state.verify();
    }

    public void reverse() {
        System.out.println("reverse voucher..");
        state.reverse();
    }

    public void delete() {
        System.out.println("delete voucher..");
        state.delete();
    }

    public void save() {
        System.out.println("save voucher..");
        state.save();
    }

    public void allowOperation() {

    }

    public void setState(BaseState state) {
        this.state = state;
        state.setVoucher(this);
    }
}
