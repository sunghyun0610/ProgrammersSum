package ver0_no_aop;

import java.util.Random;

public class Girl {
    public void makeSamgyepsal(){
        System.out.println("배가 고프다.");//before 핵심 관심사항 수행하기 전에 해야할 일==비밀번호 hashing..등
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        try {
            System.out.println("삼겹살을 굽거나 삶는다");//클래스의 핵심관심사항== 예시 ) 로그인 작업 등..
            if (new Random().nextBoolean()) {//핵심 관심사항 수행 도중 만약 예외가 발생한다면?
                throw new Exception("불났다!!!");
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////
        }catch (Exception e){
            System.out.println("엄마를 부른다!!!!");//예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠지.
        }finally {
            System.out.println("설거지를 한다...");//반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }
    }
}
