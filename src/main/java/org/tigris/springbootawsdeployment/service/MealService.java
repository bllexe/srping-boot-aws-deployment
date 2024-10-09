package org.tigris.springbootawsdeployment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.tigris.springbootawsdeployment.entity.Meal;
import org.tigris.springbootawsdeployment.modal.MealRequest;
import org.tigris.springbootawsdeployment.modal.MealResponse;
import org.tigris.springbootawsdeployment.repos.MealRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MealService {

    private final MealRepository mealRepository;


    public MealResponse createMeal(MealRequest mealRequest) {

        Meal meal=new Meal();
        meal.setId(mealRequest.id());
        meal.setTitle(mealRequest.title());
        meal.setContent(mealRequest.title());
        meal.setAuthor(mealRequest.author());
        meal.setCreatedDate(LocalDate.now());
        meal.setUpdatedDate(LocalDate.now());

        Meal savedMeal = mealRepository.save(meal);
        return MealResponse.fromEntity(savedMeal);
    }

    public MealResponse getMealById(Long id) {

        Meal mealInDb = mealRepository.findById(id).orElseThrow();
        return  MealResponse.fromEntity(mealInDb);
    }

    public List<MealResponse> getAllMeals(){
        return mealRepository.findAll().stream().map(MealResponse::fromEntity).toList();
    }

    public void  deleteMealById(Long id){
        mealRepository.deleteById(id);
    }

    public MealResponse updateMeal(Long id,MealRequest mealRequest){
        Meal mealInDb = mealRepository.findById(id).orElseThrow();
        mealInDb.setTitle(mealRequest.title());
        mealInDb.setContent(mealRequest.content());
        mealInDb.setAuthor(mealRequest.author());
        mealInDb.setUpdatedDate(LocalDate.now());
        mealRepository.save(mealInDb);

        return MealResponse.fromEntity(mealInDb);
    }
}
