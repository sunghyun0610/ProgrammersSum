package ver2_aop_xml_around;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
//        Boy sunghyun = new Boy();
//        sunghyun.makeTaco();

        ApplicationContext ctx= new FileSystemXmlApplicationContext("/src/main/java/ver2_aop_xml_around/beans.xml");
        Boy sunghyun=(Boy) ctx.getBean("sunghyun");
        sunghyun.makeTaco();

    }
}
//spring의 관리를 받아야지 aop를 적용한 객체가 나옴.
