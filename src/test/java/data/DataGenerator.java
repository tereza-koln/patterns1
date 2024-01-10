package data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{ "Калининград", "Калуга", "Краснодар", "Киров", "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан",
                "Москва", "Мурманск", "Нижний Новгород", "Новосибирск", "Омск", "Ростов-на-Дону", "Рязань", "Самара", "Южно-Сахалинск", "Екатеренбург", "Тамбов", "Тверь",
                "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль", "Севастополь", "Анапа"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}