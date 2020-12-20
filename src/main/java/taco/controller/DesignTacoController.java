package taco.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
import taco.service.IngredientService;
import taco.utils.ResultBean;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/design")
public class DesignTacoController {

    @Resource
    private IngredientService ingredientService;

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

        List<Ingredient> ingredients = ingredientService.getAll();

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
