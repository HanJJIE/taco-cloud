package taco.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import taco.pojo.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAll();

    Ingredient get(String id);

    int add(Ingredient ingredient);

}
