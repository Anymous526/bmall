package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderFormWithBLOBs extends OrderForm {

	private static final long serialVersionUID = 1L;

	private String msg;		//买家留言

    private String payMsg;

    private String orderSellerIntro;  //虚拟商品信息

    private String returnContent;   //申请说明,退货申请说明
    
    private RefundGoods refundGoods;  // 退货对象
    
    //private List<OrderFormItem> items;
    
    private Integer goodsO2OType;  //区分线上线下商品     1.  线下商品

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getPayMsg() {
        return payMsg;
    }

    public void setPayMsg(String payMsg) {
        this.payMsg = payMsg == null ? null : payMsg.trim();
    }

    public String getOrderSellerIntro() {
        return orderSellerIntro;
    }

    public void setOrderSellerIntro(String orderSellerIntro) {
        this.orderSellerIntro = orderSellerIntro == null ? null : orderSellerIntro.trim();
    }

    public String getReturnContent() {
        return returnContent;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent == null ? null : returnContent.trim();
    }

    private StoreWithBLOBs store;
    private List<OrderFormLog> ofls = new ArrayList<OrderFormLog>();
    private Payment payment;
    private CouponInfo ci;
    private List<GoodsReturnLog> grls=new ArrayList<GoodsReturnLog>();
    
    public StoreWithBLOBs getStore() {
		return store;
	}

	public void setStore(StoreWithBLOBs store) {
		this.store = store;
	}


	

	public List<OrderFormLog> getOfls() {
		return ofls;
	}

	public void setOfls(List<OrderFormLog> ofls) {
		this.ofls = ofls;
	}

	
	

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
		if(payment!=null)
		{
			this.setPaymentId(payment.getId());
		}
	}

	

	public CouponInfo getCi() {
		return ci;
	}

	public void setCi(CouponInfo ci) {
		this.ci = ci;
	}

	public List<GoodsReturnLog> getGrls() {
		return grls;
	}

	public void setGrls(List<GoodsReturnLog> grls) {
		this.grls = grls;
	}

	public RefundGoods getRefundGoods() {
		return refundGoods;
	}

	public void setRefundGoods(RefundGoods refundGoods) {
		this.refundGoods = refundGoods;
	}

	
	public Integer getGoodsO2OType ( )
		{
			return goodsO2OType;
		}

	
	public void setGoodsO2OType (Integer goodsO2OType)
		{
			this.goodsO2OType = goodsO2OType;
		}

	/*public List<OrderFormItem> getItems() {
		return items;
	}

	public void setItems(List<OrderFormItem> items) {
		this.items = items;
	}*/
	
	
	
	
}