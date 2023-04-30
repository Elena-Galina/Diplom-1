package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;

    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue("Элемент не добавлен в список ingredients", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        burger.removeIngredient(burger.ingredients.indexOf(ingredient));
        assertFalse("Элемент не удален из списка ingredients", burger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        int newIndex = 1;

        burger.moveIngredient(burger.ingredients.indexOf(ingredient), newIndex);
        assertThat("Элемент не перемёщен внутри списка ingredients", burger.ingredients.indexOf(ingredient), equalTo(newIndex));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(DataGenerator.randomPrice());
        Mockito.when(ingredient.getPrice()).thenReturn(DataGenerator.randomPrice());

        float expectedPrice = bun.getPrice() * 2 + ingredient.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Ожидаемая цена burger не равна полученной", expectedPrice, actualPrice, 0.0);
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(DataGenerator.randomName());
        Mockito.when(bun.getPrice()).thenReturn(DataGenerator.randomPrice());
        Mockito.when(ingredient.getType()).thenReturn(DataGenerator.randomType());
        Mockito.when(ingredient.getName()).thenReturn(DataGenerator.randomName());

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expectedReceipt = receipt.toString();
        String actualReceipt = burger.getReceipt();
        assertThat("Чек с информацией о бургере выводится неверно", actualReceipt, equalTo(expectedReceipt));
    }
}