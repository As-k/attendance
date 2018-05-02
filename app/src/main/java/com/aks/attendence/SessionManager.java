package com.aks.attendence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ashish on 1/20/2018.
 */

public class SessionManager {
    Context context;

    SharedPreferences sp;
    SharedPreferences.Editor spe;
    private String USERID = "userID";
    private String SEMID = "semesterID";
    private String STATUS = "status";

    public SessionManager(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("registered_status", context.MODE_PRIVATE);
        spe = sp.edit();
    }

    public String getUserId() {
        return sp.getString(USERID, "");
    }

    public void setUserId(String userId) {
        spe.putString(USERID, userId);
        spe.commit();
    }

    public String getSemesterId() {
        return sp.getString(SEMID, "");
    }

    public void setSemesterId(String semesterId) {
        spe.putString(SEMID, semesterId);
        spe.commit();
    }

    public boolean getStatus() {
        return sp.getBoolean(STATUS, false);
    }

    public void setSTATUS(boolean status) {
        spe.putBoolean(STATUS, status);
        spe.commit();
    }

    public void clear(){
        String userId = getUserId();
        spe.clear();
        spe.commit();
        setUserId(userId);
    }
}
