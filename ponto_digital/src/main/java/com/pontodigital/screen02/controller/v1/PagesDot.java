package com.pontodigital.screen02.controller.v1;

import com.pontodigital.screen02.controller.AbstractPagesDot;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "search/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PagesDot extends AbstractPagesDot { }
