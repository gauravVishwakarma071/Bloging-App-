📝 Blogging Application - Spring Boot Mini Project

A "Blogging Application" built with "Spring Boot", serving as a mini social media platform where users can register, log in, create posts, like posts, and comment on articles.
This project is under development and is part of a learning journey following an online course, implementing "MVC architecture", "JWT authentication", and "Spring Security".

---

🚀 Features

* 🔐 User "signup" and "login" with "JWT authentication"
* ✍️ Create, Read, Update, Delete (**CRUD**) operations for blog posts
* 💬 Comment on articles
* ❤️ Like/unlike posts
* 👥 Follows a social media-like interaction model
* 📘 Initially uses "H2", migrated to "PostgreSQL"
* 🧩 Follows "MVC architecture"
* 🧰 Integrated "Swagger UI" for API testing and documentation

---

## 🛠️ Technologies & Tools

| Category            | Tools / Frameworks                          |
| ------------------- | ------------------------------------------- |
| **Backend**         | Spring Boot, Spring Web, Spring Security    |
| **Authentication**  | JWT (JSON Web Token), BCryptPasswordEncoder |
| **Database**        | H2 (dev), PostgreSQL (prod)                 |
| **ORM & Utilities** | Spring Data JPA, ModelMapper                |
| **Testing**         | Spring Boot Starter Test                    |
| **Documentation**   | Swagger UI                                  |
| **Build Tool**      | Gradle                                      |
| **IDE / DB Tools**  | IntelliJ IDEA, DBeaver                      |

---

🧩 Architecture

The project follows **Model-View-Controller (MVC)** for clean separation of concerns:

"Controller → Service → Repository → Entity (Model)"

**Entities Overview:**

| Entity            | Fields                                             | Description                 |
| ----------------- | -------------------------------------------------- | --------------------------- |
| "UserEntity"    | id, username, email, password, bio, image          | User details                |
| "ArticleEntity" | id, title, slug, subTitle, body, createdAt, author | Blog posts created by users |
| "CommentEntity" | id, title, body, createdAt, author, article        | Comments on articles        |

"Relationships:"

* `ArticleEntity` → `UserEntity` (ManyToOne, author)
* `CommentEntity` → `UserEntity` & `ArticleEntity` (ManyToOne)

---

⚙️ How to Run the Project

Prerequisites

* Java 17+
* Gradle
* PostgreSQL (optional for production)
* IDE: IntelliJ, Eclipse, or VS Code

Steps

1. "Clone the repository:"

```bash
git clone https://github.com/gauravVishwakarma071/Bloging-App.git
```

2. "Navigate into project directory:"

```bash
cd Bloging-App
```

3. "Run the application:"

```bash
./gradlew bootRun
```

or run the main class from your IDE.

4. "Access the application:"

```
http://localhost:8855/
```

5. "Swagger Documentation:"

```
http://localhost:8855/swagger-ui/
```

---

📡 API Endpoints (Partial / Work in Progress)

| Method | Endpoint                | Description             |
| ------ | ----------------------- | ----------------------- |
| POST   | /users/signup           | Register new user       |
| POST   | /users/login            | Login user & return JWT |
| GET    | /api/posts              | Get all articles        |
| GET    | /api/posts/{id}         | Get article by ID       |
| POST   | /api/posts              | Create new article      |
| PUT    | /api/posts/{id}         | Update article          |
| DELETE | /api/posts/{id}         | Delete article          |
| POST   | /api/posts/{id}/like    | Like/unlike article     |
| POST   | /api/posts/{id}/comment | Comment on article      |

---

🧠 Learning Objectives

* Implement **JWT authentication** with Spring Security
* Use **ModelMapper** for DTO conversion
* Set up **Swagger UI** for API testing
* Apply **Gradle build automation**
* Design a **REST API** using MVC architecture
* Practice database migrations: **H2 → PostgreSQL**

---

🚧 Project Status

🏗️ Work in progress — features to add:

* Image uploads for posts and profiles
* User profile pages
* Advanced comment & like system
* Notifications for social interactions

---

🧑‍💻 Author

"Gaurav Vishwakarma"
Spring Boot Developer | Java Enthusiast
🔗 [LinkedIn Profile](https://www.linkedin.com/in/gauravvishwakarma071)

---

⭐ Acknowledgments

Special thanks to the online course and instructors guiding this **Spring Boot learning journey**.

---

💬 LinkedIn Post Caption

> 🚀 **Just Built a Blogging Application using Spring Boot!**
> I’ve been working on a mini **Blogging App**, a social-media-style platform where users can register, log in, create posts, like and comment — all secured using **Spring Security and JWT** 🔐
>
> This project helped me dive deep into:
> ✅ MVC Architecture
> ✅ JWT Authentication
> ✅ CRUD APIs with Spring Boot
> ✅ Swagger for API documentation
> ✅ Gradle Build Automation
>
> The project is still under development as I continue learning and improving my Spring Boot skills 💡
>
> 🔗 Check it out on GitHub: [github.com/gauravVishwakarma071/Bloging-App](https://github.com/gauravVishwakarma071/Bloging-App)
>
> #SpringBoot #Java #JWT #BackendDevelopment #LearningInPublic #OpenSource #APIDevelopment

---

If you want, I can also make a **clean diagram of your MVC flow with entities** and **highlight upcoming features visually** for your README — it will make it more attractive to recruiters.

Do you want me to do that next?
