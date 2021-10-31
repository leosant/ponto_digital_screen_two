package com.pontodigital.screen02.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (
        value = "date_day"
)
public class DateDay {

    @Id
    private String id;
    @Field("days_timestamp")
    private Object dateTimestamp;
    @Field("date_year_month")
    private String dateMonthYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(Object dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    public String getDateMonthYear() {
        return dateMonthYear;
    }

    public void setDateMonthYear(String dateMonthYear) {
        this.dateMonthYear = dateMonthYear;
    }

    @Override
    public String toString() {
        return "DateDay{" +
                "id='" + id + '\'' +
                ", dateTimestamp=" + dateTimestamp +
                ", dateMonthYear='" + dateMonthYear + '\'' +
                '}';
    }
}
