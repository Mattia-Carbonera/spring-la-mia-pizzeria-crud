package org.lessons.pizzas.java.spring_la_mia_pizzeria_crud.controllers;

import java.util.List;

import org.lessons.pizzas.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.lessons.pizzas.java.spring_la_mia_pizzeria_crud.repository.pizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class pizzasController {

    @Autowired
    public pizzaRepository repository;

    // homePage
    @GetMapping("/")
    public String homePage() {
        return new String("index");
    }
    
    
    // index
    @GetMapping("/menu")
    public String index(Model model) {
        List<Pizza> pizzas = repository.findAll();
        model.addAttribute("pizzas", pizzas);
        model.addAttribute("modal", false);

        return new String("menuPage");
    }

    // show
    @GetMapping("/menu/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Pizza selectedPizza = repository.findById(id).get();
        model.addAttribute("pizza", selectedPizza);

        return new String("pizzaShow");
    }

    // search
    @GetMapping("/menu/search")
    public String searchPizza(@RequestParam("name") String name, Model model) {
        List<Pizza> searchedPizza = repository.findByNameContainingIgnoreCase(name);
        model.addAttribute("pizzas", searchedPizza);

        return new String("menuPage");
    }
    
    
    
}
