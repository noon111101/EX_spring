package com.example.demo.SQL_Injection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;


@Controller
public class SQL_Injection {
    @RequestMapping( value = {"/"},method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please Enter Your Login Details");
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model,
                         @ModelAttribute("loginBean") LoginBean loginBean) {
        if (loginBean != null && loginBean.getUserName() != null
                & loginBean.getPassword() != null) {
            if (SQLConnect(loginBean.getUserName(),loginBean.getPassword())) {
                model.addAttribute("msg", loginBean.getUserName());
                return "result";
            } else {
                model.addAttribute("error", "Invalid Details");
                return "index";
            }
        } else {
            model.addAttribute("error", "Please enter Details");
            return "index";
        }

    }
    public boolean SQLConnect(String username,String password) {


        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/SQL_Injection";

        //  Database credentials
        final String USER = "root";
        final String PASS = "trieu0925526932";
        boolean status = false;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql;

            //'or '1'='1

            sql = "SELECT Usename, Password FROM login where Usename='" + username + "'and Password='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            status = rs.next();




	      /*    while(rs.next())
	          {
	        	  String x=rs.getString(1);
	        	  String y=rs.getString(2);
	        	  if(x.equals(username)&&y.equals(password))
	        		  status=true;
	          }

	        PreparedStatement ps=conn.prepareStatement(
	        		  "select * from login where Username=? and Password=?");
	        		  ps.setString(1,username);
	        		  ps.setString(2,password);

	        		  rs=ps.executeQuery();
	        		  status=rs.next();

	          */

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (
                SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
   return status;
    }
}