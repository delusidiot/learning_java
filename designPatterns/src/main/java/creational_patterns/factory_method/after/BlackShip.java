package creational_patterns.factory_method.after;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 * 변경에는 닫혀있고 확장에는 열려있다.
 * WhiteShip, Ship 의 변경이 없고 BlackShip이라는 새로운 class로 확장을 할 수 있다.
 */
public class BlackShip extends Ship{
    public BlackShip() {
        setName("blackship");
        setLogo("B");
        setColor("black");
    }
}
