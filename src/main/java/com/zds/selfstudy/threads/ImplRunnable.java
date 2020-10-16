package com.zds.selfstudy.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: threads
 * @description: 实现Runnable接口
 * @author: zhaods
 * @create: 2020-05-17 14:21
 **/
@Slf4j
public class ImplRunnable implements Runnable {

    @Override
    public void run() {

        log.info("进入run方法：{}", System.currentTimeMillis());
    }

}
