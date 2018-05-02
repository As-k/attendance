package com.aks.attendence;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

public class TimeTableActivity extends FragmentActivity
{
    TabLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        tl = findViewById(R.id.tl1);
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int id = tab.getPosition();
                FragmentManager fg = getSupportFragmentManager();
                FragmentTransaction ft =fg.beginTransaction();
                switch (id)
                {
                    case 0:
                    {
                        ft.add(R.id.mon_fg, new MondayFragment(),"MondayFragment");
                        ft.commit();
                        break;
                    }
                    case 1:
                    {
                        ft.add(R.id.mon_fg, new TuesdayFragment(), "TuesdayFragment");
                        ft.commit();
                        break;
                    }
                    case 2:
                    {
                        ft.add(R.id.mon_fg, new WednesdayFragment(),"WednesdayFragment");
                        ft.commit();
                        break;
                    }
                    case 3:
                    {
                        ft.add(R.id.mon_fg, new ThursdayFragment(), "ThursdayFragment");
                        ft.commit();
                        break;
                    }
                    case 4:
                    {
                        ft.add(R.id.mon_fg, new FridayFragment(),"FridayFragment");
                        ft.commit();
                        break;
                    }
                    case 5:
                    {
                        ft.add(R.id.mon_fg, new SaturdayFragment(), "SaturdayFragment");
                        ft.commit();
                        break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
