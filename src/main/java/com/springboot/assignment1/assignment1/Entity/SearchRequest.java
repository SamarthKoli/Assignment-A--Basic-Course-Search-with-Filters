package com.springboot.assignment1.assignment1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private String q;
    private Integer minAge, maxAge;
    private String category, type;
    private Double minPrice, maxPrice;
    private String startDate;
    private String sort;
    private int page = 0;
    private int size = 10;
    private String sortDirection = "asc";
    private boolean autocomplete;
    private boolean fuzzy;

}

