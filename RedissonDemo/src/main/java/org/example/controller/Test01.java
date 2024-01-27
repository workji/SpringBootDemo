package org.example.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test01 {

    @Autowired
    private Redisson redisson;


    @GetMapping("/test/{key}")
    public void test(@PathVariable("key") String key) {

        RLock redissonLock = redisson.getLock(key);
        redissonLock.lock();

        try {
            // do something
        } catch (Exception e) {
            // do something
        } finally {
            redissonLock.unlock();
        }

    }
}
