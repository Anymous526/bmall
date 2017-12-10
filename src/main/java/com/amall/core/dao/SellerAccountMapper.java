package com.amall.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.amall.core.bean.SellerAccount;
import com.amall.core.bean.SellerAccountExample;

public interface SellerAccountMapper {
	int countByExample(SellerAccountExample example);

	int deleteByExample(SellerAccountExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SellerAccount record);

	int insertSelective(SellerAccount record);

	List<SellerAccount> selectByExample(SellerAccountExample example);

	List<SellerAccount> selectByExampleWithPage(SellerAccountExample example);

	SellerAccount selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SellerAccount record, @Param("example") SellerAccountExample example);

	int updateByExample(@Param("record") SellerAccount record, @Param("example") SellerAccountExample example);

	int updateByPrimaryKeySelective(SellerAccount record);

	int updateByPrimaryKey(SellerAccount record);
}