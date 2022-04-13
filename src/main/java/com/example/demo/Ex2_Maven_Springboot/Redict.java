package com.example.demo.Ex2_Maven_Springboot;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Redict {
    Scanner sc = new Scanner(System.in);
    String prefix =  null ;
    String name;
    public Redict(String name) throws InterruptedException {
        this.name = name;
        service();
    }
    public void service() throws InterruptedException {
        menu();
        int redictnum = sc.nextInt();
        sc.nextLine();
        switch (redictnum){
            case 1:
                System.out.println("Nhập chuỗi phụ");
                prefix = sc.nextLine();
                System.out.println(StringUtils.containsAny(name, prefix));
                Thread.sleep(2000);
                service();
                break;
            case 2:
                System.out.println("Nhập chuỗi phụ");
                prefix = sc.nextLine();
                System.out.println(StringUtils.containsIgnoreCase(name, prefix));
                Thread.sleep(2000);
                service();
                break;
            case 3:
                System.out.println("Nhập chuỗi phụ");
                prefix = sc.nextLine();
                System.out.println(StringUtils.countMatches(name, prefix));
                Thread.sleep(2000);
                service();
                break;
            case 4:
                System.out.println("Nhập chuỗi phụ");
                prefix = sc.nextLine();
                System.out.println(StringUtils.appendIfMissing(name, prefix));
                Thread.sleep(2000);
                service();
                break;
            case 5:
                System.out.println("Nhập chuỗi phụ");
                prefix = sc.nextLine();
                System.out.println(StringUtils.prependIfMissing(name, prefix));
                Thread.sleep(2000);
                service();
                break;
            case 6:
                System.out.println(StringUtils.upperCase(name));
                Thread.sleep(2000);
                service();
                break;
            case 7:
                System.out.println(StringUtils.lowerCase(name));
                Thread.sleep(2000);
                service();
                break;
            case 8:
                service();
                break;
            case 0:
                return;


        }
        return;
    }
    public void menu(){
        System.out.println("Hello" + name +"\n" +
                "Nhập lựa chọn\n" +
                "1.Thực thi hàm containsAny \n" +
                "2.Thực thi hàm containsIgnoreCase	\n" +
                "3.Thực thi hàm countMatches \n" +
                "4.Thực thi hàm appendIfMissing \n" +
                "5.Thực thi hàm prependIfMissing \n" +
                "6.Thực thi hàm uppercase\n" +
                "7.Thực thi hàm lowercase\n"+
                "8.Nhập lại tên\n"+
                "0.Thoát ");
    }
}
