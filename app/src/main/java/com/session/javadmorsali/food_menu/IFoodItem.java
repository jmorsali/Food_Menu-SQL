package com.session.javadmorsali.food_menu;

/**
 * Created by jmorsali on 2018-02-10.
 */

interface IFoodItem {

    String getName();

    String getDescription();

    int getImageResourceId();

    boolean getIs_Favorite();

    void setIs_Favorite(boolean value);
}
