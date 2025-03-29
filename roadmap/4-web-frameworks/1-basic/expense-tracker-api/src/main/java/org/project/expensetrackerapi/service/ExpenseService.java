package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.repository.ExpenseRepository;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public String addExpense(Expense expense) {

        if (expense != null) {
            try {
                expenseRepository.save(expense);
                return "Successfully added expense.";
            } catch (Exception e) {
                System.out.println("Failed to add expense");
                throw new RuntimeException("Failed to add expense.");
            }
        } else {
            throw new RuntimeException("Expense is null.");
        }
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            return expense;
        } else {
            throw new NoSuchElementException("No such expense!");
        }
    }

    public String updateExpense(Long id, Expense expense) {
        Expense storedExpense = getExpense(id);

        if (expense != null) {
            if (expense.getCategory() != null && !expense.getCategory().equals(storedExpense.getCategory())) {
                storedExpense.setCategory(expense.getCategory());
            }
            if (expense.getCost() != storedExpense.getCost()) {
                storedExpense.setCost(expense.getCost());
            }
            if (expense.getDate() != null && expense.getDate() != storedExpense.getDate()) {
                storedExpense.setDate(expense.getDate());
            }

            return "Successfully updated expense!";
        }
        else {
            throw new NoSuchElementException("Could not find expense to update.");
        }
    }

    public String deleteExpense(Long id) {
        Expense expense = getExpense(id);

        if (expense != null) {
            userRepository.deleteById(id);
            return "Successfully deleted expense.";
        } else {
            throw new NoSuchElementException("Could not find expense to delete.");
        }
    }
}
