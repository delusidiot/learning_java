package creational_patterns.factory_method.before;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 */
public class ShipFactory {

    public static Ship orderShip(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("ship name is empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("email is empty");
        }

        prepareFor(name);

        Ship ship = new Ship();
        ship.setName(name);
        if (name.equalsIgnoreCase("whiteship")) {
            ship.setLogo("W");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setLogo("B");
        }

        if (name.equalsIgnoreCase("whiteship")) {
            ship.setColor("white");
        } else if (name.equalsIgnoreCase("blackship")) {
            ship.setColor("black");
        }

        sendEmailTo(email, ship);

        return ship;
    }

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " is complete.");
    }

    private static void prepareFor(String name) {
        System.out.println(name + " making");
    }
}
