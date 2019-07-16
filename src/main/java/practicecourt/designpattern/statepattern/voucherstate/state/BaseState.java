package practicecourt.designpattern.statepattern.voucherstate.state;

import practicecourt.designpattern.statepattern.voucherstate.Voucher;

public abstract class BaseState {

    private Voucher voucher;

    /**
     * 操作：submit
     */
    public abstract void submit();

    public abstract void reject();

    public abstract void approve();

    public abstract void subFor2ndApprove();

    public abstract void verify();

    public abstract void reverse();

    public abstract void delete();

    public abstract void save();

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

}
