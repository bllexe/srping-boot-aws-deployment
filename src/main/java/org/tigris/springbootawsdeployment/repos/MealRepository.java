package org.tigris.springbootawsdeployment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tigris.springbootawsdeployment.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {

}
