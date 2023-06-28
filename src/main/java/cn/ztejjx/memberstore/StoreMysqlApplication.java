package cn.ztejjx.memberstore;

import cn.ztejjx.memberstore.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@EnableAsync //异步任务
@ServletComponentScan //拦截器，过滤器，监听器
@SpringBootApplication
public class StoreMysqlApplication {

	@Autowired
	private RedisUtils redisUtil;

	public static void main(String[] args) {
      SpringApplication.run(StoreMysqlApplication.class, args);

	}
}


