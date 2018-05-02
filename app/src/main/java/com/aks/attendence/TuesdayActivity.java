package com.aks.attendence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TuesdayActivity extends Activity
{
    Spinner sp[] = new Spinner[10];
    int spin[] = {R.id.mon_spin1,R.id.mon_spin2,R.id.mon_spin3,R.id.mon_spin4,R.id.mon_spin5,R.id.mon_spin6,R.id.mon_spin7,R.id.mon_spin8,R.id.mon_spin9,R.id.mon_spin10};
    ArrayAdapter aa;
    ArrayList<String> al;
    DatabaseReference dr;
    public static final String Day = "Tuesday";
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);

        for (int i=0; i<sp.length; i++) {
            sp[i] = findViewById(spin[i]);
        }

        al = new ArrayList<String>();
        String sel = "Select Subject";
        al.add(sel);

        dr = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child("Subjects");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    String sub = ds.getKey();
                    al.add(sub);
                }
                for (int i=0; i<sp.length; i++) {
                    aa = new ArrayAdapter(TuesdayActivity.this, R.layout.subject_spinner_style, al);
                    sp[i].setAdapter(aa);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        spinnerClick();
    }

    public void spinnerClick()
    {
        sp[0].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("10:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr1.setValue(mh);
                }
                else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("10:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[1].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr2 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("11:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr2.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("11:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[2].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("12:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr1.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("12:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[3].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr2 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("01:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr2.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("01:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[4].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("02:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr1.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("02:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[5].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr2 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("03:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr2.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("03:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[6].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("04:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr1.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("04:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[7].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr2 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("05:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr2.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("05:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[8].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("06:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr1.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("06:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        sp[9].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int p, long l) {
                if (p!=0)
                {
                    String name = (String)al.get(p);
                    DatabaseReference dr2 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day).child("07:00");
                    MondayHandler mh = new MondayHandler(name);
                    dr2.setValue(mh);
                }else
                {
                    DatabaseReference dr1 = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(Day);
                    dr1.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dataSnapshot.getRef().child("07:00").removeValue();
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void nextTue(View v)
    {
        startActivity(new Intent(this, WednesdayActivity.class));
    }

}
