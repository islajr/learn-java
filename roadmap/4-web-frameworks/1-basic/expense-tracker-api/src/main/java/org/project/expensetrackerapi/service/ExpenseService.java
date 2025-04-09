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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
                expense.setUpdatedAt(LocalDateTime.now());

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
        Expense expense = expenseRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Failed to get expense"));

        if (expense != null) {
            if (expense.getUser().getUsername().equals(username)) {
                return ResponseEntity.ok(ExpenseDTO.fromEntity(expense));
            }
            return ResponseEntity.ok(null); // expense does not belong to user
        } else {

            return ResponseEntity.badRequest().body(null);  // no such expense
        }
    }

    public ResponseEntity<ExpenseDTO> updateExpense(Category category, LocalDate date, ExpenseDTO expenseDTO) {
        Expense myExpense = ExpenseDTO.toEntity(expenseDTO);
        List<Expense> storedExpenses = expenseRepository.findByCategoryAndDate(category, date);
        Expense storedExpense = new Expense();

        for (Expense expense : storedExpenses) {
            if (expense.getUser().getUsername().equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
                storedExpense = expense;
            }
        }

        if (myExpense.getDescription() != null && !myExpense.getDescription().equals(storedExpense.getDescription())) {
            storedExpense.setDescription(myExpense.getDescription());
        }
        if (myExpense.getCost() != 0 && myExpense.getCost() != storedExpense.getCost()) {
            storedExpense.setCost(myExpense.getCost());
        }
        if (myExpense.getDate() != null && myExpense.getDate() != storedExpense.getDate()) {
            storedExpense.setDate(expenseDTO.date());
        }

        expenseRepository.save(storedExpense);

        System.out.println("Successfully updated expense!");
        return ResponseEntity.ok(ExpenseDTO.fromEntity(storedExpense));
    }

    public ResponseEntity<String> deleteExpense(Category category) {
        Expense expense = expenseRepository.findByCategory(category).orElseThrow(() -> new RuntimeException("Failed to get expense"));
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        if (expense != null) {

            if (expense.getUser().getUsername().equals(username)) {
                expenseRepository.deleteByCategory(category);
                System.out.println("Successfully deleted expense.");
                return ResponseEntity.ok("Successfully deleted expense.");
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Could not find expense to delete.");
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusWeeks(1);

        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        List<ExpenseDTO> expensesDTO = new ArrayList<>();

        if (expenses != null) {

            for (Expense expense : expenses) {
                if (expense.getUser().getUsername().equals(username)) {
                    expensesDTO.add(ExpenseDTO.fromEntity(expense));
                }
            }

            return ResponseEntity.ok(expensesDTO);

        } else {
            return ResponseEntity.ok(null);
        }

    }

    public ResponseEntity<List<ExpenseDTO>> getExpensePastMonth() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusMonths(1);

        List<Expense> monthlyExpenses = expenseRepository.findByDateBetween(start, end);
        List<ExpenseDTO> expensesDTO = new ArrayList<>();

        if (monthlyExpenses != null) {

            for (Expense expense : monthlyExpenses) {
                if (expense.getUser().getUsername().equals(username)) {
                    expensesDTO.add(ExpenseDTO.fromEntity(expense));
                }
            }

            return ResponseEntity.ok(expensesDTO);

        } else {
            return ResponseEntity.ok(null);
        }
    }

    public ResponseEntity<List<ExpenseDTO>> getExpensePastThreeMonths() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusMonths(3);

        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        List<ExpenseDTO> expensesDTO = new ArrayList<>();

        if (expenses != null) {

            for (Expense expense : expenses) {
                if (expense.getUser().getUsername().equals(username)) {
                    expensesDTO.add(ExpenseDTO.fromEntity(expense));
                }
            }

            return ResponseEntity.ok(expensesDTO);

        } else {
            return ResponseEntity.ok(null);
        }
    }
    public ResponseEntity<List<ExpenseDTO>> getExpenseCustom(LocalDate start, LocalDate end) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<ExpenseDTO> expensesDTO = new ArrayList<>();

        try {
            List<Expense> expenses = expenseRepository.findByDateBetween(start, end);

            if (expenses != null) {
                for (Expense expense : expenses) {
                    if (expense.getUser().getUsername().equals(username)) {
                        expensesDTO.add(ExpenseDTO.fromEntity(expense));
                    }
                }

                return ResponseEntity.ok(expensesDTO);

            } else {
                return ResponseEntity.ok(null);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
