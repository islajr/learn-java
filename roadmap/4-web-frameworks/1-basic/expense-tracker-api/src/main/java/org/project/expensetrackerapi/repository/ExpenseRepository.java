package org.project.expensetrackerapi.repository;

import org.project.expensetrackerapi.model.Category;
import org.project.expensetrackerapi.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Optional<Expense> findByCategory(Category category);
    List<Expense> findByCategoryAndDate(Category category, LocalDate date);
    void deleteByCategory(Category category);
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
}
