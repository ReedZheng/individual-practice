package practicecourt.designpattern.statepattern.voucherstate;

import practicecourt.designpattern.statepattern.voucherstate.state.Draft;

public class Test {

    public static void main(String[] args) {
        Voucher voucher = new Voucher(new Draft());
        voucher.submit();
        voucher.approve();
        voucher.reject();
        voucher.submit();
        voucher.approve();
        voucher.verify();
        voucher.subFor2ndApprove();
    }
}
