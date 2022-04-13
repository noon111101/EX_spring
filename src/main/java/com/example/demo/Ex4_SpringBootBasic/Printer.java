package com.example.demo.Ex4_SpringBootBasic;

import org.springframework.context.annotation.Bean;

public interface Printer {
    void printCustoner();

    void printMessage(String message);
}
