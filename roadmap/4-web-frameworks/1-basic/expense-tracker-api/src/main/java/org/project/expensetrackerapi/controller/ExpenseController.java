package org.project.expensetrackerapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.model.Category;
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
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }

    @GetMapping("/get/{category}")
    public ResponseEntity<ExpenseDTO> getExpense(@PathVariable Category category) {
        return expenseService.getExpense(category);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ExpenseDTO>> getExpenses() {
        return expenseService.getExpenses();
    }

    @PutMapping("/update/{category}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Category category, @RequestBody Expense expense) {
        return expenseService.updateExpense(category, expense);
    }

    @DeleteMapping("/del/{category}")
    public ResponseEntity<String> deleteExpense(@PathVariable Category category) {
        return expenseService.deleteExpense(category);
    }
}
