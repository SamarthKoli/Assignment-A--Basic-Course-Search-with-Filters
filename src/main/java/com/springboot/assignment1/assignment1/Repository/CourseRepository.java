package com.springboot.assignment1.assignment1.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.springboot.assignment1.assignment1.Entity.CourseDocument;

@Repository
public interface CourseRepository extends ElasticsearchRepository<CourseDocument,String>{


}