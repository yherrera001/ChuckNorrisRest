package com.FirstJawnByMyself.anotherdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Joke {
    private String id;
    private String url;
    private String value;

    public Joke() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
