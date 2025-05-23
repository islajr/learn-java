package org.project.expensetrackerapi.repository;

import org.project.expensetrackerapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
    List<Expense> findByCategoryAndDate(String category, LocalDate date);
    void deleteByCategory(String category);
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
}
