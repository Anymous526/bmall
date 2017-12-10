package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class VipActiveLog implements Serializable
{

	private static final long serialVersionUID = 1472415314443881690L;

	private Long id;

	private Date addtime;

	private Long userId;

	private Integer angelGold;

	private BigDecimal upgradeFee;

	private Long payId;

	private String content;

	private Long payUserId;
	
    private Integer financialGold;	

	public Integer getFinancialGold() {
		return financialGold;
	}

	public void setFinancialGold(Integer financialGold) {
		this.financialGold = financialGold;
	}

	public Long getId ( )
		{
			return id;
		}

	public void setId (Long id)
		{
			this.id = id;
		}

	public Date getAddtime ( )
		{
			return addtime;
		}

	public void setAddtime (Date addtime)
		{
			this.addtime = addtime;
		}

	public Long getUserId ( )
		{
			return userId;
		}

	public void setUserId (Long userId)
		{
			this.userId = userId;
		}

	public Integer getAngelGold ( )
		{
			return angelGold;
		}

	public void setAngelGold (Integer angelGold)
		{
			this.angelGold = angelGold;
		}

	public BigDecimal getUpgradeFee ( )
		{
			return upgradeFee;
		}

	public void setUpgradeFee (BigDecimal upgradeFee)
		{
			this.upgradeFee = upgradeFee;
		}

	public Long getPayUserId ( )
		{
			return payUserId;
		}

	public void setPayUserId (Long payUserId)
		{
			this.payUserId = payUserId;
		}

	public Long getPayId ( )
		{
			return payId;
		}

	public void setPayId (Long payId)
		{
			this.payId = payId;
		}

	public String getContent ( )
		{
			return content;
		}

	public void setContent (String content)
		{
			this.content = content == null ? null : content.trim ();
		}

	private User user;

	private AlipayOrder payOrder;

	private User payUser;

	private List <MutualBenefit> mutualBenefits;

	public User getUser ( )
		{
			return user;
		}

	public void setUser (User user)
		{
			this.user = user;
			if (user != null)
				this.userId = user.getId ();
		}

	public AlipayOrder getPayOrder ( )
		{
			return payOrder;
		}

	public void setPayOrder (AlipayOrder payOrder)
		{
			this.payOrder = payOrder;
		}

	public User getPayUser ( )
		{
			return payUser;
		}

	public void setPayUser (User payUser)
		{
			this.payUser = payUser;
		}

	public List <MutualBenefit> getMutualBenefits ( )
		{
			return mutualBenefits;
		}

	public void setMutualBenefits (List <MutualBenefit> mutualBenefits)
		{
			this.mutualBenefits = mutualBenefits;
		}
}