package com.session.javadmorsali.food_menu;

/**
 * Created by jmorsali on 2018-02-04.
 */

public class Drink implements IFoodItem{
    public String Description;
    public String Name;
    public int imageResourceId;


    public Drink(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] Drinks = {
            new Drink("قهوه ترک", "یک فنجان قهوه اصیل ترک به همراه شیر و شکر", R.drawable.cappuccino),
            new Drink("آب پرتقال", "آب پرتقال طبیعی شمال", R.drawable.orange),
            new Drink("میلک شیک","شکلات طبیعی سوئیسی به همراه شیر", R.drawable.filter),
            new Drink("قهوه فرانسوی", "قهوه اصیل فرانسه بدون شکر و شیر", R.drawable.latte),
    };

    @Override
    public String toString() {
        return getName() + " :: "+getDescription() + " :: ";
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

}