package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public class Deleted extends BaseState {

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
        return "Deleted";
    }
}
