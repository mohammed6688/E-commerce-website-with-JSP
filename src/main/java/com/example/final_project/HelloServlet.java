package com.example.final_project;

import java.io.*;

import com.example.final_project.modules.Product;
import com.example.final_project.modules.SiteDAO;
import com.example.final_project.modules.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Say;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URI;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public static final String ACCOUNT_SID = "ACceb4ceec732d6b9e1719d2906fc117ae";
    public static final String AUTH_TOKEN = "60a80e1c593fb93ba0b3e28bed0dd294";

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

//        Message message = Message.creator(new PhoneNumber("+201126498473"),
//                new PhoneNumber("+14433314574"),
//                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

//        Call message = Call.creator(new PhoneNumber("+201020516469"),
//                new PhoneNumber("+14433314574"),
//                new com.twilio.type.Twiml("<Response><Say loop=\"3\">your code is 5 4 3 2</Say></Response>")).create();
//
//        System.out.println(message.getSid());
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        User user=new User(2,false,"","","",0112602446,"","",400,"","",false);

        String value= null;
        try {
            value = SiteDAO.instanceData.checkout(user,SiteDAO.instanceData.getProducts(),SiteDAO.instanceData.getCart());
            System.out.println(value);
            if (value.equals("success")){
                System.out.println("run successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        List<Product> products=new ArrayList<>();
//        try {
//            products =SiteDAO.instanceData.getProducts();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void destroy() {
    }
}