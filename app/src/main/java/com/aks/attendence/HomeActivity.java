package com.aks.attendence;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends Activity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sessionManager = new SessionManager(this);
    }

    public void homePage(View v)
    {
        Toast.makeText(this, "Home Page", Toast.LENGTH_SHORT).show();
    }

    public void addBunk(View v) {
        startActivity(new Intent(this, AddBunkActivity.class));
        finish();
    }

    public void viewBunk(View v) {
        startActivity(new Intent(this, ViewBunkActivity.class));
        finish();
    }

    public void alertsAttendance(View v) {
        startActivity(new Intent(this, AlertsAttendanceActivity.class));
        finish();
    }

    public void hallOfFame(View v) {
        startActivity(new Intent(this, HallOfFameActivity.class));
        finish();
    }

    public void resetApp(View v) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this, android.R.style.Theme_Dialog);
        adb.setIcon(R.drawable.attendance);
        adb.setTitle("Attendance Tracker");
        adb.setMessage("Are you sure?");
        adb.setCancelable(false);
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s);
                sessionManager.clear();
                Intent i = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.create().show();
    }

    public void timeTable(View v)
    {
        startActivity(new Intent(this, TimeTableActivity.class));
    }
}
