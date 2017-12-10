package com.amall.core.web.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.PromoteDream;
import com.amall.core.bean.PromoteDreamExample;
import com.amall.core.bean.PromoteDreamFee;
import com.amall.core.bean.PromoteVipHistory;
import com.amall.core.bean.PromoteVipItem;
import com.amall.core.bean.PromoteVipRank;
import com.amall.core.bean.PromoteVipRankExample;
import com.amall.core.bean.User;
import com.amall.core.lee.LeeUtil;
import com.amall.core.service.promote.IPromoteDreamFeeService;
import com.amall.core.service.promote.IPromoteDreamService;
import com.amall.core.service.promote.IPromoteDreamSetService;
import com.amall.core.service.promote.IPromoteVipHistoryService;
import com.amall.core.service.promote.IPromoteVipItemService;
import com.amall.core.service.promote.IPromoteVipRankService;
import com.amall.core.service.user.IUserService;

/**
 * 联盟商家推广分利工具类
 *
 * <p>detailed comment
 * @author tx 2016年6月22日
 * @see
 * @since 1.0
 */
@Component
public class PromoteTools
{
    @Autowired
    private IPromoteVipHistoryService promoteVipHistoryService;
    
    @Autowired
    private IPromoteVipRankService promoteVipRankService;
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IPromoteVipItemService promoteVipItemService;
    
    @Autowired
    private IPromoteDreamSetService promoteDreamSetService;
    
    @Autowired
    private IPromoteDreamService promoteDreamService;
    
    @Autowired
    private IPromoteDreamFeeService promoteDreamFeeService;
    
    /**
     * 更新推广数据
     * @param user
     * @param payAmount
     */
    public void savePromoteInfo(User user, BigDecimal payAmount)
    {
        
        /* 处理上月推广分红金额 */
        processPromoteBenefit();
        
        if(user.getDirectRefer() == null)
        {
            return;
        }
        
        /* 推广会员不是vip也不算，历史遗留数据 */
        if(userService.getByKey(user.getDirectRefer()).getLevelAngel().intValue() == 0)
        {
            return;
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
        /* 更新推广排名数据 */
        updateRankRecord(user, payAmount, calendar);
        
        /* 保存推广详情 */
        savePromoteItem(calendar, user, payAmount);
        
        /* 更新排名 */
        updateRank();
        
    }
    
    private void updateRank()
    {
        PromoteVipRankExample example = new PromoteVipRankExample();
        example.setOrderByClause("promote_fee desc");
        
        List<PromoteVipRank> list = promoteVipRankService.getObjectList(example);
        
        if(!list.isEmpty())
        {
            int tempRank = 1;
            
            BigDecimal tempFee = list.get(0).getPromoteFee();
            
            int[] ranks = new int[list.size()];
            ranks[0] = tempRank;
            
            for(int i = 1; i < list.size(); i ++)
            {
                if(!list.get(i).getPromoteFee().equals(tempFee))
                {
                    tempRank ++;
                    tempFee = list.get(i).getPromoteFee();
                }
                
                ranks[i] = tempRank;
            }
            
            for(int i = 0; i < list.size(); i ++)
            {
                PromoteVipRank vipRank = list.get(i);
                vipRank.setRank(ranks[i]);
                promoteVipRankService.updateByObject(vipRank);
            }
            
        }
        
    }
    
    private void updateRankRecord(User user, BigDecimal payAmount, Calendar calendar)
    {
        /* 更新推广排名数据
         * 1.查询是否已有当前月推广数据
         * 2.修改或新增推广数据
         * 3.更新排名
         *  */
        PromoteVipRankExample example = new PromoteVipRankExample();
        example.createCriteria().andUserIdEqualTo(user.getDirectRefer());
        List<PromoteVipRank> list = promoteVipRankService.getObjectList(example);
        
        if(!list.isEmpty())
        {
            PromoteVipRank promoteVipRank = list.get(0);
            
            if(user.getLevelAngel().intValue() == Globals.NUBER_THREE)
            {
                promoteVipRank.setPromoteVip1Number(promoteVipRank.getPromoteVip1Number() + 1);
            }
            
            if(user.getLevelAngel().intValue() == Globals.NUBER_FIVE)
            {
                promoteVipRank.setPromoteVip2Number(promoteVipRank.getPromoteVip2Number() + 1);
            }
            
            promoteVipRank.setPromoteFee(promoteVipRank.getPromoteFee().add(payAmount));
            promoteVipRankService.updateByObject(promoteVipRank);
        }
        else
        {
            User promoteUser = userService.getByKey(user.getDirectRefer());
            PromoteVipRank promoteVipRank = new PromoteVipRank();
            promoteVipRank.setAddTime(calendar.getTime());
            
            if(user.getLevelAngel().intValue() == Globals.NUBER_THREE)
            {
                promoteVipRank.setPromoteVip1Number(1);
            }
            
            if(user.getLevelAngel().intValue() == Globals.NUBER_FIVE)
            {
                promoteVipRank.setPromoteVip2Number(1);
            }
            
            promoteVipRank.setMonth(calendar.get(Calendar.MONTH) + 1);
            promoteVipRank.setYear(calendar.get(Calendar.YEAR));
            promoteVipRank.setPromoteFee(payAmount);
            System.out.println("promoteUser.getTruename() " + promoteUser.getTruename());
            promoteVipRank.setUserName(promoteUser.getTruename());
            promoteVipRank.setUserId(promoteUser.getId());
            promoteVipRank.setUserLevel(promoteUser.getLevelAngel());
            promoteVipRankService.add(promoteVipRank);
        }
    }
    
    private void savePromoteItem(Calendar calendar, User user, BigDecimal payAmount)
    {
        /* 保存推广详情 */
        PromoteVipItem item = new PromoteVipItem();
        item.setAddTime(calendar.getTime());
        item.setMonth(calendar.get(Calendar.MONTH) + 1);
        item.setYear(calendar.get(Calendar.YEAR));
        item.setPromoteUserId(user.getDirectRefer());
        item.setUpgradeFee(payAmount);
        item.setUpgradeLevel(user.getLevelAngel());
        item.setUpgradeUserId(user.getId());
        item.setUpgradeUserName(user.getTruename());
        promoteVipItemService.add(item);
    }
    
    
    /**
     * 处理上月推广金额
     * @param calendar
     */
    public synchronized void processPromoteBenefit()
    {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            
            /* 存在上月数据在排名表才处理 */
            PromoteVipRankExample example = new PromoteVipRankExample();
            
            example.createCriteria().andMonthEqualTo(calendar.get(Calendar.MONTH))
                .andYearEqualTo(calendar.get(Calendar.YEAR));
            int count = promoteVipRankService.getObjectListCount(example);
            
            if(count == 0)
            {
                return;
            }
            
            /* 
             * 1.获取平台当月升级vip的总额的5% 
             * 2.平均分配给前N名
             * 3.存放所有记录到历史纪录中
             * 4.在当月排名表中删除上月数据
             * */
            
            List<PromoteVipRank> ranks = promoteVipRankService.getObjectList(example);
            BigDecimal monthFee = BigDecimal.ZERO;
            
            /* 获取前5名主键id, 前5名是指，金额排名前5名，所以可能会出现并列的情况 */
            List<PromoteVipRank> benefitUserList = new ArrayList<>();
            
            List<PromoteVipRank> noBenefitUserList = new ArrayList<>();
            
            for(PromoteVipRank rank:ranks)
            {
                /* 获取排名内和非排名内 */
                if(rank.getRank().intValue() <= Globals.PROMOTE_RANK)
                {
                    benefitUserList.add(rank);
                }
                else
                {
                    noBenefitUserList.add(rank);
                }
                
                /* 获取总推广额度 */
                monthFee = monthFee.add(rank.getPromoteFee());
            }
            
            /* 保存分利纪录 */
            if(monthFee.intValue() > 0)
            {
                /* 会员分利 */
                processPromoteDreamBenefit(monthFee);
                
                /* 获取总分红金额 */
                monthFee = monthFee.multiply(new BigDecimal(Globals.PROMOTE_RANK_RATE));
                
                /* 每人分红 */
                BigDecimal fee = monthFee.divide(new BigDecimal(benefitUserList.size()), 2, BigDecimal.ROUND_DOWN);
                
                for(PromoteVipRank rank:benefitUserList)
                {
                    benefitUser(fee, rank.getUserId());
                    addPromoteVipHistory(fee, rank);
                }
            }
            
            /* 保存剩余推广纪录 */
            for(PromoteVipRank rank:noBenefitUserList)
            {
                addPromoteVipHistory(null, rank);
            }
            
            /* 4 删除上月数据 */
            promoteVipRankService.deleteByExample(example);
        
    }
   
    private void processPromoteDreamBenefit(BigDecimal monthFee)
    {
        /* 获取总分红金额 */
        BigDecimal rate = promoteDreamSetService.getObjectList(null).get(0).getRate();
        BigDecimal dreamFee = monthFee.multiply(rate);
        
        /* 获取会员列表 */
        PromoteDreamExample dreamExample = new PromoteDreamExample();
        dreamExample.createCriteria().andApproveStatusEqualTo(true);
        List<PromoteDream> list = promoteDreamService.getObjectList(dreamExample);
        
        if(!list.isEmpty())
        {
            /* 每人分红 */
            BigDecimal fee = dreamFee.divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_DOWN);
            List<PromoteDreamFee> dreamFees = new ArrayList<>();
            PromoteDreamFee promoteDreamFee = null;
            
            for(PromoteDream dream:list)
            {
                promoteDreamFee = new PromoteDreamFee();
                promoteDreamFee.setAddTime(new Date());
                promoteDreamFee.setMonth(dream.getMonth());
                promoteDreamFee.setName(dream.getName());
                promoteDreamFee.setPromoteFee(fee);
                promoteDreamFee.setUserId(dream.getUserId());
                promoteDreamFee.setYear(dream.getYear());
                dreamFees.add(promoteDreamFee);
            }
            
            for(PromoteDreamFee pro:dreamFees)
            {
                promoteDreamFeeService.add(pro);
            }
        }
        
        
    }

    /**
     * 增加历史纪录
     */
    private void addPromoteVipHistory(BigDecimal fee, PromoteVipRank rank)
    {
        PromoteVipHistory history = new PromoteVipHistory();
        history.setAddTime(new Date());
        history.setBenefitFee(fee);
        history.setMonth(rank.getMonth());
        history.setPromoteFee(rank.getPromoteFee());
        history.setPromoteVip1Number(rank.getPromoteVip1Number());
        history.setPromoteVip2Number(rank.getPromoteVip2Number());
        history.setRank(rank.getRank());
        history.setUserId(rank.getUserId());
        history.setUserLevel(rank.getUserLevel());
        history.setUserName(rank.getUserName());
        history.setYear(rank.getYear());
        promoteVipHistoryService.add(history);
    }
    
    private void benefitUser(BigDecimal fee, Long userId)
    {
    	BigDecimal rate = LeeUtil.getConfigInstance().getBenefitRate();
    	BigDecimal rate2 = (new BigDecimal(1)).subtract(rate);
        User user = userService.getByKey(userId);
        user.setHistoryFee(user.getHistoryFee() != null ? user.getHistoryFee().add(fee) : fee);
        user.setCurrentFee(user.getCurrentFee() != null ? user.getCurrentFee().add(fee) : fee);
        user.setCanCarry(user.getCanCarry() != null ? user.getCanCarry().add(fee.multiply(rate)) : fee.multiply(rate));
        user.setManageMoney(user.getManageMoney() != null ? user.getManageMoney().add(fee.multiply(rate2)) : fee.multiply(rate2));
        userService.updateByObject(user);
    }
}
