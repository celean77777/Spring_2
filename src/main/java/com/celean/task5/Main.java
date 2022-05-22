package com.celean.task5;

import config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        System.out.println(ctx);

        Cart cart = ctx.getBean(Cart.class);
        ProductRepo productRepo = ctx.getBean(ProductRepo.class);
        cart.showCart();

        System.out.println("/end: выход" + "\n"
        + "/addprod: добавление продукта" + "\n"
        + "/delprod: удаление продукта" + "\n"
        + "/newcart: новая корзина" + "\n"
        + "/addall: добавляем все продукты из репо" + "\n"
        + "/clear: удаляем все продукты из корзины" + "\n"
        + "номер добавляемого/удаляемого продукта через ##");

        while (true){
            String str = scanner.nextLine();
            if (str.startsWith("/end")){
                break;
            }
            if (str.startsWith("/addprod")){
                String[] fileList = str.split("##");
               try {
                   cart.addProductToCart(productRepo.getProduct(Integer.parseInt(fileList[1])));
               } catch (Exception e){
                   System.out.println("No such product in ProductRepo");
               }
                cart.showCart();

            }
            if (str.startsWith("/delprod")){
                String[] fileList = str.split("##");
                try {
                    cart.deleteProductFromCart(Integer.parseInt(fileList[1]));
                } catch (Exception e){
                    System.out.println("No such product in Cart");
                }
                cart.showCart();

            }
            if (str.startsWith("/newcart")){
                cart=ctx.getBean(Cart.class);
                System.out.println("New cart has been create");
                cart.showCart();

            }
            if (str.startsWith("/addall")){
                cart.addAll(productRepo.getProductList());
                cart.showCart();
            }
            if (str.startsWith("/clear")){
                cart.clear();
                System.out.println("Cart cleared");

            }
        }

    }
}
