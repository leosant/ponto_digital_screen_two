package com.pontodigital.screen02.controller;

import com.pontodigital.screen02.Model.DateDay;
import com.pontodigital.screen02.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class PagesDot {

    @Autowired
    DateRepository dateRepository;

    @GetMapping
    public ResponseEntity<List<DateDay>> getTest() {
        List<DateDay> dates = dateRepository.findAll();
        System.out.println(dates);
        return ResponseEntity.ok().body(dates);
    }
}
