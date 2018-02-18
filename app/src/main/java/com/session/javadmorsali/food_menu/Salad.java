package com.session.javadmorsali.food_menu;

/**
 * Created by jmorsali on 2018-02-04.
 */

class Salad implements IFoodItem{

    public String Description;
    public String Name;
    public int imageResourceId;


    public Salad(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final Salad[] Salads = {
            new Salad("سالاد شیرازی", "سالاد ایرانی اصیل", R.drawable.p4),
            new Salad("سالاد کلم", "کلم + کشمش", R.drawable.p5),
            new Salad("سالاد فصل","کاهو + گوجه + خیار", R.drawable.p6),
            new Salad("ماست موسیر", "ماست موسیر تازه", -1),
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
