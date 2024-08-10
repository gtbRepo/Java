package org.example;

public record Expense(String type, int month, double value, String description) {
// using record because expenses won't be modified for now
}
