package com.amall.core.action.time;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amall.common.constant.Globals;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;
import com.amall.core.service.goods.IGoodsService;
import com.amall.core.service.group.IGroupGoodsService;
import com.amall.core.service.group.IGroupService;

@Component("group_job")
public class GroupJobManageAction
{

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IGroupGoodsService groupGoodsService;

	@Autowired
	private IGoodsService goodsService;

	/**
	 * 1.扫团购表开启活动
	 * 2.扫团购表活动结束的操作
	 * 
	 * @throws Exception
	 */
	private void execute ( ) throws Exception
		{
			// 扫团购表开启活动 start
			GroupExample groupExample1 = new GroupExample ();
			groupExample1.clear ();
			GroupExample.Criteria groupCriteria1 = groupExample1.createCriteria ();
			// 状态未开始
			groupCriteria1.andStatusEqualTo (Globals.NUBER_ONE);
			// 当前时间大于活动开始时间的
			groupCriteria1.andBegintimeLessThanOrEqualTo (new Date ());
			// 活动结束时间大于当前时间的
			groupCriteria1.andEndtimeGreaterThanOrEqualTo (new Date ());
			List <Group> groups1 = this.groupService.getObjectList (groupExample1);
			if (!groups1.isEmpty ())
			{
				for (Group g : groups1)
				{
					// 状态正常开始
					g.setStatus (Globals.NUBER_ZERO);
					this.groupService.updateByObject (g);
				}
			}
			// 扫团购表开启活动 end
			// 扫团购表活动结束的操作 start
			GroupExample groupExample = new GroupExample ();
			groupExample.clear ();
			GroupExample.Criteria groupCriteria = groupExample.createCriteria ();
			// 状态为启用的
			groupCriteria.andStatusEqualTo (Globals.NUBER_ZERO);
			// 当前时间大于活动结束时间的
			groupCriteria.andEndtimeLessThanOrEqualTo (new Date ());
			List <Group> groups = this.groupService.getObjectList (groupExample);
			if (!groups.isEmpty ())
			{
				for (Group g : groups)
				{
					// 根据groupId查询goods表的groupId的状态值是否更改为null了
					// 如果为null，则该条数据不做处理,否则将
					// 1.groupBuy的值2更改为0, 2.groupId设置为null 3.Group的status为-2,设为已结束(下次进来不会扫到)
					GoodsExample goodsExample = new GoodsExample ();
					goodsExample.clear ();
					GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria ();
					goodsCriteria.andGroupIdEqualTo (g.getId ());
					List <GoodsWithBLOBs> goodsList = this.goodsService.getObjectList (goodsExample);
					if (!goodsList.isEmpty ())
					{
						// 设置1和2
						for (GoodsWithBLOBs goodsWithBLOBs : goodsList)
						{
							goodsWithBLOBs.setGroupBuy (Globals.NUBER_ZERO);
							goodsWithBLOBs.setGroupId (Long.valueOf (0));
							this.goodsService.updateByObject (goodsWithBLOBs);
						}
						// 设置已结束
						g.setStatus (-2);
						this.groupService.updateByObject (g);
					}
					else
					{
						continue;
					}
				}
			}
			// 扫团购表活动结束的操作 end
		}
}
