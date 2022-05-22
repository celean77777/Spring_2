package com.celean.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepo {

    @Autowired
    @Qualifier(value = "getProduct")
    private List<Product> productList;

    public Product getProduct(int productId){
       return productList.stream().filter(a->a.getId()==productId).findFirst().orElse(null);
    }

    public List<Product> getProductList(){
        return productList;
    }

}
