package com.amall.core.dao;

import com.amall.core.bean.Address;
import com.amall.core.bean.AddressExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Address record);

    Long insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);
    List<Address> selectByExampleWithPage(AddressExample example);

    Address selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}