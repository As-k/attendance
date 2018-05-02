package com.aks.attendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class WelcomeActivity extends Activity
{
    EditText et1, et2, et3;
    public static String university;
    public static String id;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        et1 = findViewById(R.id.name);
        et2 = findViewById(R.id.university);
        et3 = findViewById(R.id.minimum_percentage);

        sessionManager = new SessionManager(this);

    }

    public void saveDetails(View v)
    {
        String name = et1.getText().toString().trim();
        university = et2.getText().toString().trim();
        String percentage = et3.getText().toString().trim();

        if (name.isEmpty())
        {
            et1.setError("Empty");
            et1.requestFocus();
        }
        else
        {
            if (university.isEmpty())
            {
                et2.setError("Empty");
                et2.requestFocus();
            }
            else
            {
                if (percentage.isEmpty())
                {
                    et3.setError("Empty");
                    et3.requestFocus();
                }
                else
                {
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
                    id = dr.push().getKey();
                    Log.e("=============>",id);
                    UniversityHandler uh = new UniversityHandler(name, university, percentage);
                    dr.child(String.valueOf(id)).setValue(uh);
                    sessionManager.setUserId(id);
                    startActivity(new Intent(this, MainActivity.class));
                    finish();

                }
            }
        }
    }

}
