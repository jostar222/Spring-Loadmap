package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //자동으로 private final Logger log = LoggerFactory.getLogger(getClass()); 코드 넣어줌
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());
    //private final Logger log = LoggerFactory.getLogger(Logger.class);

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace my log="+name); //더하기 연산이 발생하여 리소스를 사용하나, 출력은 안함(리소스를 사용하는게 문제)

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
