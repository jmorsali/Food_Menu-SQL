package com.session.javadmorsali.food_menu_SQL;

/**
 * Created by jmorsali on 2018-02-04.
 */

public enum FoodTypes {
    IranianFood(1),Drink(2), Salad(3), ItalianFood(4), FastFood(5);

    int id;
    private FoodTypes(int id){
        this.id=id;
    }
}
