package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/external/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<Product>(productService.callFakeApiFindProduct(id), HttpStatus.OK);
    }

    @GetMapping("/external/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.callFakeApiFindAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/external-save/products")
    public ResponseEntity<List<Product>> saveProducts(){
        List<Product> products = productService.callFakeApiFindAllProducts();
        return ResponseEntity.ok().body(productService.addProducts(products));
    }
}
