package com.springboot.assignment1.assignment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import com.springboot.assignment1.assignment1.Entity.CourseDocument;
import com.springboot.assignment1.assignment1.Entity.SearchRequest;
import com.springboot.assignment1.assignment1.dto.CourseResponseDTO;

@Service
public class CourseService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public Page<CourseResponseDTO> search(SearchRequest request) {

        Criteria criteria = new Criteria();

        // Full-text search
        if (request.getQ() != null && !request.getQ().isEmpty()) {
            criteria = criteria.or(Criteria.where("title").matches(request.getQ()))
                               .or(Criteria.where("description").matches(request.getQ()));
        }

        // Filters
        if (request.getCategory() != null) {
            criteria = criteria.and(Criteria.where("category").is(request.getCategory()));
        }

        if (request.getType() != null) {
            criteria = criteria.and(Criteria.where("type").is(request.getType()));
        }

        if (request.getMinAge() != null) {
            criteria = criteria.and(Criteria.where("minAge").greaterThanEqual(request.getMinAge()));
        }

        if (request.getMaxAge() != null) {
            criteria = criteria.and(Criteria.where("maxAge").lessThanEqual(request.getMaxAge()));
        }

        if (request.getMinPrice() != null) {
            criteria = criteria.and(Criteria.where("price").greaterThanEqual(request.getMinPrice()));
        }

        if (request.getMaxPrice() != null) {
            criteria = criteria.and(Criteria.where("price").lessThanEqual(request.getMaxPrice()));
        }

        if (request.getStartDate() != null) {
            criteria = criteria.and(Criteria.where("nextSessionDate").greaterThanEqual(request.getStartDate()));
        }

        // ✅ Handle price sorting
        Sort sort;
        if ("desc".equalsIgnoreCase(request.getSortDirection())) {
            sort = Sort.by(Sort.Direction.DESC, "price");
        } else {
            sort = Sort.by(Sort.Direction.ASC, "price"); // default
        }

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), sort);
        CriteriaQuery query = new CriteriaQuery(criteria, pageable);

        SearchHits<CourseDocument> searchHits = elasticsearchOperations.search(query, CourseDocument.class);

       List<CourseResponseDTO> courses = searchHits.getSearchHits()
    .stream()
    .map(hit -> {
        CourseDocument doc = hit.getContent();
        return new CourseResponseDTO(
            doc.getId(),
            doc.getTitle(),
            doc.getCategory(),
            doc.getPrice(),
            doc.getNextSessionDate()
        );
    })
    .toList();

return new PageImpl<>(courses, pageable, searchHits.getTotalHits());

    }
}