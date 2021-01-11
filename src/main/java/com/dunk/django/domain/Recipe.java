package com.dunk.django.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
@Entity
public class Recipe {
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(255) default ''")
    private String description;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    List<CookingMethod> cookingMethods = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private FoodNation foodNation; //한중일양식

    @ManyToOne(fetch = FetchType.LAZY)
    private FoodType foodType;  //국, 반찬, 찌개...

    @Column(columnDefinition = "integer default 0")
    private Integer cookingTime;

    @Column(columnDefinition = "integer default 0")
    private int calorie;

    @Column(columnDefinition = "integer default 0")
    private int servings;

    @Column(columnDefinition = "varchar(255) default ''")
    private String thumbnail;

    @Builder
    public Recipe(String name, String description, List<Ingredient> ingredients, List<CookingMethod> cookingMethods, FoodNation foodNation, FoodType foodType, int cookingTime, int calorie, int servings, String thumbnail) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.cookingMethods = cookingMethods;
        this.foodNation = foodNation;
        this.foodType = foodType;
        this.cookingTime = cookingTime;
        this.calorie = calorie;
        this.servings = servings;
        this.thumbnail = thumbnail;
    }
}
