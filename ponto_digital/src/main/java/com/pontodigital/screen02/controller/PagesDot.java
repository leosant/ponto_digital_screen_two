package com.pontodigital.screen02.controller;

import com.pontodigital.screen02.Model.DateDay;
import com.pontodigital.screen02.repository.MongoRepositories;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.github.leosant.logs.BuildLogger.logger;

@RestController("/")
public class PagesDot {

    @Autowired
    MongoRepositories mongoRepositories;

    @GetMapping
    public ResponseEntity<List<DateDay>> getTest() {
        try {
            logger.info("initial application");
            List<Document> dates = mongoRepositories.dateMongo.findAll(Document.class, "date_year_month");

            Document dateDays = (Document) dates.get(0).get("month_ref");
            Query query2 = new Query(Criteria
                    .where("_id").is(dateDays.getString("january")));
            System.out.println("month_ref: "+dateDays);
            List<DateDay> day = mongoRepositories.dateMongo.find(query2, DateDay.class, "date_day");
            System.out.println("dateDay: "+day);

            Query query = new Query(Criteria
                    .where("_id").is(new ObjectId( dates.get(0).getString("employer_ref"))));
            List<Document> emp = mongoRepositories.dateMongo.find(query, Document.class, "employer");

            System.out.println("employe: "+emp);
            System.out.println("dates intermediary: "+dates);
            return ResponseEntity.ok().body(day);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }
}
