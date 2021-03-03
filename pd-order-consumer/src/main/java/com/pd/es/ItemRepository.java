package com.pd.es;

import com.pd.pojo.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    Page<Item> findByTitleOrSellPoint(String key1, String key2, Pageable pageable);
}
