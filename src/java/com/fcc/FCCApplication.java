package com.fcc;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2017/10/23.
 */
@EnableTransactionManagement
@SpringBootApplication
public class FCCApplication {

    protected final static Logger logger = LoggerFactory.getLogger(FCCApplication.class);

    public static void main(String[] args){

        JSON.DEFAULT_TYPE_KEY = "type";

        SpringApplication.run(FCCApplication.class,args);
        logger.info("LawApplication Start success!!!");
    }
}
