package com.pd.service;

import com.pd.pojo.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchService {
    Page<Item> search(String key, Pageable pageable);
}
