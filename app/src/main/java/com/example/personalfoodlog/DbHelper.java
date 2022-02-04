package com.example.personalfoodlog;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DBname="PFLog.db";
    public static final String USER_TABLE = "User";
    public static final String userId = "userId";
    public static final String MEAL_TABLE="Meal";
    public static final String mealId = "mealId";

    static DbHelper dbHelper;

    public static DbHelper getInstance(Context context) {
      if (dbHelper ==null )
        dbHelper = new DbHelper(context.getApplicationContext());
        return dbHelper;
    }

    private DbHelper( Context context) {
        super(context,"Login.db",null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table " + USER_TABLE +" ( " + userId + " Integer primary key AUTOINCREMENT, user_name TEXT, email TEXT, password TEXT , First_name TEXT, Last_name TEXT, Height Integer, Weight Integer , Gender TEXT) ");//building table name users
        db.execSQL("create Table " + MEAL_TABLE +" ( " + mealId + " Integer primary key AUTOINCREMENT, meal TEXT,weight INTEGER,calorie INTEGER,usr_id INTEGER,FOREIGN KEY ( usr_id ) REFERENCES USER_TABLE ("+userId+" ) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");  //remove table if already exists

    }
    public boolean updatedata(int userId, String Firstname , String Lastname, int height, int weight ,String gender)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("UPDATE " + USER_TABLE + " SET First_name = \"" + Firstname + "\" , Last_name = \"" + Lastname + "\" , Height = " + height + ", Weight = " + weight + " , Gender = \""  + gender + "\" WHERE " + this.userId + " == " + userId);
        return true;
    }

    public boolean insertcalorie(int userId,int calorie,int weight,String meal)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("meal",meal);
        contentValues.put("calorie",calorie);
        contentValues.put("weight",weight);
        contentValues.put("usr_id",userId);
        long result=sqLiteDatabase.insert(MEAL_TABLE,null,contentValues);
        if(result==-1)return false;
        else
            return true;

    }

    @SuppressLint("Range")
    public MealModel fetchdata(String meal)
    {
        MealModel mealModel =null;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+ MEAL_TABLE +" where meal=?",new String[]{meal});
        if(cursor.moveToFirst()) {
            mealModel = new MealModel(cursor.getString(cursor.getColumnIndex("meal")),
                    cursor.getInt(cursor.getColumnIndex("weight")),
                    cursor.getInt(cursor.getColumnIndex("calorie")),
                    cursor.getInt(cursor.getColumnIndex(mealId)));
        }
        return mealModel;
    }

    public boolean insertData(String email, String user_name , String password) // insert data in DB
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("user_name", user_name);
        contentValues.put("password", password);
       contentValues.put("email",email);
        /* contentValues.put("Firstname", fname);
        contentValues.put("lastname", lname);
        contentValues.put("height", height);
        contentValues.put("weight", weight);
        contentValues.put("gender", gender);*/

        long result=db.insert(USER_TABLE,null,contentValues);
        if(result==-1)return false;
        else
            return true;

    }

    public int checkuser(String user_name)    //to check if the user already exists
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select "+userId+" from "+ USER_TABLE +" where user_name=?",new String[]{user_name});
        if(cursor.moveToFirst())
            return cursor.getColumnIndex("userId");
        return -1;
    }

    public boolean checkusernamepassword(String user_name, String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select "+userId+" from "+ USER_TABLE +" where user_name=? and  password=?",new String[]{user_name,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }



}
