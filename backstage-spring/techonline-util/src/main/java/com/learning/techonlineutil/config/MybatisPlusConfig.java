package com.learning.techonlineutil.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MybatisPlusConfig.java
 * @Description TODO
 * @createTime 2019年08月15日 14:30:00
 */

@Configuration
@MapperScan("com.learning.**.mapper")
public class MybatisPlusConfig {
    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    /**
     * @title performanceInterceptor
     * @description plus的性能优化,开发环境使用
     * @author jaywatson
     * @param: []
     * @updateTime 2019/8/15 14:50
     * @return: com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @throws
     */
    @Bean
    @Profile("dev")
    public PerformanceInterceptor performanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //sql执行性能分析，开发环境使用，不推荐上线使用
        //maxTime 指的是 sql 最大执行时长
        performanceInterceptor.setMaxTime(60000);
        //sql是否格式化 默认为false
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * @title paginationInterceptor
     * @description
     * @author jaywatson
     * @param: []
     * @updateTime 2019/8/15 14:57
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @throws
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
