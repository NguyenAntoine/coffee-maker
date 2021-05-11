package com.antoine.coffeemaker.usecase;

import com.antoine.coffeemaker.model.Drink;
import com.antoine.coffeemaker.model.Message;
import org.springframework.stereotype.Component;

@Component
public class DrinkMakerOrder {
    public String order(String command) {
        String[] informations = command.split(":", -1);
        String result = "";
        if (informations.length > 0) {
            if (this.isMessage(informations[0])) {
                result = this.getMessage(informations[1]);
            } else {
                result = this.messageOrder(this.drinkOrder(informations[0]), this.sugarNumber(informations[1]), this.isStickOrdered(informations[2]));
            }
        }

        return result;
    }

    public String getMessage(String message) {
        return message;
    }

    public String messageOrder(Drink drink, Integer sugar, Boolean stick) {
        return "Drink maker makes 1 " + drink.toString() + this.sugarOrder(sugar) + this.stickOrder(stick);
    }

    public Drink drinkOrder(String drink) {
        switch (drink) {
            case "T":
                return Drink.TEA;
            case "C":
            default:
                return Drink.COFFEE;
            case "H":
                return Drink.CHOCOLATE;
        }
    }

    public Boolean isMessage(String message) {
        return message.equals("M");
    }

    public String sugarOrder(Integer sugarNumber) {
        String result = " with ";
        if (sugarNumber == 0) {
            result += "no";
        } else {
            result += sugarNumber;
        }
        result += " sugar";

        if (sugarNumber > 1) {
            result += "s";
        }
        return result;
    }

    public Integer sugarNumber(String sugar) {
        if (sugar.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(sugar);
    }

    public String stickOrder(Boolean isStickOrdered) {
        String result = " and ";
        if (!isStickOrdered) {
            result += "therefore no ";
        } else {
            result += "a ";
        }
        result += "stick";
        return result;
    }

    public Boolean isStickOrdered(String stick) {
        return !stick.isEmpty() && stick.equals("0");
    }
}
