# 🎬 Movie Rating Info

A Spring Boot-based RESTful API for managing and retrieving movie ratings.

## 🚀 Features

- Get all movie ratings
- Fetch ratings by movie ID
- List top-rated and worst-rated movies
- Filter movies by rating range
- Add new movie ratings
- Global exception handling
- Spring Boot Actuator endpoints for monitoring

## 📦 Tech Stack

- Java 
- Spring Boot 3.x
- Spring Web
- Spring Actuator
- Gradle

## 📂 API Endpoints

### GET `/ratings/all`
> Get all movie ratings

### GET `/ratings/{movieId}`
> Get rating by movie ID

### GET `/ratings/topRated`
> Get top-rated movies

### GET `/ratings/lowRated`
> Get low-rated movies

### GET `/ratings/range?min={min}&max={max}`
> Get movies within a rating range

### POST `/ratings/add`
> Add a new movie rating  
**Request Body:**
```json
{
  "movieId": 1,
  "movieName": "Inception",
  "rating": 4.5
}
