package com.ntuzy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author IamZY
 * @create 2020/4/12 16:31
 */
@Configuration
@MapperScan({"com.ntuzy.springcloud.dao"})
public class MyBatisConfig {

}
