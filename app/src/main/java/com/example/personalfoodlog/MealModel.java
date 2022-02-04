package com.example.personalfoodlog;

public class MealModel {
    String meal;
    int weight;
    int calorie;
    int mealId;

    public MealModel(String meal, int weight,int calorie,int mealId)
    {
        this.meal = meal;
        this.weight = weight;
        this.calorie = calorie;
        this.mealId = mealId;
    }

    public String getMeal(){
        return meal;
    }
    public int getWeight(){
        return weight;
    }
    public int getCalorie(){
        return calorie;
    }
    public int getMealId(){
        return mealId;
    }
}
