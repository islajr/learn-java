package org.project.expensetrackerapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.project.expensetrackerapi.dto.ExpenseDTO;
import org.project.expensetrackerapi.model.Category;
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

    @PostMapping("/create")
    public ResponseEntity<ExpenseDTO> addExpense(@Valid @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }

    @GetMapping("/get/{category}")
    public ResponseEntity<List<ExpenseDTO>> getExpenseByCategory(@PathVariable String category) {
        return expenseService.getExpenseByCategory(category);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseDTO>> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/get/pw")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastWeek() {
        return expenseService.getExpensePastWeek();
    }

    @GetMapping("get/pm")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastMonth() {
        return expenseService.getExpensePastMonth();
    }

    @GetMapping("get/p3m")
    public ResponseEntity<List<ExpenseDTO>> getExpensePastThreeMonths() {
        return expenseService.getExpensePastThreeMonths();
    }

    @GetMapping("/get/custom")
    public ResponseEntity<List<ExpenseDTO>> getExpenseCustom(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return expenseService.getExpenseCustom(start, end);
    }

    @PutMapping("/update")
    public ResponseEntity<ExpenseDTO> updateExpense(@RequestParam String category, @RequestParam LocalDate date, @RequestBody ExpenseDTO expenseDTO) {
        return expenseService.updateExpense(category, date, expenseDTO);
    }

    @DeleteMapping("/delete/{category}")
    public ResponseEntity<String> deleteExpense(@PathVariable String category) {
        return expenseService.deleteExpense(category);
    }
}
