package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;
import com.amall.core.web.BaseQuery;

/**
 * 积分商品订单
 * 
 * @author ljx
 *
 */
public class IntegralGoodsOrderQuery extends BaseQuery
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String igoOrderSn;

	private boolean igoOrderSnLike;

	private Date igoPayTime;

	private String igoPayment;

	private boolean igoPaymentLike;

	private String igoShipCode;

	private boolean igoShipCodeLike;

	private Date igoShipTime;

	private Integer igoStatus;

	private Integer igoTotalIntegral; // 以前的积分兑换改为礼品金兑换，这个字段现在用来记录礼品金

	private BigDecimal igoTransFee;

	private Long igoAddrId;

	private boolean igoAddrIdLike;

	private Long igoUserId;

	private boolean igoUserIdLike;

	private Long goodsId;

	public Long getId ( )
		{
			return id;
		}

	public IntegralGoodsOrderQuery setId (Long id)
		{
			this.id = id;
			return this;
		}

	public Date getAddtime ( )
		{
			return addtime;
		}

	public IntegralGoodsOrderQuery setAddtime (Date addtime)
		{
			this.addtime = addtime;
			return this;
		}

	public Boolean getDeletestatus ( )
		{
			return deletestatus;
		}

	public IntegralGoodsOrderQuery setDeletestatus (Boolean deletestatus)
		{
			this.deletestatus = deletestatus;
			return this;
		}

	public String getIgoOrderSn ( )
		{
			return igoOrderSn;
		}

	public IntegralGoodsOrderQuery setIgoOrderSn (String igoOrderSn)
		{
			this.igoOrderSn = igoOrderSn == null ? null : igoOrderSn.trim ();
			return this;
		}

	public Date getIgoPayTime ( )
		{
			return igoPayTime;
		}

	public IntegralGoodsOrderQuery setIgoPayTime (Date igoPayTime)
		{
			this.igoPayTime = igoPayTime;
			return this;
		}

	public String getIgoPayment ( )
		{
			return igoPayment;
		}

	public IntegralGoodsOrderQuery setIgoPayment (String igoPayment)
		{
			this.igoPayment = igoPayment == null ? null : igoPayment.trim ();
			return this;
		}

	public String getIgoShipCode ( )
		{
			return igoShipCode;
		}

	public IntegralGoodsOrderQuery setIgoShipCode (String igoShipCode)
		{
			this.igoShipCode = igoShipCode == null ? null : igoShipCode.trim ();
			return this;
		}

	public Date getIgoShipTime ( )
		{
			return igoShipTime;
		}

	public IntegralGoodsOrderQuery setIgoShipTime (Date igoShipTime)
		{
			this.igoShipTime = igoShipTime;
			return this;
		}

	public Integer getIgoStatus ( )
		{
			return igoStatus;
		}

	public IntegralGoodsOrderQuery setIgoStatus (Integer igoStatus)
		{
			this.igoStatus = igoStatus;
			return this;
		}

	public Integer getIgoTotalIntegral ( )
		{
			return igoTotalIntegral;
		}

	public IntegralGoodsOrderQuery setIgoTotalIntegral (Integer igoTotalIntegral)
		{
			this.igoTotalIntegral = igoTotalIntegral;
			return this;
		}

	public BigDecimal getIgoTransFee ( )
		{
			return igoTransFee;
		}

	public IntegralGoodsOrderQuery setIgoTransFee (BigDecimal igoTransFee)
		{
			this.igoTransFee = igoTransFee;
			return this;
		}

	public Long getIgoAddrId ( )
		{
			return igoAddrId;
		}

	public IntegralGoodsOrderQuery setIgoAddrId (Long igoAddrId)
		{
			this.igoAddrId = igoAddrId;
			return this;
		}

	public Long getIgoUserId ( )
		{
			return igoUserId;
		}

	public IntegralGoodsOrderQuery setIgoUserId (Long igoUserId)
		{
			this.igoUserId = igoUserId;
			return this;
		}

	public boolean isIgoOrderSnLike ( )
		{
			return igoOrderSnLike;
		}

	public IntegralGoodsOrderQuery setIgoOrderSnLike (boolean igoOrderSnLike)
		{
			this.igoOrderSnLike = igoOrderSnLike;
			return this;
		}

	public boolean isIgoPaymentLike ( )
		{
			return igoPaymentLike;
		}

	public IntegralGoodsOrderQuery setIgoPaymentLike (boolean igoPaymentLike)
		{
			this.igoPaymentLike = igoPaymentLike;
			return this;
		}

	public boolean isIgoShipCodeLike ( )
		{
			return igoShipCodeLike;
		}

	public IntegralGoodsOrderQuery setIgoShipCodeLike (boolean igoShipCodeLike)
		{
			this.igoShipCodeLike = igoShipCodeLike;
			return this;
		}

	public boolean isIgoAddrIdLike ( )
		{
			return igoAddrIdLike;
		}

	public IntegralGoodsOrderQuery setIgoAddrIdLike (boolean igoAddrIdLike)
		{
			this.igoAddrIdLike = igoAddrIdLike;
			return this;
		}

	public boolean isIgoUserIdLike ( )
		{
			return igoUserIdLike;
		}

	public IntegralGoodsOrderQuery setIgoUserIdLike (boolean igoUserIdLike)
		{
			this.igoUserIdLike = igoUserIdLike;
			return this;
		}

	public Long getGoodsId ( )
		{
			return goodsId;
		}

	public void setGoodsId (Long goodsId)
		{
			this.goodsId = goodsId;
		}

	private String igoMsg;

	private String igoPayMsg;

	private String igoShipContent;

	private boolean igoMsgLike;

	private boolean igoPayMsgLike;

	private boolean igoShipContentLike;

	public String getIgoMsg ( )
		{
			return igoMsg;
		}

	public IntegralGoodsOrderQuery setIgoMsg (String igoMsg)
		{
			this.igoMsg = igoMsg;
			return this;
		}

	public String getIgoPayMsg ( )
		{
			return igoPayMsg;
		}

	public IntegralGoodsOrderQuery setIgoPayMsg (String igoPayMsg)
		{
			this.igoPayMsg = igoPayMsg;
			return this;
		}

	public String getIgoShipContent ( )
		{
			return igoShipContent;
		}

	public IntegralGoodsOrderQuery setIgoShipContent (String igoShipContent)
		{
			this.igoShipContent = igoShipContent;
			return this;
		}

	public boolean isIgoMsgLike ( )
		{
			return igoMsgLike;
		}

	public IntegralGoodsOrderQuery setIgoMsgLike (boolean igoMsgLike)
		{
			this.igoMsgLike = igoMsgLike;
			return this;
		}

	public boolean isIgoPayMsgLike ( )
		{
			return igoPayMsgLike;
		}

	public IntegralGoodsOrderQuery setIgoPayMsgLike (boolean igoPayMsgLike)
		{
			this.igoPayMsgLike = igoPayMsgLike;
			return this;
		}

	public boolean isIgoShipContentLike ( )
		{
			return igoShipContentLike;
		}

	public IntegralGoodsOrderQuery setIgoShipContentLike (boolean igoShipContentLike)
		{
			this.igoShipContentLike = igoShipContentLike;
			return this;
		}

	/**
	 * 设置排序
	 * 
	 */
	protected String orderByClause;

	public String getOrderByClause ( )
		{
			return orderByClause;
		}

	public void setOrderByClause (String orderByClause)
		{
			this.orderByClause = orderByClause;
		}
}