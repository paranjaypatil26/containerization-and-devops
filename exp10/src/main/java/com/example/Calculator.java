package com.example;

public class Calculator {

    // BUG: Division by zero is not handled
    public int divide(int a, int b) {
        return a / b;
    }

    // CODE SMELL: unused variable
    public int add(int a, int b) {
        int unused = 10;
        return a + b;
    }

    // VULNERABILITY: SQL injection example
    public String getUser(String userId) {
        String query = "SELECT * FROM users WHERE id = " + userId;
        return query;
    }

    // CODE SMELL: duplicated logic
    public int multiply(int a, int b) {
        int result = 0;
        for(int i = 0; i < b; i++) {
            result += a;
        }
        return result;
    }

    public int multiplyAgain(int a, int b) {
        int result = 0;
        for(int i = 0; i < b; i++) {
            result += a;
        }
        return result;
    }

    // BUG: Null pointer risk
    public int getLength(String str) {
        return str.length();
    }
}
