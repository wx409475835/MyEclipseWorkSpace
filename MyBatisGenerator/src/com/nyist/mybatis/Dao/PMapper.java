package com.nyist.mybatis.Dao;

import com.nyist.mybatis.model.P;
import com.nyist.mybatis.model.PExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PMapper {
    int countByExample(PExample example);

    int deleteByExample(PExample example);

    int deleteByPrimaryKey(String birthday);

    int insert(P record);

    int insertSelective(P record);

    List<P> selectByExample(PExample example);

    int updateByExampleSelective(@Param("record") P record, @Param("example") PExample example);

    int updateByExample(@Param("record") P record, @Param("example") PExample example);
}