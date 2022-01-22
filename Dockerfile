From openjdk:8
Expose 8094
Add target/StudentManagementApp-0.0.1-SNAPSHOT.war StudentManagementApp-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/StudentManagementApp-0.0.1-SNAPSHOT.war"]