package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        log.info("target={}", callServiceV0.getClass());
        //internal 에는 aop가 걸리지 않는다
        //내부호출 대안 -> 자기자신주입 , 지연조회, 구조변경
        callServiceV0.external();
    }

    @Test
    void internal() {
        callServiceV0.internal();
    }
}
