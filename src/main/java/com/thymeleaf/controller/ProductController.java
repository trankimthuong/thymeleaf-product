package com.thymeleaf.controller;

import com.thymeleaf.model.ProductModel;
import com.thymeleaf.service.IProductService;
import com.thymeleaf.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String index(Model model){
        List<ProductModel> products = productService.findAll();
        for(ProductModel productModel : products){
            System.out.println(productModel.getName());
        }
        model.addAttribute("listproduct", products);
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model){
        model.addAttribute("product", new ProductModel());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(ProductModel product, RedirectAttributes redirect) {
        List<ProductModel> products = productService.findAll();
        product.setId((long) products.size() + 1);
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(ProductModel product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/product/delete")
    public String delete(ProductModel product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
