package org.project.expensetrackerapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "category")
    private Category category;

    @Column(name = "description")
    private String description;

    /*@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;*/

    @Column(name = "cost")
    private double cost;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Expense(Category category, String description, double cost, LocalDate date) {
        this.category = category;
        this.description = description;
        this.cost = cost;
        this.date = date;
    }
}
