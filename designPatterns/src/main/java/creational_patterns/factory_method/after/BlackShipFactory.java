package creational_patterns.factory_method.after;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 * 변경에는 닫혀있고 확장에는 열려있다.
 * WhiteShipFactory, Factory 의 변경이 없고 BlackShipFactory 라는 새로운 class 로 확장을 할 수 있다.
 */
public class BlackShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new BlackShip();
    }
}
