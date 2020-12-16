package taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taco.pojo.Ingredient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import taco.pojo.Ingredient.Type;
import taco.utils.ResultBean;

@Slf4j
@RestController
@RequestMapping("/design")
public class DesignTacoController {

    @PostMapping("/processDesign")
    public ResultBean<Object> processDesign(@RequestBody Map<String, String> design) {
        log.info("process design: {}", design);
        return new ResultBean<>();
    }

    /**
     * 显示自定义表单
     */
    @GetMapping("/showDesignForm")
    public ResultBean<Map<String, List<Ingredient>>> showDesignForm() {

        Map<String, List<Ingredient>> result = new HashMap<>();

        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla",  Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla",  Type.WRAP),
                new Ingredient("GRBF", "Ground Beef",  Type.PROTEIN),
                new Ingredient("CARN", "Carnitas",  Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes",  Type.VEGGIES),
                new Ingredient("LETC", "Lettuce",  Type.VEGGIES),
                new Ingredient("CHED", "Cheddar",  Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack",  Type.CHEESE),
                new Ingredient("SLSA", "Salsa",  Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream",  Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            result.put(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        return new ResultBean<>(result);
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

}
