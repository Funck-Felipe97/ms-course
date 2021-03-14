cd hr-api-gateway-zuul && ./mvnw clean install -DskipTests
cd ../hr-config-server && ./mvnw clean install -DskipTests
cd ../hr-eureka-server && ./mvnw clean install -DskipTests
cd ../hr-oauth && ./mvnw clean install -DskipTests
cd ../hr-payroll && ./mvnw clean install -DskipTests
cd ../hr-user && ./mvnw clean install -DskipTests
cd ../hr-worker && ./mvnw clean install -DskipTests
