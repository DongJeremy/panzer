package org.cloud.panzer.domain;

public class GoodsBean {

    // id
    private Long goods_id;
    // id
    private String goodsName;
    // 销量
    private int goodsSalenum;
    // id
    private String goodsImage;

    // id
    private String videoPath;

    private String goodsJingle;

    private


    // 产地
    private String addressId = "";
    // 产地
    private String cartId = "";
    // 产地
    private String fcode = "";
    // 产地
    private String ifCart = "";
    private String invoiceId = "0";
    private String isPoint = "0";
    private String offPayHash = "";
    private String offPayHashBatch = "";
    private String password = "";
    private String payMessage = "";
    private String payName = "";
    private String pdPay = "0";
    private String rcbPay = "0";
    private String rpt = "";
    private String vatHash = "";
    private String voucher = "";

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getIfCart() {
        return ifCart;
    }

    public void setIfCart(String ifCart) {
        this.ifCart = ifCart;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getIsPoint() {
        return isPoint;
    }

    public void setIsPoint(String isPoint) {
        this.isPoint = isPoint;
    }

    public String getOffPayHash() {
        return offPayHash;
    }

    public void setOffPayHash(String offPayHash) {
        this.offPayHash = offPayHash;
    }

    public String getOffPayHashBatch() {
        return offPayHashBatch;
    }

    public void setOffPayHashBatch(String offPayHashBatch) {
        this.offPayHashBatch = offPayHashBatch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayMessage() {
        return payMessage;
    }

    public void setPayMessage(String payMessage) {
        this.payMessage = payMessage;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPdPay() {
        return pdPay;
    }

    public void setPdPay(String pdPay) {
        this.pdPay = pdPay;
    }

    public String getRcbPay() {
        return rcbPay;
    }

    public void setRcbPay(String rcbPay) {
        this.rcbPay = rcbPay;
    }

    public String getRpt() {
        return rpt;
    }

    public void setRpt(String rpt) {
        this.rpt = rpt;
    }

    public String getVatHash() {
        return vatHash;
    }

    public void setVatHash(String vatHash) {
        this.vatHash = vatHash;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }
}
