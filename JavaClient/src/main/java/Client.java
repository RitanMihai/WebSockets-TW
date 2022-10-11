import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        WebsocketClient client = new WebsocketClient();
        /* Added just to stop interrupt the process */
        new Scanner(System.in).nextLine();
    }
}
