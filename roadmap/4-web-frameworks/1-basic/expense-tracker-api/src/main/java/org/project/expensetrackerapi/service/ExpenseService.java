package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.repository.ExpenseRepository;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ResponseEntity<Expense> addExpense(Expense expense) {

        if (expense != null) {
            try {
                expenseRepository.save(expense);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(expense);

            } catch (Exception e) {
                System.out.println("Failed to add expense");
                throw new RuntimeException("Failed to add expense.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//            throw new RuntimeException("Expense is null.");
        }
    }

    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    public ResponseEntity<Expense> getExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            return ResponseEntity.ok(expense);
        } else {
//            throw new NoSuchElementException("No such expense!");
            return ResponseEntity.badRequest().body(null);
        }
    }

    public ResponseEntity<Expense> updateExpense(Long id, Expense expense) {
        Expense storedExpense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

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

            System.out.println("Successfully updated expense!");
            return ResponseEntity.ok(storedExpense);
        }
        else {
//            throw new NoSuchElementException("Could not find expense to update.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    public ResponseEntity<String> deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            userRepository.deleteById(id);
            System.out.println("Successfully deleted expense.");
            return ResponseEntity.ok("Successfully deleted expense.");
        } else {
//            throw new NoSuchElementException("Could not find expense to delete.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find expense to delete.");
        }
    }
}
