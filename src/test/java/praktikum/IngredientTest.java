package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getDataIngredients() {
        return new Object[][]{
                {IngredientType.FILLING, DataGenerator.randomName(), DataGenerator.randomPrice()},
                {IngredientType.SAUCE, DataGenerator.randomName(), DataGenerator.randomPrice()}
        };
    }

    @Test
    public void testGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertThat("Метод возвращает неверный price ингредиента", actualPrice, equalTo(price));
    }

    @Test
    public void testGetIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertThat("Метод возвращает неверный name ингредиента", actualName, equalTo(name));
    }

    @Test
    public void testGetIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertThat("Метод возвращает неверный type ингредиента", actualType, equalTo(type));
    }
}