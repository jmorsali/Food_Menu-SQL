package com.session.javadmorsali.food_menu_SQL;

/**
 * Created by jmorsali on 2018-02-04.
 */

public class Drink implements IFoodItem {
    String Description;
    String Name;
    int imageResourceId;
    boolean Is_Favorite;

    public Drink(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final Drink[] Drinks = {
            new Drink("قهوه ترک", "یک فنجان قهوه اصیل ترک به همراه شیر و شکر", R.drawable.cappuccino),
            new Drink("آب پرتقال", "آب پرتقال طبیعی شمال", R.drawable.orange),
            new Drink("میلک شیک", "شکلات طبیعی سوئیسی به همراه شیر", R.drawable.filter),
            new Drink("قهوه فرانسوی", "قهوه اصیل فرانسه بدون شکر و شیر", R.drawable.latte),
    };

    @Override
    public String toString() {
        return getName() + " :: " + getDescription() + " :: ";
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

    @Override
    public boolean getIs_Favorite() {
        return Is_Favorite;
    }

    @Override
    public void setIs_Favorite(boolean value ) {
        Is_Favorite=value;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

}
