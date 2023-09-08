package ss9.bt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ss9.bt.model.Product;
import ss9.bt.service.IProductService;


import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public ModelAndView listProducts() {
       return new ModelAndView("list","products",productService.findAll());
    }

    @GetMapping("/add")
    public ModelAndView showCreateForm() {
        return new ModelAndView("add","product",new Product());
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return new ModelAndView("edit","product",product.get());
        } else {
            return new ModelAndView("404");
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
       return "redirect:/";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }



}

