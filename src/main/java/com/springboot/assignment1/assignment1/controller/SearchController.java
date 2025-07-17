package com.springboot.assignment1.assignment1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.assignment1.assignment1.Entity.SearchRequest;
import com.springboot.assignment1.assignment1.dto.CourseResponseDTO;
import com.springboot.assignment1.assignment1.service.CourseService;


@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private CourseService courseService;


    @GetMapping
    public Map<String,Object>search(@ModelAttribute SearchRequest request){
       org.springframework.data.domain.Page<CourseResponseDTO>result=courseService.search(request);
        
       Map<String,Object>response=new HashMap<>();
       response.put("total", result.getTotalElements());
       response.put("courses", result.getContent());

       return response;
    }


}