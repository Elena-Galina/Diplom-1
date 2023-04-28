package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    String expectedName = DataGenerator.randomName();
    float expectedPrice = DataGenerator.randomPrice();

    @Test
    public void testGetBunName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        String actualName = bun.getName();
        assertEquals("Метод getName возвращает неверное значение", expectedName, actualName);
    }

    @Test
    public void testGetBunPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Метод getPrice возвращает неверное значение", expectedPrice, actualPrice, 0.0);
    }
}