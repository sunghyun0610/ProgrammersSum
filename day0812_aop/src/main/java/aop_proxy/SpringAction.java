package aop_proxy;

public class SpringAction {
    public static void main(String[] args) throws Exception {
        Boy sunghyun=new Boy();//직접 객체 생성 안하고 스프링한테 달라고 했었죠

        //sunghyun.makeFood();//이걸 실행하는줄 알았는데, 스플링은 proxy를 주고 있었던 것.
        PersonProxy sunghyunProxy= new PersonProxy();
        sunghyunProxy.setTarget(sunghyun);
        sunghyunProxy.setBefore(new CBefore());
        sunghyunProxy.setAfterThrow(new CAfterThrowing());
        sunghyunProxy.setAfterReturn(new CAfterReturning());
        sunghyunProxy.setTarget(new Girl());

        sunghyunProxy.makeFood();
    }
}
