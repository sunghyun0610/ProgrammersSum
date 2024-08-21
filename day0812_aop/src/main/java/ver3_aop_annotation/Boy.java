package ver3_aop_annotation;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("sunghyun")
public class Boy {
    public void makeTaco() throws Exception {

            System.out.println("멕시칸 타코를 만든다.");//클래스의 핵심관심사항== 예시 ) 로그인 작업 등..
            if (new Random().nextBoolean()) {//핵심 관심사항 수행 도중 만약 예외가 발생한다면?
                throw new Exception("불났다!!!~");
            }

    }
}
