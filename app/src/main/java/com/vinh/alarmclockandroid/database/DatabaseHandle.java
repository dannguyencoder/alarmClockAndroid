package com.vinh.alarmclockandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 9/5/2017.
 */

public class DatabaseHandle {
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context)
    {
        myDatabase = new MyDatabase(context);
    }

    private static DatabaseHandle databaseHandle;
    public static DatabaseHandle getInstance(Context context)
    {
        if (databaseHandle == null)
        {
            databaseHandle = new DatabaseHandle(context);
        }

        return databaseHandle;
    }

    private SQLiteDatabase sqLiteDatabase;

    public List<QuizModel> getListQuiz()
    {
        List<QuizModel> quizModelList = new ArrayList<>();

        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tb_quiz", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast())
        {
            // get data
            int id = cursor.getInt(0);
            String question = cursor.getString(1);
            String answera = cursor.getString(2);
            String answerb = cursor.getString(3);
            String answerc = cursor.getString(4);
            String answerd = cursor.getString(5);
            int realanswer = cursor.getInt(6);
            int level = cursor.getInt(7);
            int job = cursor.getInt(8);


            QuizModel quizModel = new QuizModel(id, question, answera, answerb, answerc, answerd, realanswer, level, job);
            quizModelList.add(quizModel);

            //next cursor
            cursor.moveToNext();
        }
        Log.d(TAG, "getListQuiz: " + quizModelList.toString());

        return quizModelList;
    }

    public void setBookmark(QuizModel storyModel, boolean bookmark)
    {
        sqLiteDatabase = myDatabase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (bookmark)
        {
            contentValues.put("bookmark", 1);
        }
        else
        {
            contentValues.put("bookmark", 0);
        }
        sqLiteDatabase.update("tbl_short_story", contentValues, "id = ?", new String[]{String.valueOf(storyModel.getId())});
    }
}
