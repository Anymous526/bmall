package com.amall.core.bean;

public class IntegralGoodsOrderWithBLOBs extends IntegralGoodsOrder {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String igoMsg;

    private String igoPayMsg;

    private String igoShipContent;  //发货说明

    public String getIgoMsg() {
        return igoMsg;
    }

    public void setIgoMsg(String igoMsg) {
        this.igoMsg = igoMsg == null ? null : igoMsg.trim();
    }

    public String getIgoPayMsg() {
        return igoPayMsg;
    }

    public void setIgoPayMsg(String igoPayMsg) {
        this.igoPayMsg = igoPayMsg == null ? null : igoPayMsg.trim();
    }

    public String getIgoShipContent() {
        return igoShipContent;
    }

    public void setIgoShipContent(String igoShipContent) {
        this.igoShipContent = igoShipContent == null ? null : igoShipContent.trim();
    }
    
    
}