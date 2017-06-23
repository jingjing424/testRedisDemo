package com.ljj.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest  extends BaseTest{
	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * ���Բ������ȡRedis������
     * @Title: testPutAndGet 
     * @Description: TODO
     * @throws
     */
    @Test
    public void testPutAndGet() {
    	redisTemplate.opsForHash().put("user", "name", "rhwayfun");
        Object object = redisTemplate.opsForHash().get("user", "name");
        System.out.println(object);
    }

    /**
     * ����Redis��Ϊ���������
     * @Title: testCache 
     * @Description: TODO
     * @throws InterruptedException
     * @throws
     */
    @Test
    public void testCache() throws InterruptedException {
        // ����һ������
        redisTemplate.opsForHash().put("user", "name", "rhwayfun");
        // ����ʧЧʱ��Ϊ2��
        redisTemplate.expire("user", 2, TimeUnit.SECONDS);
        Thread.sleep(1000);
        // 1����ȡ
        Object object = redisTemplate.opsForHash().get("user", "name");
        System.out.println("1���" + object);
        Thread.sleep(1000);
        // 2����ȡ
        object = redisTemplate.opsForHash().get("user", "name");
        System.out.println("2���" + object);
    }
}
