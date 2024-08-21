package aop_proxy;

public class CAfterReturning implements IAfterReturning{
    @Override
    public void doAfterReturn() {
        System.out.println("냐미 ~");
    }
}
