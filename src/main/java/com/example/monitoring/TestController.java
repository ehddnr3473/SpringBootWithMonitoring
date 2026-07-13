package com.example.monitoring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final List<byte[]> CACHE = new ArrayList<>();

    @GetMapping("/cpu")
    public String useCpu() {
        int threads = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < threads; i++) {

            new Thread(() -> {

                while (true) {
                    Math.sqrt(Math.random());
                }

            }).start();
        }

        return "Ok";
    }

    @GetMapping("/heap")
    public String useHeap() {
        CACHE.add(new byte[100 * 1024 * 1024]);
        return "Ok";
    }
}
