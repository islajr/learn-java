package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.model.User;
import org.project.expensetrackerapi.repository.ExpenseRepository;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ResponseEntity<ExpenseDTO> addExpense(ExpenseDTO expenseDTO) {

        if (expenseDTO != null) {
            if (!isCategoryValid(expenseDTO.category())) {
                return ResponseEntity.badRequest().body(null);
            }

            Expense expense = ExpenseDTO.toEntity(expenseDTO);
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            if (username != null) {
                User user = userRepository.findByUsername(username).orElseThrow(() ->  new UsernameNotFoundException("There is no such user!"));

                expense.setUser(user);

            } else {
                System.out.println("You cannot create this expense. Please login first!");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }

            try {
                expenseRepository.save(expense);
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(expenseDTO);

            } catch (Exception e) {
                System.out.println("Failed to add expense");
                return ResponseEntity.internalServerError().body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);    // expense is null
        }
    }

    public ResponseEntity<List<ExpenseDTO>> getExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseDTO> expensesDTO = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (expenses.isEmpty()) {
            return ResponseEntity.ok(null);
        } else {
            for (Expense expense : expenses) {
                if (expense.getUser().getUsername().equals(username)) { // if expense belongs to user
                    expensesDTO.add(ExpenseDTO.fromEntity(expense));
                }
            }

            return ResponseEntity.ok(expensesDTO);
        }
    }

    public ResponseEntity<ExpenseDTO> getExpenseByCategory(Category category) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // Expense expense = expenseRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Failed to get expense"));
        Expense expense = expenseRepository.findByUsernameAndCategory(username, category);

        if (expense != null) {

            return ResponseEntity.ok(ExpenseDTO.fromEntity(expense));
        } else {

            return ResponseEntity.badRequest().body(null);  // no such expense
        }
    }

    public ResponseEntity<ExpenseDTO> updateExpense(Category category, Expense expense) {
        Expense storedExpense = expenseRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {

            if (!isCategoryValid(expense.getCategory())) {
                return ResponseEntity.badRequest().body(null);
            }

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
            return ResponseEntity.ok(ExpenseDTO.fromEntity(storedExpense));
        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // no expense to update
        }
    }

    public ResponseEntity<String> deleteExpense(Category category) {
        Expense expense = expenseRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            expenseRepository.deleteByCategory(category);
            System.out.println("Successfully deleted expense.");
            return ResponseEntity.ok("Successfully deleted expense.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find expense to delete.");
        }
    }

    private boolean isCategoryValid(Category category) {
        for (Category category1 : Category.values()) {
            if (category.equals(category1)) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity<List<ExpenseDTO>> getExpensePastWeek() {
    }

    public ResponseEntity<List<ExpenseDTO>> getExpensePastMonth() {
    }

    public ResponseEntity<List<ExpenseDTO>> getExpenseCustom() {
    }

    public ResponseEntity<List<ExpenseDTO>> getExpensePastThreeMonths() {
    }
}
