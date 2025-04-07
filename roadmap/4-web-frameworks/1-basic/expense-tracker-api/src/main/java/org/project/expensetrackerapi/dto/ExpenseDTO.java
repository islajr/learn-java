package org.project.expensetrackerapi.dto;

import jakarta.validation.constraints.NotBlank;
import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;

import java.time.LocalDate;


public record ExpenseDTO(

        @NotBlank(message = "Required: Provide an expense category")
        Category category,

        @NotBlank(message = "Required: Provide a description")
        String description,

        @NotBlank(message = "Required: Provide a cost value")
        double cost,

        @NotBlank(message = "Required: Date format: yyyy-mm-dd")
        LocalDate date
) {

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
