package creational_patterns.factory_method.after;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 * 8이하 버전에서는 default 와 private method 를 둘수 없기때문에 abstract class 를 하나 더 만들어 구현하자.
 */
public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();

        // notify
        sendEmailTo(email, ship);
        return ship;
    }

    Ship createShip();

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("ship name is empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is empty");
        }
    }

    private void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " is complete.");
    }

    private void prepareFor(String name) {
        System.out.println(name + " making");
    }
}
