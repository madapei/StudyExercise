package com.mapei.javatest.test_exception;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/7
 */
class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning {
    public Inning() throws BaseballException{}
    public void event() throws BaseballException{}
    public abstract  void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}


public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut, BaseballException {
            super();
    }
    public StormyInning(String s) throws Foul, BaseballException {}
//    void walk() throws PopFoul {} //父类方法没有抛出异常的话子类方法也不能抛出异常
//    public void event() throws RainedOut {} //接口声明中没有抛出异常的话，实现方法中也不能抛出异常
    public void rainHard() throws RainedOut {}
    public void event(){} //子类方法可以不抛出任何异常，即便父类方法中抛出了异常
    public void atBat() throws PopFoul {} //重写的方法可以抛出父类方法异常的子类异常

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        }catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch(Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
