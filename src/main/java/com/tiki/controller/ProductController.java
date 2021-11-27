package com.tiki.controller;

import com.tiki.model.Product;
import com.tiki.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/")
public class ProductController {

    @Autowired
    private ProductService ProductService;

    @RequestMapping("/products")
    public String showProductList(){
        return "products";
    }
}
