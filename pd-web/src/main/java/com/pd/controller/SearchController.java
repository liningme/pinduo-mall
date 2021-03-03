package com.pd.controller;

import com.pd.pojo.Item;
import com.pd.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//SearchController 控制器
@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;

    // http://localhost/search/toSearch.html?key=a&page=3&size=20
    // http://localhost/search/toSearch.html?key=a&page=3&size=20

    @GetMapping("/search/toSearch.html")
    public String search(String key, Pageable pageable, Model model) {
        Page<Item> page = searchService.search(key, pageable);
        model.addAttribute("page", page);
        return "/search.jsp";
    }
}
