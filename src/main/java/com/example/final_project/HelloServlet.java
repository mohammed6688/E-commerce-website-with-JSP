package com.example.final_project;

import java.io.*;

import com.twilio.Twilio;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

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

        Message message = Message.creator(new PhoneNumber("+201126498473"),
                new PhoneNumber("+14433314574"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}