
# Giai doan 1: Build ung dung bang Maven va Java 17
FROM maven:3.9.0-eclipse-temurin-17 AS build

WORKDIR /app

# Copy file cau hinh Maven
COPY pom.xml .

# Copy ma nguon
COPY src ./src

# Build file WAR
RUN mvn -B clean package -DskipTests


# Giai doan 2: Chay ung dung tren Tomcat 10.1
FROM tomcat:10.1.61-jre17-temurin-noble

# Xoa cac ung dung mac dinh cua Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Dua file WAR vao Tomcat
# ROOT.war giup website mo ngay tai dia chi goc
COPY --from=build /app/target/EmailListMVC.war \
    /usr/local/tomcat/webapps/ROOT.war

# Port mac dinh cho Render
EXPOSE 10000

# Doc PORT cua Render va khoi dong Tomcat
CMD ["sh", "-c", "PORT_TO_USE=${PORT:-10000}; sed -i \"s/port=\\\"8080\\\"/port=\\\"${PORT_TO_USE}\\\"/\" \"$CATALINA_HOME/conf/server.xml\"; exec \"$CATALINA_HOME/bin/catalina.sh\" run"]
