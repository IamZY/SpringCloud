# SpringCloud
## 分布式架构

## Eureka注册中心-Server

```xml
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.ntuzy.springcloud</groupId>
    <artifactId>registry</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>registry</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Finchley.RC1</spring-cloud.version>
</properties>
```

```properties
spring:
  application:
    # 注册中心名称
    name: registry

# 注册中心映射端口号 建议默认与Eureka一致
server:
  port: 8761

```

```java
package com.ntuzy.springcloud.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //启动注册中心
public class RegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }

}

```

## Eureka-Client

```xml
<parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.ntuzy.springcloud</groupId>
    <artifactId>registry</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>registry</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
        <spring-cloud.version>Finchley.RC1</spring-cloud.version>
</properties>
```

```properties
spring:
  application:
    name: client
eureka:
  client:
    service-url:
      defaultZone : http://localhost:8761/eureka/

```

