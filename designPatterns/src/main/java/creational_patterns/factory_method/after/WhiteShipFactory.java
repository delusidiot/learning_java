package creational_patterns.factory_method.after;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class WhiteShipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
