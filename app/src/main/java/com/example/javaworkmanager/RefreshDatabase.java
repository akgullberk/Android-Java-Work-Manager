package com.example.javaworkmanager;


import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class RefreshDatabase  extends Worker {

    Context myContext

    public RefreshDatabase(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.myContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {

        refreshDatabase();
        return Result.success();
    }

    private void refreshDatabase(){
        SharedPreferences sharedPreferences = myContext.getSharedPreferences("com.example.javaworkmanager",Context.MODE_PRIVATE);
        int mySavedNumber = sharedPreferences.getInt("myNumber",0);
        mySavedNumber = mySavedNumber +1;
        System.out.println(mySavedNumber);
        sharedPreferences.edit().putInt("myNumber",mySavedNumber).apply();
    }
}
