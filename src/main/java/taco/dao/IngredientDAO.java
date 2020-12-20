package taco.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import taco.pojo.Ingredient;

import java.util.List;

@Mapper
public interface IngredientDAO {

    @Select("select id, name, type from ingredient")
    List<Ingredient> getAll();

    @Select("select id, name, type from ingredient where id = #{id}")
    Ingredient get(String id);

    @Insert("insert into ingredient(id, name, type) values (#{id}, #{name}, #{type})")
    int add(Ingredient ingredient);

}
