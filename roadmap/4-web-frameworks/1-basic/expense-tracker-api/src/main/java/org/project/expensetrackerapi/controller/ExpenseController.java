package org.project.expensetrackerapi.controller;

import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.model.Expense;
import org.project.expensetrackerapi.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/expense/")
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/add")
    public String addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @GetMapping("/get/{id}")
    public Expense getExpense(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @GetMapping("/get")
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @PutMapping("/update/{id}")
    public String updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/del/{id}")
    public String deleteExpense(@PathVariable Long id) {
        return expenseService.deleteExpense(id);
    }
}
