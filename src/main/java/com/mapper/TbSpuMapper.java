package com.mapper;

import com.po.TbSpu;
import com.po.TbSpuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSpuMapper {
    int countByExample(TbSpuExample example);

    int deleteByExample(TbSpuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpu record);

    int insertSelective(TbSpu record);

    List<TbSpu> selectByExampleWithBLOBs(TbSpuExample example);

    List<TbSpu> selectByExample(TbSpuExample example);

    TbSpu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpu record, @Param("example") TbSpuExample example);

    int updateByExampleWithBLOBs(@Param("record") TbSpu record, @Param("example") TbSpuExample example);

    int updateByExample(@Param("record") TbSpu record, @Param("example") TbSpuExample example);

    int updateByPrimaryKeySelective(TbSpu record);

    int updateByPrimaryKeyWithBLOBs(TbSpu record);

    int updateByPrimaryKey(TbSpu record);
}