package com.aks.attendence;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class SubjectActivity extends Activity
{
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter aa;
    DatabaseReference dr;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        lv = findViewById(R.id.sub_lv);

        al = new ArrayList<String>();
    }

    public void addSubject(View v) {
        startActivityForResult(new Intent(this, AddSubjectActivity.class),121);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 121) {
            if (resultCode == RESULT_OK) {
                name = data.getExtras().getString("sub_name");
                al.add(name);
                aa = new ArrayAdapter(this,R.layout.subject_listview_style,al);
                lv.setAdapter(aa);
            }
        }
    }

    public void saveSubject(View v) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this, android.R.style.Theme_Dialog);
        adb.setMessage("Have you enter all the subject?");
        adb.setCancelable(false);
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SubjectActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SubjectActivity.this,MondayActivity.class));
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
}
