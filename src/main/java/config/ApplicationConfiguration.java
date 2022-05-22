package config;

import com.celean.task5.Product;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.celean.task5")
public class ApplicationConfiguration {

    @Bean
    public List<Product> getProduct(){
            List<Product> productList = new ArrayList<>();
            for (int i = 0;i<5;i++){
                productList.add(new Product(i, "anyProduct", "anyCost"));
            }
        return productList;
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public List<Product> getProductCart(){
        List<Product> productList = new ArrayList<>();
        return productList;
    }
}
