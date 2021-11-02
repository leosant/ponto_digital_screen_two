package com.pontodigital.screen02.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (
        value = "data_year_month"
)
public class DateInte {

    @Id
    private String id;
    private DateDay dateDay;
    private Employer employer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DateDay getDateDay() {
        return dateDay;
    }

    public void setDateDay(DateDay dateDay) {
        this.dateDay = dateDay;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
