package com.aks.attendence;

/**
 * Created by Ashish on 12/20/2017.
 */

public class UniversityHandler
{
    public String name, university, min_per;

    public UniversityHandler() {
    }

    public UniversityHandler(String name, String university, String min_per) {
        this.name = name;
        this.university = university;
        this.min_per = min_per;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMin_per() {
        return min_per;
    }

    public void setMin_per(String min_per) {
        this.min_per = min_per;
    }
}
