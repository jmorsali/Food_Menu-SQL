package com.session.javadmorsali.food_menu_SQL;

/**
 * Created by jmorsali on 2018-02-04.
 */

class FastFood implements IFoodItem{



    public String Description;
    public String Name;
    public int imageResourceId;


    public FastFood(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final FastFood[] FastFoods = {
            new FastFood("پیتزا پپرونی", "پنیر+ سس + قارچ", R.drawable.cappuccino),
            new FastFood("پیتزا رست بیف", "گوشت گوساله + پنیر پیتزا + قارچ", R.drawable.orange),
            new FastFood("پیتزا مخصوص","پنیر+ سوسیس + کالباس + فلفل", R.drawable.filter),
            new FastFood("پیتزا فیلادلفیا", "تکه مرغ + پنیر + ذرت +فلفل", R.drawable.latte),
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

    @Override
    public boolean getIs_Favorite() {
        return false;
    }

    @Override
    public void setIs_Favorite(boolean value) {

    }



    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
