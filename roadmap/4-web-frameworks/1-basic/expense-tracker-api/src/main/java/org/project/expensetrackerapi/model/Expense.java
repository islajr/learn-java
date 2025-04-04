package org.project.expensetrackerapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "category")
    private Category category;

    @Column(name = "cost")
    private double cost;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    public Expense(Category category, int cost, LocalDate date) {
        this.category = category;
        this.cost = cost;
        this.date = date;
    }
}
