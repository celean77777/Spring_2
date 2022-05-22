package com.celean.task5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    @Autowired
    @Qualifier(value = "getProductCart")
    private  List<Product> cartProductList;

    public void addProductToCart(Product product){
        cartProductList.add(product);
    }

    public void deleteProductFromCart(int i){
        cartProductList.removeIf(e->e.getId()==i);
    }
    public void addAll(List<Product> listFromRepo){
        cartProductList = listFromRepo;
    }
    public void clear(){
        cartProductList.clear();
    }
    public void showCart(){
        cartProductList.forEach(System.out::println);
    }
}
