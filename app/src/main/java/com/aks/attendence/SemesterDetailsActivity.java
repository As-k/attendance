package com.aks.attendence;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SemesterDetailsActivity extends Activity
{
    EditText semester, semester_date;
    public static String s;
    DatePickerDialog startDate;
    String id1, uni;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_details);
        sessionManager = new SessionManager(this);

        semester = findViewById(R.id.semester);
        semester_date = findViewById(R.id.semester_date);

        semester_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                startDate = new DatePickerDialog(SemesterDetailsActivity.this, android.R.style.Theme_DeviceDefault_Dialog,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        semester_date.setText(dayOfMonth+"/"+(month + 1)+"/"+year);
                    }
                }, mYear, mMonth, mDay);
                DatePicker dp = startDate.getDatePicker();
                dp.setMaxDate(System.currentTimeMillis());
                startDate.show();
            }
        });
    }

    public void saveSemester(View v) {
        String sem = semester.getText().toString().trim();
        String sem_date = semester_date.getText().toString().trim();
        if (id1 == null) {
            if (sem.isEmpty()) {
                semester.setError("Empty");
                semester.requestFocus();
            } else {
                if (sem_date.isEmpty()) {
                    semester_date.setError("Empty");
                    semester_date.requestFocus();
                } else {
                    int smts = Integer.parseInt(sem);
                    if (smts > 0 && smts <= 10) {
                        s = String.valueOf(smts);
                        DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(s);
                        SemesterHandler sh = new SemesterHandler(sem_date);
                        dr.setValue(sh);
                        sessionManager.setSemesterId(s);
                        finish();
                        startActivity(new Intent(this, SubjectActivity.class));
                    } else {
                        semester.setError("Invalid Semester");
                        semester.requestFocus();
                    }
                }
            }
        }
        else {
            if (sem.isEmpty()) {
            semester.setError("Empty");
            semester.requestFocus();
            } else {
            if (sem_date.isEmpty()) {
                semester_date.setError("Empty");
                semester_date.requestFocus();
            } else {
                int smts = Integer.parseInt(sem);
                if (smts > 0 && smts <= 10) {
                    s = String.valueOf(smts);
                    DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child(id1).child(uni).child(s);
                    SemesterHandler sh = new SemesterHandler(sem_date);
                    dr.setValue(sh);
                    finish();
                    startActivity(new Intent(this, SubjectActivity.class));
                } else {
                    semester.setError("Invalid Semester");
                    semester.requestFocus();
                }
            }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 121)
        {
            if (requestCode == RESULT_OK)
            {
                Bundle b = data.getExtras();
                id1 = b.getString("id");
                uni = b.getString("university");
            }
        }

    }
}
