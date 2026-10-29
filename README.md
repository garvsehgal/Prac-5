# FeedbackApp — CSIT751 Module V (Tomcat 9)

Requirements: JDK 11+, Maven 3.8+, Apache Tomcat 9 (Servlet 4.0 / javax.servlet).

1. Open this folder in VS Code.
2. Run `mvn clean package` from this folder.
3. Copy `target/FeedbackApp.war` into Tomcat 9's `webapps` folder.
4. Start Tomcat using `bin/startup.bat` (Windows) or `bin/startup.sh` (macOS/Linux).
5. Visit http://localhost:8080/FeedbackApp/feedback.html
6. Fill out the form and submit to see the result.

The servlet runs on Tomcat; it does not have a `main()` method.
