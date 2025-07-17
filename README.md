# Course Search Application with Elasticsearch

This project is a Spring Boot application that integrates with Elasticsearch (8.x) to provide powerful full-text search capabilities, filtering, sorting, and autocomplete support for course data.

---

## ✨ Features

- Full-text search by title and description.
- Filtering by category, type, price range, age range, and start date.
- Sorting by price (low to high or high to low).
- Autocomplete suggestions using prefix matching.
- Elasticsearch integration using `ElasticsearchOperations` (Spring Data Elasticsearch 5+).

---

## ⚡ Technologies Used

- Java 17+
- Spring Boot 3.5+
- Spring Data Elasticsearch 5.5+
- Docker + Docker Compose (for Elasticsearch)

---

## 📁 Project Structure

```
src/
├── main/
    ├── java/com/springboot/assignment1/
    │   ├── controller/         # REST Controller
    │   ├── service/            # Business Logic
    │   ├── Entity/             # CourseDocument & SearchRequest
    │   ├── dto/                # CourseResponseDTO
    │   └── Repository/         # Elasticsearch Repository (optional)
    └── resources/
        ├── application.yml
        └── course-data.json (sample)
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourname/elasticsearch-course-search.git
cd elasticsearch-course-search
```

### 2. Start Elasticsearch via Docker

```bash
docker-compose up -d
```

### 3. Run the Spring Boot Application

```bash
./mvnw spring-boot:run
```

> The app will start at: `http://localhost:8080`

---

## 🧰 API Documentation

### 🔍 `/api/v1/search`

#### Query Parameters:

| Parameter       | Type         | Description                             |
| --------------- | ------------ | --------------------------------------- |
| `q`             | `string`     | Full-text search string                 |
| `category`      | `string`     | Filter by category                      |
| `type`          | `string`     | Filter by course type                   |
| `minAge`        | `int`        | Minimum age filter                      |
| `maxAge`        | `int`        | Maximum age filter                      |
| `minPrice`      | `float`      | Minimum price filter                    |
| `maxPrice`      | `float`      | Maximum price filter                    |
| `startDate`     | `string`     | Filter for courses after date           |
| `sortDirection` | `asc/desc`   | Sort by price (low to high/high to low) |
| `autocomplete`  | `true/false` | Enable autocomplete (prefix match)      |
| `page`          | `int`        | Page number                             |
| `size`          | `int`        | Page size                               |

---

## 🔍 Example API Requests

### 1. Full-text search:

```bash
curl "http://localhost:8080/api/v1/search?q=math"
```

### 2. Filtered by category and price:

```bash
curl "http://localhost:8080/api/v1/search?category=Science&minPrice=100&maxPrice=300"
```

### 3. Sorted by price (high to low):

```bash
curl "http://localhost:8080/api/v1/search?q=science&sortDirection=desc"
```

### 4. Autocomplete search:

```bash
curl "http://localhost:8080/api/v1/search?q=hi&autocomplete=true"
```

#### Response:

```json
{
  "courses": [
    {
      "id": "9",
      "title": "Basic Hindi",
      "category": "Language",
      "price": 70.0,
      "nextSessionDate": "2025-08-12T10:30:00"
    }
  ],
  "total": 1
}


{
    "courses": [
        {
            "id": "5",
            "title": "Fun with Fractions",
            "category": "Math",
            "price": 60.0,
            "nextSessionDate": "2025-07-25T09:00:00"
        },
        {
            "id": "9",
            "title": "Basic Hindi",
            "category": "Language",
            "price": 70.0,
            "nextSessionDate": "2025-08-12T10:30:00"
        },
        {
            "id": "3",
            "title": "Creative Drawing",
            "category": "Art",
            "price": 80.0,
            "nextSessionDate": "2025-09-01T11:00:00"
        },
        {
            "id": "10",
            "title": "Mindful Yoga",
            "category": "Wellness",
            "price": 90.0,
            "nextSessionDate": "2025-07-28T08:00:00"
        },
        {
            "id": "1",
            "title": "Math Magic 101",
            "category": "Math",
            "price": 99.99,
            "nextSessionDate": "2025-08-10T10:00:00"
        },
        {
            "id": "6",
            "title": "Story Writing Club",
            "category": "Language",
            "price": 100.0,
            "nextSessionDate": "2025-08-18T13:00:00"
        },
        {
            "id": "2",
            "title": "Science Explorers",
            "category": "Science",
            "price": 120.0,
            "nextSessionDate": "2025-08-15T14:30:00"
        },
        {
            "id": "8",
            "title": "Astronomy 101",
            "category": "Science",
            "price": 130.0,
            "nextSessionDate": "2025-09-05T18:00:00"
        },
        {
            "id": "4",
            "title": "Little Coders",
            "category": "Technology",
            "price": 150.0,
            "nextSessionDate": "2025-08-20T12:00:00"
        },
        {
            "id": "7",
            "title": "Junior Robotics",
            "category": "Technology",
            "price": 200.0,
            "nextSessionDate": "2025-08-22T15:00:00"
        }
    ],
    "total": 10
}
```

---

## 🔍 Sample Autocomplete Response Image
 Added in Screenshots directory





