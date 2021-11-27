package com.tiki.controller;

import com.tiki.model.Category;
import com.tiki.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
}
