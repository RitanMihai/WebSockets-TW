
import com.example.jettyclient.Message;
import com.example.jettyclient.MessageDecoder;
import com.example.jettyclient.MessageEncoder;
import com.example.jettyclient.MessageType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.*;

@ClientEndpoint( decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class WebsocketClient {
    private final String uri="ws://localhost:8081/chat/Ritan";
    private Session session;

    public WebsocketClient(){
        try{
            WebSocketContainer container=ContainerProvider.
                    getWebSocketContainer();
            container.connectToServer(this, new URI(uri));

            Message message = new Message();
            message.setType(MessageType.CONTENT);
            message.setContent("Hello");
            this.sendMessage(message);
        }catch(Exception ex){

        }
    }

    @OnOpen
    public void onOpen(Session session) throws URISyntaxException, DeploymentException, IOException {
        this.session=session;
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println(message);
    }

    public void sendMessage(Message message){
        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException ex) {
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
}