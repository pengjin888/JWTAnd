package com.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    List select();
}
