package com.service.impl;

import com.mapper.ProductsMapper;
import com.service.ProductsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Resource
    private ProductsMapper productsMapper;

    @Override
    public List select(){
        return productsMapper.select();
    }
}
