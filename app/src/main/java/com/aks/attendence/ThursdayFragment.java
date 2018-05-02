package com.aks.attendence;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThursdayFragment extends Fragment
{
    ListView lv;
    ArrayList al;
    DatabaseReference dr;
    String from[] = {"time", "sub"};
    int to[] = {R.id.tv1, R.id.tv2};

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    public ThursdayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_thursday, container, false);
        lv = v.findViewById(R.id.lv_thur);
        al = new ArrayList();

        dr = FirebaseDatabase.getInstance().getReference().child(WelcomeActivity.id).child(WelcomeActivity.university).child(SemesterDetailsActivity.s).child(ThursdayActivity.Day);
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    String id = ds.getKey();
                    MondayHandler mh = ds.getValue(MondayHandler.class);
                    String name = mh.getName();
                    HashMap hm = new HashMap();
                    hm.put(from[0],id);
                    hm.put(from[1],name);
                    al.add(hm);
                }
                SimpleAdapter sl = new SimpleAdapter(getContext(),al,R.layout.timetable_listview_style,from,to);
                lv.setAdapter(sl);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return v;
    }

}
