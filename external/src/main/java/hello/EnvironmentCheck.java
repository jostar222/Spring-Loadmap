package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    /**
     * 1. 더 유연한 것이 우선권을 가진다. (변경하기 어려운 파일 보다 실행시 원하는 값을 줄 수 있는 자바 시스템 속성이 더 우선권을 가진다.)
     * 2. 범위가 넒은 것 보다 좁은 것이 우선권을 가진다. (자바 시스템 속성은 해당 JVM 안에서 모두 접근할 수 있다.
     * 반면에 커맨드 라인 옵션 인수는 의 arg를 통해서 들어오기 때문에 접근 범위가 더 좁다.)
     */
    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");
        log.info("env url={}", url);
        log.info("env username={}", username);
        log.info("env password={}", password);
    }
}
