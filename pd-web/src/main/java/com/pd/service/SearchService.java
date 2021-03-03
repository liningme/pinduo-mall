package com.pd.service;

import com.pd.pojo.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//SearchService 业务接口
public interface SearchService {
    Page<Item> search(String key, Pageable pageable);
}
