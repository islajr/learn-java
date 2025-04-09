package org.project.expensetrackerapi.dto;
import org.project.expensetrackerapi.model.Expense;

import java.time.LocalDate;


public record ExpenseDTO(

        String category,

        String description,

        double cost,

        LocalDate date
) {

    public ExpenseDTO(double cost) {
        this("", "", cost, null);
    }

    public ExpenseDTO(String description) {
        this("", description, 0, null);
    }

    public ExpenseDTO(LocalDate date) {
        this("", "", 0, date);
    }

    public ExpenseDTO(String category, String description, double cost, LocalDate date) {
        this.category = category;
        this.description = description;
        this.cost = cost;
        this.date = date;
    }

    public static ExpenseDTO fromEntity(Expense expense) {

        return new ExpenseDTO(
                expense.getCategory(),
                expense.getDescription(),
                expense.getCost(),
                expense.getDate());
    }

    public static Expense toEntity(ExpenseDTO expenseDTO) {
        return new Expense(
                expenseDTO.category(),
                expenseDTO.description(),
                expenseDTO.cost(),
                expenseDTO.date());
    }
}
