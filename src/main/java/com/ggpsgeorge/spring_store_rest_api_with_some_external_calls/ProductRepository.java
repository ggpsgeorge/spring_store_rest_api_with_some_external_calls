package com.ggpsgeorge.spring_store_rest_api_with_some_external_calls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
