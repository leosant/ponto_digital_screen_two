package com.pontodigital.screen02.Model;

import com.fasterxml.jackson.databind.JsonNode;
import org.bson.Document;
import org.bson.json.JsonObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.print.Doc;
import java.util.List;
import java.util.Map;

public class DateDay {

    @Id
    private String id;
    @Field("days_timestamp")
    private List<Document> dateTimestamp;
    @Field("date_year_month")
    private String dateMonthYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Document> getDateTimestamp() {
        return dateTimestamp;
    }

    public void setDateTimestamp(List<Document> dateTimestamp) {
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
