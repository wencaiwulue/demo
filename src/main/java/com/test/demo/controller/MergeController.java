package com.test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author naison
 * @since 2/25/2020 22:08
 */
@Controller
@RequestMapping("/test")
public class MergeController {

    private static Queue<Integer> queue = new ArrayBlockingQueue<>(1000);

    private static Map<Integer, Map<String, Object>> result = new ConcurrentHashMap<>(1000);

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    private static AtomicInteger i = new AtomicInteger();

    static {
        Runnable r = () -> {
            if (queue.isEmpty()) return;

            List<Integer> s = new ArrayList<>(queue.size());
            while (!queue.isEmpty()) {
                s.add(queue.poll());
            }
            result = sql(s);
        };
        executor.scheduleAtFixedRate(r, 0, 10, TimeUnit.MILLISECONDS);
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable int id) {
        queue.add(id);
        Callable callable = () -> {
            while (!result.containsKey(id)) {
                Thread.sleep(1);
            }
            return result.get(id);
        };
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<Integer, Map<String, Object>> sql(List<Integer> id) {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("合并查询，合并了%s个请求\n", id.size());
        i.addAndGet(id.size());
        return id.stream().map(e -> {
            String s = e.toString();
            return Integer.valueOf(s + s);
        }).collect(Collectors.toMap(e -> e, e -> new HashMap<>(0)));
    }

    public static void main(String[] args) throws InterruptedException {
        MergeController test = new MergeController();
        List<Thread> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            list.add(new Thread(() -> test.get(finalI)));
        }
        list.forEach(Thread::start);
        Thread.sleep(1000);
        System.out.printf("总共的请求数量为：%s个", i.get());
    }
}
