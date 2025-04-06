package org.project.expensetrackerapi.model;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private User user;

    @Column(name = "cost")
    private double cost;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "updated_date")
    private LocalDate updatedDate;

    public Expense(Category category, double cost, LocalDate date) {
        this.category = category;
        this.cost = cost;
        this.date = date;
    }
}
