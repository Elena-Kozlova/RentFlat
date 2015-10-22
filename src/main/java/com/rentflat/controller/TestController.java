package com.rentflat.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public String test() {
        return "Success";
    }
}
