package org.project.expensetrackerapi.service;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.repository.ExpenseRepository;
import org.project.expensetrackerapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ResponseEntity<ExpenseDTO> addExpense(ExpenseDTO expenseDTO) {

        if (expenseDTO != null) {

            Expense expense = ExpenseDTO.toEntity(expenseDTO);
            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            if (username != null) {
                expense.setUsername(username);
            } else {
                System.out.println("Please login first!");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }

            try {
                expense.setUpdatedDate(LocalDate.now());
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

        if (expenses.isEmpty()) {
            return ResponseEntity.ok(null);
        } else {
            for (Expense expense : expenses) {
                expensesDTO.add(ExpenseDTO.fromEntity(expense));
            }

            return ResponseEntity.ok(expensesDTO);
        }
    }

    public ResponseEntity<ExpenseDTO> getExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {

            return ResponseEntity.ok(ExpenseDTO.fromEntity(expense));
        } else {

            return ResponseEntity.badRequest().body(null);  // no such expense
        }
    }

    public ResponseEntity<ExpenseDTO> updateExpense(Long id, Expense expense) {
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
            storedExpense.setUpdatedDate(LocalDate.now());  // updated "last updated" field

            System.out.println("Successfully updated expense!");
            return ResponseEntity.ok(ExpenseDTO.fromEntity(storedExpense));
        }
        else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // no expense to update
        }
    }

    public ResponseEntity<String> deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            userRepository.deleteById(id);
            System.out.println("Successfully deleted expense.");
            return ResponseEntity.ok("Successfully deleted expense.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Could not find expense to delete.");
        }
    }
}
