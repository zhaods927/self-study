package com.zds.selfstudy.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: threads
 * @description: 线程池
 * @author: zhaods
 * @create: 2020-05-17 15:08
 **/
public class ThreadPoolUtil {

    private static final ExecutorService THREAD_POOL;

    static {
        int corePoolSize = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = Runtime.getRuntime().availableProcessors() * 2;
        long keepAliveTime = 5;
        TimeUnit keepAliveTimeUnit = TimeUnit.MINUTES;
        int queSize = 100_000;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-call-runner-%d")
                .build();

        THREAD_POOL = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                keepAliveTime, keepAliveTimeUnit, new ArrayBlockingQueue<Runnable>(queSize)
                , threadFactory);
    }

    /**
     * 获取线程池
     *
     * @return 线程池
     */
    public static ExecutorService getThreadPool() {

        return THREAD_POOL;
    }

}
