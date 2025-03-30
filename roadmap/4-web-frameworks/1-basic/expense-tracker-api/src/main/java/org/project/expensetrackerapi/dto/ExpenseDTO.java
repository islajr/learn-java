package org.project.expensetrackerapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;

import java.time.LocalDate;

@Getter
public record ExpenseDTO(

        @NotBlank(message = "You must provide an expense category")
        Category category,
        int cost,

        @NotBlank(message = "Date format: yyyy-mm-dd")
        LocalDate date
) {

    public static ExpenseDTO fromEntity(Expense expense) {

        return new ExpenseDTO(expense.getCategory(), expense.getCost(), expense.getDate());
    }

    public static Expense toEntity(ExpenseDTO expenseDTO) {
        return new Expense(
                expenseDTO.getCategory(),
                expenseDTO.getCost(),
                expenseDTO.getDate());
    }

    private LocalDate getDate() {
        return date;
    }

    private int getCost() {
        return cost;
    }

    private Category getCategory() {
        return category;
    }
}
