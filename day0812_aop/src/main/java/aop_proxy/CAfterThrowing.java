package aop_proxy;

public class CAfterThrowing implements IAfterThrowing{
    @Override
    public void doAfterThrow() {
        System.out.println("불났다 !!!!! -> 엄마호출");
    }
}
