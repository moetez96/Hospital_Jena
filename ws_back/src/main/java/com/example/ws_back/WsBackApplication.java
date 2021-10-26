package com.example.ws_back;

import com.example.ws_back.service.JenaEngine;
import org.apache.jena.rdf.model.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsBackApplication.class, args);


    }

}
