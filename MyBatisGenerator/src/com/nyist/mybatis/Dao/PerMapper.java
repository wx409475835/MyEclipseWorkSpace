package com.nyist.mybatis.Dao;

import com.nyist.mybatis.model.Per;
import com.nyist.mybatis.model.PerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerMapper {
    int countByExample(PerExample example);

    int deleteByExample(PerExample example);

    int insert(Per record);

    int insertSelective(Per record);

    List<Per> selectByExample(PerExample example);

    int updateByExampleSelective(@Param("record") Per record, @Param("example") PerExample example);

    int updateByExample(@Param("record") Per record, @Param("example") PerExample example);
}