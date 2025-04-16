package org.project.expensetrackerapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.exception.exceptions.ArgumentOverflowException;
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

    @PostMapping()
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<ExpenseDTO>> getExpenses(@RequestParam(required = false, defaultValue = "") String filter,
                                                        @RequestParam(required = false, defaultValue = "") String category) {

        if (!filter.isEmpty() && !category.isEmpty()) { // if both fields are supplied
            throw new ArgumentOverflowException("Please provide only one argument");    // define custom exception later.
        }
        return expenseService.getExpenses(filter, category);
    }

    @GetMapping("/custom")
    public ResponseEntity<List<ExpenseDTO>> getExpenseCustom(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return expenseService.getExpenseCustom(start, end);
    }

    @PutMapping()
    public ResponseEntity<ExpenseDTO> updateExpense(@RequestParam String category, @RequestParam LocalDate date, @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.updateExpense(category, date, expenseDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteExpense(@RequestParam String category) {
        return expenseService.deleteExpense(category);
    }
}
