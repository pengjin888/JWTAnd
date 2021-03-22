package com.service.impl;

import com.mapper.TbSkuMapper;
import com.po.TbSku;
import com.service.TbSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TbSkuService")
public class TbSkuServiceImpl implements TbSkuService {
    @Autowired
    TbSkuMapper tbSkuMapper;
    @Override
    public List select(int x) {
        ArrayList<TbSku> tbSkus = new ArrayList<>();
        tbSkus.add(tbSkuMapper.selectByPrimaryKey(1L));
        tbSkus.add(tbSkuMapper.selectByPrimaryKey(3L));
        return tbSkus;
    }
}
