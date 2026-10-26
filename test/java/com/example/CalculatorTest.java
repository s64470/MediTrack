package com.example;

public class Calculator {
  
  public double add(double a, double b) {
    return a + b;
  }
  
  public double divide(double a, double b) {
    if (b == 0) {
      throw new ArithmeticException("Division durch Null nicht erlaubt");
    }
    
    return a / b;
  }
}
