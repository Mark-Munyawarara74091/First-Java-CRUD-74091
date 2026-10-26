# First Java CRUD

A simple Product Manager web application with Java 17+, Spring Boot 3, Spring Data JPA, and an H2 file database.

## Run in IntelliJ IDEA

1. Extract the ZIP and open the **First-Java-CRUD** folder in IntelliJ IDEA.
2. Trust the project and allow Maven to download dependencies (internet required).
3. Set Project SDK to Java 17 or newer (Java 25 is also fine if your environment supports it).
4. Run `CrudApplication.java` (green play button), or run `mvn spring-boot:run` from the project directory if Maven is installed.
5. Visit **http://localhost:8080** in a browser.

If port 8080 is in use, stop the other application or change `server.port` in `src/main/resources/application.properties`.

## CRUD features

- Create: enter a product name and price and click **Add Product**.
- Read: all products appear in the table.
- Update: click **Edit**, change details, then **Save Changes**.
- Delete: click **Delete** and confirm.

REST API: `GET /api/products`, `GET /api/products/{id}`, `POST /api/products`, `PUT /api/products/{id}`, `DELETE /api/products/{id}`. For POST/PUT send JSON like `{"name":"Keyboard","price":49.99}`.

Data is saved locally under `data/` and is ignored by Git. This is a class exercise, not a production-ready application.

## GitHub collaboration requirements

1. Create your own **public** repository named `First-Java-CRUD`. Your GitHub username must include your Student ID.
2. From this folder, run:
   ```bash
   git init
   git add .
   git commit -m "Initial Java CRUD application"
   git branch -M main
   git remote add origin https://github.com/YOUR-USERNAME/First-Java-CRUD.git
   git push -u origin main
   ```
   Replace `YOUR-USERNAME` with your real GitHub username. Create the GitHub repository empty (without a README) to avoid initial merge issues.
3. Give your partner your public repository URL. Your partner forks it, creates a branch, makes a small genuine change, commits it, pushes it, and opens a Pull Request to your `main` branch.
4. Review and merge your partner's PR. Do the equivalent for your partner's repository.
5. Confirm both authors appear in the commit history, and take screenshots as specified in `doc/README.md`.
6. Commit the screenshots and push again:
   ```bash
   git add doc
   git commit -m "Add assignment screenshots"
   git push
   ```
7. Submit **only** your public repository URL on Platon.

## Technology

Java 17+, Spring Boot 3.5.7, Maven, H2, Spring Data JPA, HTML/CSS/JavaScript.
