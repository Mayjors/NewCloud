package demo.eu.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class Test {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务开始执行");
            System.out.println("异步任务执行结束");
            return "返回结果";
        });
        String result = future.join();
        String result2 = null;
        try {
            result2 = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("result:" + result);
        System.out.println("result2:" + result2);

        CompletableFuture.runAsync(() -> {
            System.out.println("任务go");
            System.out.println("任务done");
        });

        CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            String id = UUID.randomUUID().toString();
            System.out.println("执行任务A：" + id);
            return id;
        });
        CompletableFuture<String> taskB = taskA.thenApply(t -> {
            System.out.println("任务B获取到任务A结果：" + t);
            t = t.replace("-", "");
            return t;
        });

        System.out.println("main线程拿到结果：" + taskB.join());

        CompletableFuture.supplyAsync(() -> {
            System.out.println("任务A");
            return "abcdefg";
        }).thenAccept(t -> {
            System.out.println("任务b，拿到结果处理：" + t);
        });

    }
}
