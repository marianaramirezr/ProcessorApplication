package com.exampleProcessorApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.exampleProcessorApplication.Person;


@Component
public class ValidationClient {
    private RestTemplate restTemplate;
    private final String VALIDATION_SERVICE_URL = "http://localhost:8081/validate";
    public boolean validatePerson(Person person) {

        Boolean isValid = restTemplate.postForObject(VALIDATION_SERVICE_URL, person, Boolean.class);
        return isValid != null && isValid;
    }
}

