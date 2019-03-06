package Demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication					//SpringBoot 的核心注解,主要目的是开启自动配置
@Controller								//表明  这事SpringMVC的一个控制器
public class HelloApplication {
	 @RequestMapping("/hello")
	 //@ResponseBody
	 public String hello() {
	    return "hello world";
	 }

	    public static void main(String[] args) {
	        SpringApplication.run(HelloApplication.class, args);
	    }
	
}	
