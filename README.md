# Building Web Services with Java EE 8 <br>Section 6: Advanced REST APIs

## Videos

### Video 6.1: Apply Design by Contract: Adding validation.

In this video we are implementing validation for the inputs of a REST resource.

| Method  | URI | Status | Description |
|---------|-----|--------|-------------|
| GET    | /api/validation/books  | 200 | List of books |
| GET    | /api/validation/books/{ISBN} | 200 or 400 | A book by ISBN or invalid request |
| POST   | /api/validation/books  | 201 or 400 | Create a book new book or invalid request|

### Video 6.2: Using JSON Web Token (JWT) for Authentication

In this video we are implementing a JWT based authentication for a REST resource.

| Method  | URI | Status | Description |
|---------|-----|--------|-------------|
| GET    | /api/jwt/authentication  | 200 or 403 | Get authentication details or unauthorized response |


### Video 6.3: Diagnosability: Logging, Tracing and Metrics

In this video is showing how to subscribe and broadcast SSE events to all registered clients.
to calculate Fibonacci numbers async.

| Method | URI | Media Type | Description |
|--------|-----|--------|-------------|
| GET    | /api/broadcast | text/event-stream | Get and open the SSE stream of broadcasted messages |
| POST   | /api/broadcast | application/x-www-form-urlencoded | Send a broadcast message |


## Building and Running

```bash
$ mvn clean verify

$ docker build -t sse-service:1.0 .
$ docker run -it -p 8080:8080 sse-service:1.0
```
