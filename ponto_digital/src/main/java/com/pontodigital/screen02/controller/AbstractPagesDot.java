package com.pontodigital.screen02.controller;

import com.github.pontodigital.model.Employer;
import com.pontodigital.screen02.service.PagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.github.leosant.logs.BuildLogger.logger;

public abstract class AbstractPagesDot {

    @Autowired
    PagesService pagesService;

    @GetMapping("-/employer")
    public ResponseEntity<Employer> getEmployer(@RequestHeader("id") String id) {
        if (id == null) {
            logger.error("id is null");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            return ResponseEntity.ok().body(pagesService.getEmployer(id));
        } catch (Exception e) {
            //TODO all possibles errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("-/information")
    public ResponseEntity getInformation(@RequestHeader("id") String id) {
        if (id == null) {
            logger.error("id is null");
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            return ResponseEntity.ok().body(pagesService.getInformation(id));
        } catch (Exception e) {
            //TODO all possibles errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
