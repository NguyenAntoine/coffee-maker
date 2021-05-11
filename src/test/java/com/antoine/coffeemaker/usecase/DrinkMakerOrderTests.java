package com.antoine.coffeemaker.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DrinkMakerOrderTests {
    @Autowired
    private DrinkMakerOrder drinkMakerOrder;

    @Test
    void drinkOrderTeaWith1SugarAndAStick() {
        Assertions.assertEquals("Drink maker makes 1 tea with 1 sugar and a stick", drinkMakerOrder.order("T:1:0"));
    }

    @Test
    void drinkOrderCoffeeWith0SugarAndAStick() {
        Assertions.assertEquals("Drink maker makes 1 coffee with no sugar and a stick", drinkMakerOrder.order("C:0:0"));
    }

    @Test
    void drinkOrderChocolateWith2SugarsAndNoStick() {
        Assertions.assertEquals("Drink maker makes 1 chocolate with 2 sugars and therefore no stick", drinkMakerOrder.order("H:2:"));
    }

    @Test
    void drinkOrderTeaWithEmptySugarAndNoStick() {
        Assertions.assertEquals("Drink maker makes 1 tea with no sugar and therefore no stick", drinkMakerOrder.order("T::"));
    }

    @Test
    void drinkOrderTeaWithEmptySugarAndAStick() {
        Assertions.assertEquals("Drink maker makes 1 tea with no sugar and a stick", drinkMakerOrder.order("T::0"));
    }

    @Test
    void drinkOrderMessageCustom() {
        Assertions.assertEquals("I can make coffees", drinkMakerOrder.order("M:I can make coffees"));
    }

    @Test
    void drinkOrderMessageCustomWithAStick() {
        Assertions.assertEquals("I can make coffees", drinkMakerOrder.order("M:I can make coffees:0"));
    }
}
