package com.aks.attendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends Activity
{
    ProgressBar pb;
    private Handler hd = new Handler();
    SessionManager sessionManager;
    boolean res;
    String userId, semId;

    String STATUS = "status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager =  new SessionManager(this);

        pb = findViewById(R.id.dairy_pb);

        res = sessionManager.getStatus();
        userId = sessionManager.getUserId();
        semId = sessionManager.getSemesterId();

        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!userId.equals("")) {
                    if (!semId.equals("")) {
                        if (res) {
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                        } else {
                            startActivity(new Intent(MainActivity.this, SubjectActivity.class));
                        }
                    }else {
                        startActivity(new Intent(MainActivity.this, SemesterDetailsActivity.class));
                    }
                } else {
                    startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
                }
                finish();
            }
        },3000);
    }


    public boolean isRes() {
        return res;
    }
}
