package com.session.javadmorsali.food_menu;

/**
 * Created by jmorsali on 2018-02-04.
 */

class ItalianFood implements IFoodItem{


    public String Description;
    public String Name;
    public int imageResourceId;


    public ItalianFood(String name, String Description, int imageResourceId) {
        this.Name = name;
        this.Description = Description;
        this.imageResourceId = imageResourceId;
    }

    public static final ItalianFood[] ItalianFoods = {
            new ItalianFood("پاستا", "پاستا با سس چیلی", R.drawable.p7),
            new ItalianFood("اسپاگتی", "اسپاگتی ایتالیایی", R.drawable.p8),
            new ItalianFood("نودل","نودل تازه", R.drawable.p7),
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
