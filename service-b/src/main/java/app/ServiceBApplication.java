package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
public class ServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBApplication.class, args);
    }

    @GetMapping("/login/{userName}")
    public String login(@PathVariable String userName, HttpSession session) {
        session.setAttribute("userInfo", new UserInfo(userName));
        return userName + "login success";
    }

    @GetMapping("/getUser")
    public UserInfo getUser(HttpSession session) {
        return (UserInfo) session.getAttribute("userInfo");
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("userInfo");
    }
}
