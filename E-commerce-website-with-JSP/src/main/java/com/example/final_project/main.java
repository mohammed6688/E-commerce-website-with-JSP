package com.example.final_project;

import com.example.final_project.modules.Cart;
import com.example.final_project.modules.SiteDAO;
import com.example.final_project.modules.SiteParser;
import com.example.final_project.modules.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws JsonProcessingException{
        new SiteParser();
//        SiteParser.instanceData.addToCart(new Cart(20,6,1));
//        SiteParser.instanceData.deleteFromCart(20,6);

//        User user=new User(6,false,"","","",112602446,"","",400,"","");
//
//        String value= null;
//        value = SiteParser.instanceData.checkout(user);
//        System.out.println(value);
//        if (value.equals("success")){
//            System.out.println("run successfully");
//        }

//        SiteParser.instanceData.editProduct(100,20,20);

//        User user=SiteParser.instanceData.checkSignIn("mohammed668800.ma@gmail.com","1502654");
//        System.out.println(user.getName());
    }
}
