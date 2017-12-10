package com.amall.core.action.buyercloud;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author tangxiang
 */
public final class AmallCloudPool implements CloudPool
{

	private AmallCloudPool ( )
	{
	}

	/**
	 * 全局保存的云兑商品集合
	 */
	private static Map <Long, CloudGoods> CLOUD_GOODS_MAP = new HashMap <> ();

	private static AmallCloudPool cloudPool = new AmallCloudPool ();

	public static AmallCloudPool getInstance ( )
		{
			return cloudPool;
		}

	@Override
	public void addNewGoods (int codeCount , long goodsId)
		{
			/* 生成一个数组 */
			int [ ] arr = newArray (codeCount);
			/* 随机打乱数组 */
			upsetArray (arr);
			/* 放入list */
			CloudGoods goods = new CloudGoods (arr);
			CLOUD_GOODS_MAP.put (goodsId , goods);
		}

	@Override
	public int [ ] getGoods (int number , long goodsId)
		{
			if (number == 0 || goodsId < 1)
			{
				return null;
			}
			return CLOUD_GOODS_MAP.get (goodsId).getCloudCodes (number);
		}

	@Override
	public boolean isEnd (long goodsId)
		{
			return CLOUD_GOODS_MAP.get (goodsId).isEnd ();
		}

	@Override
	public int remainCodes (long goodsId)
		{
			return CLOUD_GOODS_MAP.get (goodsId).remainCodes ();
		}

	private int [ ] newArray (int number)
		{
			int [ ] arr = new int [number];
			for (int i = 0 ; i < number ; i++)
			{
				arr[i] = i + 1;
			}
			return arr;
		}

	/**
	 * @Title: upsetArray
	 * @Description: 打乱数组
	 * @param arr
	 * @throws
	 * @author tangxiang
	 * @date 2016年1月20日
	 */
	private void upsetArray (int [ ] arr)
		{
			int temp = 0;
			int randomNumber = 0;
			Random random = new Random ();
			for (int i = 0 ; i < arr.length ; i++)
			{
				randomNumber = random.nextInt (arr.length);
				temp = arr[i];
				arr[i] = arr[randomNumber];
				arr[randomNumber] = temp;
			}
		}

	/**
	 * 保存云码结构体
	 * 
	 * @author tangxiang
	 *
	 */
	private class CloudGoods
	{

		/**
		 * 商品云码数组
		 */
		public int [ ] cloudGoods;

		/**
		 * 当前获取云码的下标
		 */
		public int index = 0;

		/**
		 * 云码数组长度
		 */
		public final int length;

		/**
		 * 初始化摇奖号数组
		 * 
		 * @param arr
		 */
		public CloudGoods (int [ ] arr)
		{
			cloudGoods = arr;
			length = arr.length;
		}

		/**
		 * @Title: getCloudCodes
		 * @Description: 获取对应数量的兑购码
		 * @param number
		 * @throws
		 * @author tangxiang
		 * @date 2016年1月20日
		 */
		public synchronized int [ ] getCloudCodes (int number)
			{
				/* 判断是否还有足够的云码可以获取 */
				if ((number + index - 1) < length)
				{
					int [ ] arr = new int [number];
					System.arraycopy (cloudGoods , index , arr , 0 , number);
					/* 下标移动number长度 */
					if (index == 0)
					{
						index += number - 1;
					}
					else
					{
						index += number;
					}
					return arr;
				}
				return null;
			}

		/**
		 * @Title: isEnd
		 * @Description: 是否结束
		 * @return
		 * @throws
		 * @author tangxiang
		 * @date 2016年1月20日
		 */
		public boolean isEnd ( )
			{
				return (length - 1) == index;
			}

		/**
		 * @Title: remainCodes
		 * @Description: 返回剩余云码
		 * @return
		 * @throws
		 * @author tangxiang
		 * @date 2016年1月20日
		 */
		public int remainCodes ( )
			{
				return length - index - 1;
			}
	}

	public static void main (String [ ] args)
		{
			AmallCloudPool.getInstance ().addNewGoods (20 , 50);
			int [ ] arr = AmallCloudPool.getInstance ().getGoods (10 , 50);
			// CloudPool.getInstance().getExchangeGoods(12, 50);
			// CloudPool.getInstance().getExchangeGoods(1, 50);
			for (int i = 0 ; i < arr.length ; i++)
			{
				System.out.print (arr[i] + ", ");
			}
			System.out.println ();
			System.out.println (AmallCloudPool.getInstance ().remainCodes (50));
			System.out.println (AmallCloudPool.getInstance ().isEnd (50));
		}
}
