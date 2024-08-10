package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    List<Expense> expenses = new ArrayList<>();

    public void displayAllExpenses() {
        expenses.forEach(ExpenseManager::displayExpense);
    }

    private static void displayExpense(Expense expense) {
        System.out.println(expense.description());
        System.out.println(expense.type());
        System.out.println(expense.value());
        System.out.println(expense.month());
    }

    public void displayMonthlyExpenses(Scanner scanner) {
        System.out.println("Expenses from which month do you want to show?");
        int month = Integer.parseInt(scanner.nextLine());
        
        expenses.stream()
                .filter(expense -> expense.month() == month)
                .forEach(ExpenseManager::displayExpense);
    }

    public void addExpense(Scanner scanner) {
        System.out.println("What expense do you want to add?");
        String description = scanner.nextLine();
        System.out.println("What kind of type is this expense?");
        String type = scanner.nextLine();
        System.out.println("How much that's cost?");
        double value = Double.parseDouble(scanner.nextLine());
        System.out.println("From which month is this expense?");
        int month = Integer.parseInt(scanner.nextLine());

        Expense expense = new Expense(type, month, value, description);
        expenses.add(expense);
    }
}
