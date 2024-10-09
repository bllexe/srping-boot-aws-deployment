package org.tigris.springbootawsdeployment.modal;


import org.tigris.springbootawsdeployment.entity.Meal;

import java.time.LocalDate;

public record MealResponse(Long id, String title, String content, String author, LocalDate create_at, LocalDate update_at) {



    public static MealResponse fromEntity(Meal meal){

        return new MealResponse(meal.getId(),meal.getTitle(),meal.getContent(),meal.getAuthor(),meal.getCreatedDate(),meal.getUpdatedDate());
    }

    public  Meal toEntity(MealResponse mealResponse){
        Meal meal=new Meal();
        meal.setId(mealResponse.id);
        meal.setTitle(mealResponse.title);
        meal.setContent(mealResponse.content);
        meal.setAuthor(mealResponse.author);
        meal.setCreatedDate(mealResponse.create_at);
        meal.setUpdatedDate(mealResponse.update_at);
        return meal;
    }
}
