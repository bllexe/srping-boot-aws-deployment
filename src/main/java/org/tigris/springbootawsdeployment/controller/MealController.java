package org.tigris.springbootawsdeployment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tigris.springbootawsdeployment.modal.MealRequest;
import org.tigris.springbootawsdeployment.modal.MealResponse;
import org.tigris.springbootawsdeployment.service.MealService;

import java.util.List;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor

public class MealController {

    private final MealService mealService;


    @PostMapping("/saveMeal")
    public ResponseEntity<MealResponse> createMeal(@RequestBody MealRequest mealRequest){

        return new ResponseEntity<>(mealService.createMeal(mealRequest), HttpStatus.CREATED);

    }

    @GetMapping("/getAllMeals")
    public ResponseEntity<List<MealResponse>> getAllMeals(){
        return new ResponseEntity<>(mealService.getAllMeals(),HttpStatus.OK);
    }

    @GetMapping("/getMealDetailById/{id}")
    public ResponseEntity<MealResponse> getMealById(@PathVariable Long id){
        return new ResponseEntity<>(mealService.getMealById(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteMealById/{id}")
    public ResponseEntity<HttpStatus> deleteMealById(@PathVariable Long id){
        mealService.deleteMealById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateMeal/{id}")
    public ResponseEntity<MealResponse> updateMealById(@PathVariable Long id, @RequestBody MealRequest mealRequest){

        return new ResponseEntity<>(mealService.updateMeal(id,mealRequest),HttpStatus.CREATED);
    }

}
