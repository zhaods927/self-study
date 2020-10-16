package com.zds.selfstudy.threads;

import com.zds.selfstudy.util.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @program: threads
 * @description: 继承Thread类
 * @author: zhaods
 * @create: 2020-10-10 16:30
 **/
@Slf4j
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        super.start();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService pool = ThreadPoolUtil.getThreadPool();
        pool.submit(new ImplRunnable());

        ImplCallable implCallable = new ImplCallable();
        Future<String> future = pool.submit(implCallable);
        String s = future.get();
        log.info("callable返回：{}", s);
    }


}
