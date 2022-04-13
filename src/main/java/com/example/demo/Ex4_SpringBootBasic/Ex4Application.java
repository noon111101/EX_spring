package com.example.demo.Ex4_SpringBootBasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class Ex4Application  {

    public static void main(String[] args) {
        SpringApplication.run(Ex4Application.class, args);
        BigDecimal moneyDraw ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập thông tin tài khoản :\n"+
                " số tài khoản:" );
        String acctNo = sc.nextLine();
        System.out.println(" mã pin:");
        String pin = sc.nextLine();
        System.out.println(" số tiền khởi tạo:");
        BigDecimal balance = sc.nextBigDecimal();
        Customer customer = new Customer(acctNo,pin,balance);
        Printer printerConsole = new PrinterConsole(customer);
        Atm bidvAtm = new BidvAtm(printerConsole);
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        System.out.println("Nhập số tiền cần rút");
        moneyDraw = sc.nextBigDecimal();
        bidvAtm.withDraw(customer, moneyDraw);
        bidvAtm.printCurrentMoney();
    }
};
