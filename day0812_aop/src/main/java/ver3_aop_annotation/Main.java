package ver3_aop_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
//        Boy sunghyun = new Boy();
//        sunghyun.makeTaco();

        ApplicationContext ctx= new AnnotationConfigApplicationContext(Beans.class);
        Boy sunghyun=(Boy) ctx.getBean("sunghyun");
        sunghyun.makeTaco();

    }
}
//spring의 관리를 받아야지 aop를 적용한 객체가 나옴.
//어떻게 makeTaco실행했는데 공통 실행내용도 실행되는걸까...? -> 프록시 개념에대해 알아보자