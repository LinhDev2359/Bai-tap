package org.aibles.managerdailyplan.repository;

import org.aibles.managerdailyplan.entity.DailyPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyPlanRepository extends JpaRepository<DailyPlan, String> {

}
