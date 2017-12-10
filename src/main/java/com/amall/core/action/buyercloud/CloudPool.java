package com.amall.core.action.buyercloud;

/**
 * @author tangxiang
 * 兑购池
 * 内部类 CloudGoods 是 核心数据结构，由int数组和数组下标和数组长度构成
 * 单例 CloudPool，维持两个map 一个是云兑map 一个是兑购map
 * 每次获取云码后移动CloudGoods的数组下标，当小标小于数组长度 -1，即表示该商品云码已经取完
 * 移动数组下标是线程安全的
 * 这样的设计是为了尽可能的保证取云码效率的高和稳定
 */
public interface CloudPool
{	
	
	/** 
	* @Title: addNewGoods 
	* @Description: 生成一个新的云兑商品
	* @param codeCount 生成云兑码的数量
	* @param goodsId 商品id
	* @throws 
	* @author tangxiang
	* @date 2016年1月20日
	*/
	void addNewGoods(int codeCount, long goodsId);
	
	/** 
	* @Title: getGoods 
	* @Description: 获取云兑码 
	* @param number 获取云兑码数量
	* @param goodsId 商品id
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年1月20日
	*/
	int[] getGoods(int number, long goodsId);
	
	
	/** 
	* @Title: isEnd 
	* @Description: 是否取完云码 
	* @param goodsId
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年1月20日
	*/
	boolean isEnd(long goodsId);
	
	/** 
	* @Title: remainCodes 
	* @Description: 返回剩余的云码
	* @param goodsId
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年1月20日
	*/
	int remainCodes(long goodsId);
	
}
