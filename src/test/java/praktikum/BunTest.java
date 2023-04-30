package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;

    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: name=\"{0}\", price={1}")
    public static Object[][] getBun() {
        return new Object[][]{
                {"", -100.50f},
                {null, 0},
                {"1234567890", 0.05f},
                {"Яя", 100.00f},
                {"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz", Float.MAX_VALUE},
                {"!@#$%^&*/:'=+-?<> _|();\"~`.,", 100},
        };
    }

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