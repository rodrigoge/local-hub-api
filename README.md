## 🥡 Local Hub API
An API responsible for allowing scheduling of various services, such as restaurant reservations, medical appointments and others.

### ✨ Main challenges
- TDD
- Clean Architecture
- SOLID principles
- OpenAPI Documentation

### 🧰 Stack used
- Java 21
- Spring Boot
- PostgreSQL

### 📚 API Documentation
#### Get all locals
```http
  GET /locals
```

| Parameter   | Type       | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `page` | `integer` | **Required**. Number of page  |
| `limit` | `integer` | **Required**. Limit of locals per page  |
| `column` | `string` | **Required**. Column name of locals by ordering  |
| `order` | `string` | **Required**. Order type of locals  |
| `name` | `string` | Name of a local  |
| `address` | `string` | Address of a local  |
| `type` | `string` | Types of locals  |
| `state` | `string` | Brazilian states of locals  |
| `city` | `string` | Brazilian cities of locals  |

### 👋 Author
- [@rodrigoge](https://www.github.com/rodrigoge)

### 📝 License
Read this [MIT](https://github.com/rodrigoge/local-hub-api/blob/main/LICENSE) license clicking here.
