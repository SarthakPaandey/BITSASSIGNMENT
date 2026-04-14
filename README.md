# 🎓 BITS Assignment — Java Web Application

A Java web application developed as a course assignment for BITS Pilani. Built with Java EE, JSP, and Maven, it demonstrates server-side web development fundamentals.

## Overview

BITSASSIGNMENT is a Maven-based Java web application using JSP (JavaServer Pages) for the presentation layer. It follows standard Java EE project structure with separate packages for business logic and web resources.

## Project Structure

```
BITSASSIGNMENT/
├── src/
│   ├── main/
│   │   ├── java/com/bitsassignment/   # Java source files
│   │   ├── resources/                # Configuration files
│   │   └── webapp/WEB-INF/jsp/       # JSP views
│   └── test/java/com/bitsassignment/ # Unit tests
└── pom.xml                            # Maven build config
```

## Tech Stack

| Component  | Technology        |
|------------|-------------------|
| Language   | Java              |
| View Layer | JSP               |
| Build Tool | Maven             |
| Style      | CSS               |

## Getting Started

### Prerequisites

- Java 11+
- Maven 3.x
- Any Java EE servlet container (Tomcat, etc.)

### Build and Run

```bash
mvn clean package
# Deploy the generated WAR to your servlet container
```

## License

MIT License
