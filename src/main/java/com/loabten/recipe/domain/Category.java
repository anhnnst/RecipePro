package com.loabten.recipe.domain;

import javax.persistence.*;
import java.util.Set;
import lombok.*;

@EqualsAndHashCode(exclude = {"recipes"})
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany
    private Set<Recipe> recipes;

}
