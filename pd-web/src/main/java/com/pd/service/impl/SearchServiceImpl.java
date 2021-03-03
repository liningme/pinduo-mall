package com.pd.service.impl;

import com.pd.es.ItemRepository;
import com.pd.pojo.Item;
import com.pd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//SearchServiceImpl 业务实现类
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Page<Item> search(String key, Pageable pageable) {
        return itemRepository.findByTitleOrSellPoint(key, key, pageable);
    }
}
