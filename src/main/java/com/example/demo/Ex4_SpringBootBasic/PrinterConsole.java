package com.example.demo.Ex4_SpringBootBasic;



public class PrinterConsole implements Printer {
private  Customer customer;
public  PrinterConsole(Customer customer){
    this.customer=customer;
}
    @Override
    public void printCustoner() {
        System.out.println("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
