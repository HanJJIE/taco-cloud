package taco.service.impl;

import org.springframework.stereotype.Service;
import taco.dao.IngredientDAO;
import taco.pojo.Ingredient;
import taco.service.IngredientService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Resource
    private IngredientDAO ingredientDAO;

    @Override
    public List<Ingredient> getAll() {
        return ingredientDAO.getAll();
    }

    @Override
    public Ingredient get(String id) {
        return ingredientDAO.get(id);
    }

    @Override
    public int add(Ingredient ingredient) {
        return ingredientDAO.add(ingredient);
    }
}
