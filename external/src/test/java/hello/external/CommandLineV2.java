package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    //--url=devdb --username=dev_user --password=dev_pw mode=on
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg); //커맨드 라인의 입력 결과를 그대로 출력한다.
        }

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);

        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs())); // 커맨드 라인 인수 전부를 출력한다.
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); //-가 안 들어간 것
        log.info("OptionNames = {}", appArgs.getOptionNames()); //key=value 형식으로 사용되는 옵션 인수다.

        Set<String> optionNames = appArgs.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option args {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        //참고로 옵션 인수는 --username=userA --username=userB처럼 하나의 키에 여러 값을 포함할 수 있기 때문에 결과는 리스트(List)를 반환한다.
        //커맨드 라인 옵션 인수는 자바 언어의 표준 기능이 아니다. 스프링이 편리함을 위해 제공하는 기능이다.
        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode"); //mode는 옵션 인수가 아니므로 getOptionValues로 조회 불가 (null)

        log.info("url={}", url);
        log.info("username={}", username);
        log.info("password={}", password);
        log.info("mode={}", mode);
    }

}