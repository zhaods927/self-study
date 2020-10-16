package com.zds.selfstudy.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * @program: threads
 * @description: 实现Callable接口，返回Feature
 * @author: zhaods
 * @create: 2020-05-17 14:37
 **/
@Slf4j
public class ImplCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        log.info("进入call方法：{}", System.currentTimeMillis());

        return "SUCCESS";
    }
}
