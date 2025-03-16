package org.lessons.pizzas.java.spring_la_mia_pizzeria_crud.repository;

import org.lessons.pizzas.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pizzaRepository extends JpaRepository<Pizza, Integer> {
    
    
}
