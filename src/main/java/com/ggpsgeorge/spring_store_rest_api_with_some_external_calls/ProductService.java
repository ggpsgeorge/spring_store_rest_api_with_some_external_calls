package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    @Autowired
    RestTemplate restTemplate ;
    @Autowired
    ProductRepository productRepository;

    public Product callFakeApiFindProduct(Long id) {
        String url = "https://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);

        return new Product.ProductBuilder()
            .id(product.getId())
            .title(product.getTitle())
            .price(product.getPrice())
            .description(product.getDescription())
            .category(product.getCategory())
            .image(product.getImage())
            .rating(product.getRating())
            .build();
    }
    
    public List<Product> callFakeApiFindAllProducts(){
        String url = "https://fakestoreapi.com/products";

        Product[] fakeProducts = restTemplate.getForObject(url, Product[].class);
        List<Product> all_products = new ArrayList<Product>();
        
        for(Product fakeProduct: fakeProducts){
            
            Product product = new Product.ProductBuilder()
                .id(fakeProduct.getId())
                .title(fakeProduct.getTitle())
                .price(fakeProduct.getPrice())
                .description(fakeProduct.getDescription())
                .category(fakeProduct.getCategory())
                .image(fakeProduct.getImage())
                .rating(fakeProduct.getRating())
                .build();

            all_products.add(product);
        }
        return all_products;
    }

    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product findProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public String removeProduct(Long id) {
        productRepository.deleteById(id);
        return "Product " + id +" was removed!"; 
    }

    public Product updateProduct(Long id, Product product) {
        Product persisted_product = productRepository.findById(id).get();
        Product new_product = Product.builder()
            .id(persisted_product.getId())
            .title(product.getTitle())
            .price(product.getPrice())
            .description(product.getDescription())
            .category(product.getCategory())
            .image(product.getImage())
            .rating(product.getRating())
            .build();
        
        productRepository.deleteById(id);

        return productRepository.save(new_product);

    }

}
