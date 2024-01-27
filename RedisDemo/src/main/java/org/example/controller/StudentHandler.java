package org.example.controller;

import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class StudentHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * オブジェクトのCRUD
     */
    @PostMapping("/set")
    public void set(@RequestBody Student student) {
        redisTemplate.opsForValue().set("student", student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable("key") String key) {
        return (Student)redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable("key") String key) {
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    /**
     * StringのCRUD
     */
    @GetMapping("/string/{key}/{value}")
    public String stringTest(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * StringのCRUD
     */
    @GetMapping("/setnx/{key}/{value}")
    public String stringnxTest(@PathVariable("key") String key, @PathVariable("value") String value) {
        String clientId = UUID.randomUUID().toString();

        redisTemplate.opsForValue().setIfAbsent(key, clientId, 1, TimeUnit.SECONDS);
        redisTemplate.opsForValue().setIfAbsent(key, value, 1, TimeUnit.SECONDS);

        if (clientId.equals(redisTemplate.opsForValue().get(key))) {
            redisTemplate.delete(key);
        }

        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * listのCRUD
     */
    @GetMapping("/list")
    public List<String> listTest() {
        ListOperations<String, String> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("list", "test1");
        listOperations.leftPush("list", "test2");
        listOperations.leftPush("list", "test3");
        listOperations.leftPush("list", "test4");

        return listOperations.range("list", 0, -1);
    }

    /**
     * SetのCRUD
     */
    @GetMapping("/set")
    public Set<String> setTest() {
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add("set", "set1");
        setOperations.add("set", "set1");
        setOperations.add("set", "set2");
        setOperations.add("set", "set3");

        return setOperations.members("set");
    }

    /**
     * Sorted SetのCRUD
     */
    @GetMapping("/zset")
    public Set<String> zsetTest() {
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zset", "zset1", 1);
        zSetOperations.add("zset", "zset2", 4);
        zSetOperations.add("zset", "zset3", 3);
        zSetOperations.add("zset", "zset4", 2);

        return zSetOperations.range("zset", 0, -1);
    }

    /**
     * HashのCRUD
     */
    @GetMapping("/hash")
    public void hashTest() {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key1", "hashkey1", "hashvalue1");
        hashOperations.put("key2", "hashkey2", "hashvalue2");
        hashOperations.put("key3", "hashkey3", "hashvalue3");

        System.out.println(hashOperations.get("key1", "hashkey1"));
        System.out.println(hashOperations.get("key2", "hashkey2"));
        System.out.println(hashOperations.get("key3", "hashkey3"));
    }

}

