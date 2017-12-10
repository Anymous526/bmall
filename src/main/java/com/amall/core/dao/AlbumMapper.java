package com.amall.core.dao;

import com.amall.core.bean.Album;
import com.amall.core.bean.AlbumExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AlbumMapper {
    int countByExample(AlbumExample example);

    int deleteByExample(AlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Album record);

    Long insertSelective(Album record);

    List<Album> selectByExampleWithBLOBs(AlbumExample example);
    List<Album> selectByExampleWithBLOBsAndPage(AlbumExample example);

    List<Album> selectByExample(AlbumExample example);
    List<Album> selectByExampleWithPage(AlbumExample example);

    Album selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExampleWithBLOBs(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByExample(@Param("record") Album record, @Param("example") AlbumExample example);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKeyWithBLOBs(Album record);

    int updateByPrimaryKey(Album record);
}