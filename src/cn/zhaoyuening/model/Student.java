package cn.zhaoyuening.model;

import java.util.List;

/**
 * Created by buynow on 16-10-13.
 */
public class Student {
    private List<String> schools;
    private String name;

    public List<String> getSchools() {
        return schools;
    }

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
