package com.pontodigital.screen02.service;

import com.github.pontodigital.model.DateDay;
import com.github.pontodigital.model.Employer;
import com.github.pontodigital.model.ManageDate;
import com.pontodigital.screen02.repository.MongoRepositories;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.github.leosant.logs.BuildLogger.logger;

@Service
public class PagesService {

    @Autowired
    MongoRepositories db;

    public String getInformation(String id) {
        logger.info("[getInformation] starting...");
        ManageDate manageDate = getManagerDay(id, "employerRef");
        Employer employer = getEmployer(id);

        List<DateDay> dateDay = new ArrayList<>();
        manageDate.getMonthRef().forEach( ref -> {
            DateDay day = getDay(ref.getRef());
            dateDay.add(day == null ? new DateDay(): day);
            day = null;
        });

        JSONObject empJson = new JSONObject(employer);
        JSONObject answer = new JSONObject();

        answer.put("employer", empJson);
        answer.put("date", dateDay);

        return answer.toString();
    }

    public ManageDate getManagerDay(String id, String typeRef) {
        logger.info(" [getManagerDay] finding managerDay");
        Criteria criteriaEmp = Criteria
                .where(typeRef).is(id);

        ManageDate manageDate = db.dateMongo.findOne(new Query(criteriaEmp), ManageDate.class);
        if (manageDate == null) {
            logger.error(" [getManagerDay] manageDate not exists or occurred in error to find");
            throw new IllegalArgumentException("manageDate is null");
        }
        return manageDate;
    }

    public DateDay getDay(String id) {
        logger.info(" [getDay] finding employer");
        return db.dateMongo.findById(id, DateDay.class);
    }

    public Employer getEmployer(String id) {
        logger.info(" [getEmployer] finding employer");
        Employer employer = db.dateMongo.findById(id, Employer.class);
        if (employer == null) {
            logger.error(" [getEmployer] employer not exists or occurred in error to find");
            throw new IllegalArgumentException("employer not exists");
        }
        return employer;
    }
}
