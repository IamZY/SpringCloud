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

+ app

  ```java
  @SpringBootApplication
  @EnableEurekaClient // 在启动 Eureka Server 注册 客户端
  public class ClientApplication {
  
      public static void main(String[] args) {
          SpringApplication.run(ClientApplication.class, args);
      }
  
  }
  ```

## 网关Netflix Zuul  

+ Gateway 网关

  以轮询的方式访问系统中的所有客户端

  > // Zuul 路由的访问规则是// http://xxxx:xxx/service-id

  client + Zuul

  ```xml
   <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
          </dependency>
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
          </dependency>
  ```

+ application.yml

  ```properties
  spring:
    application:
      name: gateway
  eureka:
    client:
      service-url:
        defaultzone: http://localhost:8761/eureka/
  
  server:
    port: 9000
  ```

+ app

  ```java
  @SpringBootApplication
  @EnableDiscoveryClient
  @EnableZuulProxy   // 启动Zuul路由服务
  // Zuul 路由的访问规则是
  // http://xxxx:xxx/service-id
  public class GatewayApplication {
  
      public static void main(String[] args) {
          SpringApplication.run(GatewayApplication.class, args);
      }
  
  }
  ```

### 自定义规则

>  http://localhost:9000/c/msg

+ application.yml

  ```properties
  zuul:
    routes:
      client: /c/**
  ```

## Eureka 注册中心 高可用配置

+ application.yml

  ```properties
  spring:
    application:
      # 注册中心名称
      name: registry
  
  # 注册中心映射端口号 建议默认与Euraka一致
  server:
    port: 8761
  # 对应Euraka没必要注册客户端
  eureka:
    client:
      register-with-eureka: false
      service-url:
        defaultZone: http://localhost:8762/eureka
  
  ```

## 实战

### member

eureka client + web + jpa + jdbc

+ application.xml

  ```xml
  spring:
    application:
      name: member
    datasource:
      username: root
      password: 123456
      driver-class-name: com.mysql.jdbc.Driver
      url: jdbc:mysql://localhost:3306/sc-member?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
  
  server:
    port: 8000
  eureka:
    client:
      service-url:
        defaultZone: http://localhost:8761/eureka
  
  ```

## 配置中心

client+config server+ config client

> http://localhost:9100/[clientid]-profiles.yml|xml|properties

+ application.yml

  ```properties
  spring:
    application:
      name: config
    cloud:
      config:
        server:
          git:
            uri: https://gitee.com/ntuzy/sc-config
            username: 562018301@qq.com
            password: *********
  server:
   port: 9100
  ```

+ application

  ```java
  package com.ntuzy.springcloud.config;
  
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
  import org.springframework.cloud.config.server.EnableConfigServer;
  
  @SpringBootApplication
  @EnableDiscoveryClient
  @EnableConfigServer
  public class ConfigApplication {
  
      public static void main(String[] args) {
          SpringApplication.run(ConfigApplication.class, args);
      }
  
  }
  ```

+ member 中删除application.yml 增加 bootstrap.yml

  

























