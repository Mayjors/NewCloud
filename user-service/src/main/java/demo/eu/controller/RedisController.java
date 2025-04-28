package demo.eu.controller;

import demo.eu.common.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("save")
    public BaseResult save(String key, String value){
        Object object = redisTemplate.opsForValue().get(key);
        if (object == null) {
            redisTemplate.opsForValue().set(key, value);
        }
        return BaseResult.success();
    }
}
