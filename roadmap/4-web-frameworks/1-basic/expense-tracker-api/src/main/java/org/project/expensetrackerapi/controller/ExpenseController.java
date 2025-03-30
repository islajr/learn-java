package org.project.expensetrackerapi.controller;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/expense/")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Expense>> getExpenses() {
        return expenseService.getExpenses();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        return expenseService.deleteExpense(id);
    }
}
