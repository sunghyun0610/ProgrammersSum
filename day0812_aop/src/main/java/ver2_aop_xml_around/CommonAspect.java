package ver2_aop_xml_around;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAspect {
//    public void bbbefore(){
//        System.out.println("배가 고프다.");//before 핵심 관심사항 수행하기 전에 해야할 일==비밀번호 hashing..등
//    }
//
//    public void aaafterReturning(){
//        System.out.println("맛있게 먹는다~");//핵심 관심사항이 정상적으로 종료된게 확인 됐을 때! ->커밋의 시점
//    }
//
//    public void aaafterThrowing(){
//        System.out.println("엄마를 부른다!!!!");//예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠지.
//    }
//
//    public void aaafter(){
//        System.out.println("설거지를 한다...");//반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
//    }

    //위에처럼 전후 다 적용하고자 하는 경우에는 굳이 하나하나 떼서 만들지 않고 아래처럼 around하면 편해염.

    public Object aaaround(ProceedingJoinPoint target){//aop를 적용할 target
        System.out.println("배가 고프다.");
        Object result = null;//before 핵심 관심사항 수행하기 전에 해야할 일==비밀번호 hashing..등
        try {
            target.proceed();//이 시점에 타코 만들거나 삼겹살 굽거나 그런 일들이 일어날 거야.
            System.out.println("맛있게 먹는다~");//핵심 관심사항이 정상적으로 종료된게 확인 됐을 때! ->커밋의 시점
        } catch (Throwable e) {
            System.out.println("엄마를 부른다!!!!");//예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠지.
            throw new RuntimeException(e);
        }finally {
            System.out.println("설거지를 한다...");//반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }
        return result;

    }
}
