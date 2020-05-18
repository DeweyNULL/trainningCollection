package com.dewey.core.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program springbootcachedemo
 * @description: Mybatis-plus配置类
 * @author: xielinzhi
 * @create: 2019/05/30 17:51
 */
//@Configuration
public class MybatisPlusConfig {

    @Value("${dbtype}")
    private String db;
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        //设置方言
        page.setDialectClazz(db);
        return page;
    }
}
