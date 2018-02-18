package com.session.javadmorsali.food_menu;

/**
 * Created by jmorsali on 2018-02-04.
 */

class IranianFood implements IFoodItem {

    public String Description;
    public String Name;
    public int imageResourceId;


    public IranianFood(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final IranianFood[] IranianFood = {
            new IranianFood("چلو کباب گوسفندی", "گوشت گوسفند + برنج", R.drawable.p1),
            new IranianFood("جوجه کباب", "ران مرغ", R.drawable.p2),
            new IranianFood("قرمه سبزی","سبزی تازه + گوشت گوسفندی", R.drawable.p3),
            new IranianFood("قیمه", "گوشت گوسفندی + سیب زمینی تازه", -1),
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
