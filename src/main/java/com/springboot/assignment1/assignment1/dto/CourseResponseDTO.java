package com.springboot.assignment1.assignment1.dto;

import java.time.LocalDateTime;

public class CourseResponseDTO {
    private String id;
    private String title;
    private String category;
    private Double price;
    private LocalDateTime nextSessionDate;


    public CourseResponseDTO(String id, String title, String category, Double price, LocalDateTime nextSessionDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.nextSessionDate = nextSessionDate;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getNextSessionDate() {
        return nextSessionDate;
    }
}
