
```markdown
# Spring Boot Book Search Application

This project is a simple **Spring Boot application** that demonstrates how to implement a book search functionality using **MongoDB** as the database and a custom **binary search logic** in the service layer.

---

## Features

- **REST API** to search for books by title.
- **Binary Search** implementation for efficient book retrieval.
- **MongoDB** integration for storing and retrieving books.
- Simple, extensible project structure.

---

## Getting Started

### Prerequisites

- **Java 17** (or higher)
- **Maven** (or your preferred build tool)
- **MongoDB** installed locally or accessible via URI

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/spring-boot-book-search.git
   cd spring-boot-book-search
   ```

2. **Set up MongoDB:**
   - Make sure MongoDB is running locally or accessible at the URI specified in `application.yml`:
     ```yaml
     spring:
       data:
         mongodb:
           uri: mongodb://localhost:27017/bookdb
           database: bookdb
     ```

3. **Build the application:**

   ```bash
   mvn clean install
   ```

4. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

---

## API Usage

### Endpoint: `/search`
- **Method:** `GET`
- **Description:** Searches for books by title using binary search.

#### Request Parameters:
- `title` (required): The title (or partial title) of the book to search for.

#### Example Request:
```bash
curl "http://localhost:8080/search?title=Dune"
```

#### Example Response:
If the book is found:
```json
[
  {
    "id": "63c1f2...",
    "title": "Dune",
    "author": "Frank Herbert"
  }
]
```

If no books match the query:
```json
[]
```

---

## Project Structure

```plaintext
src/main/java/com/example/booksearch
    ├── BookSearchApplication.java        # Main Spring Boot application class
    ├── controller/BookController.java    # REST controller for handling API requests
    ├── model/Book.java                   # Entity representing a book in MongoDB
    ├── repository/BookRepository.java    # MongoDB repository interface
    ├── service/BookService.java          # Service interface for book search logic
    ├── service/BookServiceImpl.java      # Service implementation with binary search logic
```

---

## Binary Search Logic

The binary search is implemented in the service layer to improve search efficiency. The logic works as follows:

1. Retrieve all books from the MongoDB collection.
2. Sort the books by title in a case-insensitive manner.
3. Perform binary search on the sorted list to find matches for the given title.

---

## Adding Sample Data

You can add sample data to the MongoDB database using the MongoDB CLI or Compass:

```json
db.books.insertMany([
  { "title": "The Hobbit", "author": "J.R.R. Tolkien" },
  { "title": "Dune", "author": "Frank Herbert" },
  { "title": "Pride and Prejudice", "author": "Jane Austen" },
  { "title": "To Kill a Mockingbird", "author": "Harper Lee" },
  { "title": "1984", "author": "George Orwell" }
])
```

---

## Extending the Application

Here are a few ideas to extend the functionality:
- Add search by **author** or **genre**.
- Implement **pagination** for large datasets.
- Enhance error handling and validation.
- Use **DTOs** for cleaner API responses.
- Add **Swagger** for API documentation.

---

## Dependencies

The following dependencies are used in this project:
- **Spring Boot Web**: For building the REST API.
- **Spring Data MongoDB**: For interacting with MongoDB.
- **Spring Boot DevTools**: For easy development and debugging.

Let me know if you'd like to customize this further!
