package com.example.SpringRestAPI;

import com.example.SpringRestAPI.config.AppConfig;
import com.example.SpringRestAPI.model.PersonV1;
import com.example.SpringRestAPI.model.PersonV2;
import com.example.SpringRestAPI.service.PersonClientServiceImplV1;
import com.example.SpringRestAPI.service.PersonClientServiceImplV2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;


public class SpringRestApiApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        //API v1
        PersonClientServiceImplV1 clientV1 = applicationContext.getBean(PersonClientServiceImplV1.class);

        PersonV1 newPerson = new PersonV1("Andrew1111", "Kotov", 30L, 182L);
        HttpStatus status = clientV1.addPerson(newPerson);
        System.out.println("Add Person Response = " + status);

        newPerson = clientV1.getById(0L);
        System.out.println("Person with id=0 : " + newPerson);

        clientV1.updatePerson(0L, newPerson);

        newPerson = clientV1.getById(0L);
        System.out.println("Person with id=0 : " + newPerson);

        clientV1.deletePerson(0L);


        //API v2
        PersonClientServiceImplV2 clientV2 = applicationContext.getBean(PersonClientServiceImplV2.class);

        PersonV2 newPersonV2 = new PersonV2("Andrew1111", "Kotov", 30L, 182L, 3L, "Moscov");
        status = clientV2.addPerson(newPersonV2);
        System.out.println("Add Person Response = " + status);

        newPersonV2 = clientV2.getById(0L);
        System.out.println("Person with id=0 : " + newPersonV2);

        clientV2.updatePerson(0L, newPersonV2);

        newPersonV2 = clientV2.getById(0L);
        System.out.println("Person with id=0 : " + newPersonV2);

        clientV2.deletePerson(0L);
        applicationContext.close();
    }

}