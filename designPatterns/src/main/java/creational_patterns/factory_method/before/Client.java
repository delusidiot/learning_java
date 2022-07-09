package creational_patterns.factory_method.before;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        Ship whiteship = ShipFactory.orderShip("whiteship", "test@gmail.com");
        System.out.println("whiteship = " + whiteship);

        Ship blackship = ShipFactory.orderShip("blackship", "test@gmail.com");
        System.out.println("blackship = " + blackship);
    }
}
