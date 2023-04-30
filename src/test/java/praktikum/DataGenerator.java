package praktikum;

import net.datafaker.Faker;

public class DataGenerator {

    public static String randomName() {
        Faker faker = new Faker();
        return faker.food().ingredient();
    }

    public static float randomPrice() {
        Faker faker = new Faker();
        return (float) faker.number().randomDouble(2, 0, 300);
    }

    public static IngredientType randomType() {
        Faker faker = new Faker();
        return IngredientType.values()[faker.number().numberBetween(0, 2)];
    }
}
