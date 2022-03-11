package com.example.final_project.modules;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SiteDAO {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/";
    private Connection con;
    public static SiteDAO instanceData;
    PreparedStatement stmt;

    public SiteDAO(String dbname,String user,String pass) throws SQLException {
        this.connect(dbname,user,pass);
    }

    private void connect(String dbname,String user,String pass) throws SQLException {
        this.con = DriverManager.getConnection(DB_URL + dbname, user, pass);
        instanceData=this;
    }

    public int AddProduct(String title,int Price,int Quantity,String photoUrl,String details,String category) throws SQLException {
            stmt = this.con.prepareStatement("insert into product(title,price,quantity,photo,details,category) values(?,?,?,?,?,?)");
            stmt.setString(1, title);
            stmt.setInt(2, Price);
            stmt.setInt(3, Quantity);
            stmt.setString(4, photoUrl);
            stmt.setString(5, details);
            stmt.setString(6, category);

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs != null) {
                return 1;
            }else {
              return -1;
            }
    }

    public List<Product> getProducts() throws SQLException {
        stmt = this.con.prepareStatement("select * from product");
        ResultSet rs =stmt.executeQuery();
        List<Product> products = new ArrayList<>();

        while (rs.next()) {
            products.add(new Product(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("price"),
                    rs.getInt("quantity"),
                    rs.getString("photo"),
                    rs.getString("details"),
                    rs.getString("category")));
        }

        return products;
    }

    public String checkSignUp(boolean admin,String name,Date birthday,String password,int phonenumber,String job,String email,int creditlimit,String address,String interests){
        try {
//            java.sql.Date currDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            stmt = this.con.prepareStatement("insert into users (admin,name,birthday,password,phonenumber,job,email,creditlimit,address,interests) values(?,?,?,?,?,?,?,?,?,?)");
            stmt.setBoolean(1, admin);
            stmt.setString(2, name);
            stmt.setDate(3, birthday);
            stmt.setString(4, password);
            stmt.setInt(5, phonenumber);
            stmt.setString(6, job);
            stmt.setString(7, email);
            stmt.setInt(8, creditlimit);
            stmt.setString(9, address);
            stmt.setString(10, interests);

            int var5 = stmt.executeUpdate();
            return "SignedUp Successfully";
        } catch (SQLException var6) {
            return "username or email already exists";
        }
    }

    public String checkSignIn(String email, String password,User userObj) {
        try {
            PreparedStatement stmt = con.prepareStatement("select * from users where email = ?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            User user = null;
            if (rs != null) {
                rs.next();
                user = new User(rs.getInt("id"),
                        rs.getBoolean("admin"),
                        rs.getString("name"),
                        rs.getString("birthday"),
                        rs.getString("password"),
                        rs.getInt("phonenumber"),
                        rs.getString("job"),
                        rs.getString("email"),
                        rs.getInt("creditlimit"),
                        rs.getString("address"),
                        rs.getString("interests"),
                        rs.getBoolean("status"));

                System.out.println(email + " " + user.password);
                userObj=user;
            }


            if (user != null && password.equals(user.password) && user.status != true) {
                return "Logged in successfully";
            } else if (user.status == true && password.equals(user.password)) {
                return "you have already signed in from another device";
            } else {
                return "Email or Password is not correct";
            }
        } catch (SQLException ex) {
            return "Email or Password is not correct";

        }
    }

    public void checkout(int userId){

    }
}
