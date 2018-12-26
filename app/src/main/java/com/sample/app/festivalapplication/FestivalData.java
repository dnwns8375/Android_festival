package com.sample.app.festivalapplication;

import java.io.Serializable;

/**
 * 축제 데이터
 */
public class FestivalData implements Serializable {
    private String poster;
    private String title;
    private String desc;
    private String when;
    private String location;
    private String phone;

    public FestivalData(String poster, String title, String desc, String when, String location, String phone) {
        this.poster = poster;
        this.title = title;
        this.desc = desc;
        this.when = when;
        this.location = location;
        this.phone = phone;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
