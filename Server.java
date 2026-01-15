import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    /* Attributi del server */
    private int porta;
    private DatagramPacket p;
    private DatagramSocket s;
    private byte[] buffer;
    /* costruttore */
    public Server(int porta) {
        this.porta = porta;
        avvio();
    }
    public void avvio() {
        //inizalizzo il socket
        try {
            s=new DatagramSocket(porta);
          //ciclo di ascolto
          while (true) {
              //buffer da inserire nel pacchetto
              buffer = new byte[1024];
              //creo il paccheto in cui ricevo i dati
              p=new DatagramPacket(buffer, buffer.length);
              //Metto il socket in ascolto per la ricezione dati
              s.receive(p);
              //avvio thread di risposta
              new Risposta(p,s).start();
          }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
