package org.project.expensetrackerapi.dto;

import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;


public record ExpenseDTO(

        Category category,

        String description,

        double cost,

        LocalDate date
) {

    public ExpenseDTO(double cost) {
        this(null, "", cost, null);
    }

    public ExpenseDTO(String description) {
        this(null, description, 0, null);
    }

    public ExpenseDTO(LocalDate date) {
        this(null, "", 0, date);
    }

    public ExpenseDTO(Category category, String description, double cost, LocalDate date) {
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
