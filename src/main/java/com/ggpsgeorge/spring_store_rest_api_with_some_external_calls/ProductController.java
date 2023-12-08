package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/external/product/{id}")
    public ResponseEntity<Product> getExternalProductById(@PathVariable Long id){
        return new ResponseEntity<Product>(productService.callFakeApiFindProduct(id), HttpStatus.OK);
    }

    @GetMapping("/external/products")
    public ResponseEntity<List<Product>> getAllExternalProducts(){
        return new ResponseEntity<List<Product>>(productService.callFakeApiFindAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/external-save/products")
    public ResponseEntity<List<Product>> saveProductsExternal(){
        List<Product> products = productService.callFakeApiFindAllProducts();
        return ResponseEntity.ok().body(productService.addProducts(products));
    }

    @PostMapping("/save/products")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products) {
        return ResponseEntity.ok().body(productService.addProducts(products));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findProduct(id));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.findProducts());
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok().body(productService.updateProduct(id, product));
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchElementException() {
        return ResponseEntity.notFound().build();
    }
}
