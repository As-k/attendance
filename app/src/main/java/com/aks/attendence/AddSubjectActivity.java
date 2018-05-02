package com.aks.attendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSubjectActivity extends Activity {
    EditText et1, et2, et3;
    public static String sub_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        et1 = findViewById(R.id.sub_name);
        et2 = findViewById(R.id.sub_credit);
        et3 = findViewById(R.id.sub_no_cls);
    }
    public void submitSub(View v) {
        sub_name = et1.getText().toString().trim();
        String sub_credit = et2.getText().toString().trim();
        String sub_no_cls = et3.getText().toString().trim();
        if (sub_name.isEmpty()) {
            et1.setError("Empty");
            et1.requestFocus();
        } else {
            if (sub_credit.isEmpty()) {
                et2.setError("Empty");
                et2.requestFocus();
            } else {
                if (sub_no_cls.isEmpty()) {
                    et3.setError("Empty");
                    et3.requestFocus();
                } else {
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child("Subjects").child(sub_name);
                    AddSubjectHandler ash = new AddSubjectHandler(sub_credit, sub_no_cls);
                    dr.setValue(ash);
                    Intent i = new Intent();
                    i.putExtra("sub_name",sub_name);
                    setResult(RESULT_OK,i);
                    finish();
                    Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
