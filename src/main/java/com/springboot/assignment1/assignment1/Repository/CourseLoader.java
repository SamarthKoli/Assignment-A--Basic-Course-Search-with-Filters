package com.springboot.assignment1.assignment1.Repository;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.DeserializationFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.assignment1.assignment1.Entity.CourseDocument;
@Component
public class CourseLoader implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // <-- Required
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


        InputStream is = new ClassPathResource("sample-courses.json").getInputStream();
        List<CourseDocument> courses = Arrays.asList(mapper.readValue(is, CourseDocument[].class));

        courseRepository.saveAll(courses);
    }
}