package org.project.expensetrackerapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/expense/")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/")
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }

    @GetMapping("/{category}")
    public ResponseEntity<ExpenseDTO> getExpenseByCategory(@PathVariable Category category) {
        return expenseService.getExpenseByCategory(category);
    }

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/pw")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastWeek() {
        return expenseService.getExpensePastWeek();
    }

    @GetMapping("/pm")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastMonth() {
        return expenseService.getExpensePastMonth();
    }

    @GetMapping("/p3m")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastThreeMonths() {
        return expenseService.getExpensePastThreeMonths();
    }

    @GetMapping("/")
    public ResponseEntity<List<ExpenseDTO>> getExpenseCustom(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return expenseService.getExpenseCustom();
    }

    @PutMapping("/{category}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Category category, @RequestBody Expense expense) {
        return expenseService.updateExpense(category, expense);
    }

    @DeleteMapping("/{category}")
    public ResponseEntity<String> deleteExpense(@PathVariable Category category) {
        return expenseService.deleteExpense(category);
    }
}
