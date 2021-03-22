package com.mapper;

import com.po.TbSku;
import com.po.TbSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSkuMapper {
    int countByExample(TbSkuExample example);

    int deleteByExample(TbSkuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSku record);

    int insertSelective(TbSku record);

    List<TbSku> selectByExample(TbSkuExample example);

    TbSku selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSku record, @Param("example") TbSkuExample example);

    int updateByExample(@Param("record") TbSku record, @Param("example") TbSkuExample example);

    int updateByPrimaryKeySelective(TbSku record);

    int updateByPrimaryKey(TbSku record);
}