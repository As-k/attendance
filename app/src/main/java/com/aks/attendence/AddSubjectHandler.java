package com.aks.attendence;

/**
 * Created by Ashish on 12/21/2017.
 */

public class AddSubjectHandler {
    public String credit, no_of_cls;

    public AddSubjectHandler() {
    }

    public AddSubjectHandler(String credit, String no_of_cls) {
        this.credit = credit;
        this.no_of_cls = no_of_cls;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getNo_of_cls() {
        return no_of_cls;
    }

    public void setNo_of_cls(String no_of_cls) {
        this.no_of_cls = no_of_cls;
    }
}
