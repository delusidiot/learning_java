package creational_patterns.factory_method.after;

/**
 * author       : delusidiot
 * date         : 2022-07-10
 * Client 코드가 변경되긴한다. 구체적인 Factory Class 를 알아야한다. 하지만 여기서 중요한 것은 기존 제품을 확장할때 변경이 없다는 것이다.
 * 그래서 보통은 이런것들을 의존성 주입하는 방법으로 Client 코드도 최대한 변경되지 않는 선에서 확장할 수 있다.
 *
 */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();


//        Ship whiteship = new WhiteShipFactory().orderShip("whiteship", "test@gmail.com");
//        System.out.println("whiteship = " + whiteship);
//
//        Ship blackship = new BlackShipFactory().orderShip("blackship", "test@gmail.com");
//        System.out.println("blackship = " + blackship);

        client.print(new WhiteShipFactory(), "whiteship", "test@gmail.com");
        client.print(new BlackShipFactory(), "blackship", "test@gmail.com");
    }

    /**
     * 해당 메소드를 따로 class 로 빼 놓는다면 위 main 에서 구체적인 Factory class 로 의존성을 주입한다고 볼 수 있다.
     * 이런식으로 Client 코드도 최소화할 수 있다.
     * @param shipFactory factory
     * @param name ship name
     * @param email user email
     */
    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
