package aop_proxy;

//실제 peroson은 boy girl이지만 proxy가 person인척 대리인 역할을 수행함.
public class PersonProxy implements Person{
    private IBefore before;
    private IAfterReturning afterReturn;
    private IAfter after;
    private IAfterThrowing afterThrow;
    private Person target;//핵심 관심사항 구현체. Boy or Girl과 같은

    @Override
    public void makeFood() throws Exception {//대행 메서드
        if(before!=null) before.doBefore();//배고파요
        try{
            target.makeFood();//타코 만들기 ==>핵심 관심사항!!!!
            if(afterReturn!=null){
                afterReturn.doAfterReturn();//냠냠 머겅요
            }
        }catch (Exception e){
            if(afterThrow!=null) afterThrow.doAfterThrow();//불났어 ->엄마
        }finally {
            if(after!=null) after.doAfter();//설거지
        }
    }

    public void setTarget(Person target) {
        this.target = target;
    }

    public void setBefore(IBefore before) {
        this.before = before;
    }

    public void setAfterReturn(IAfterReturning afterReturn) {
        this.afterReturn = afterReturn;
    }

    public void setAfter(IAfter after) {
        this.after = after;
    }

    public void setAfterThrow(IAfterThrowing afterThrow) {
        this.afterThrow = afterThrow;
    }
}
