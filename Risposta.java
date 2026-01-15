import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Risposta extends Thread {
    private DatagramSocket s;
    private DatagramPacket p;
    private byte[] buffer;
    private int porta;//porta del client
    private InetAddress ip;//indirizzo del client
    public Risposta(DatagramPacket p,DatagramSocket s) {
        this.p = p;
        this.s=s;
    }
    public void run() {
        //Apro il pacchetto e recupero:
        //i Dati
        String msg=new String(p.getData(),p.getOffset(),p.getLength());
        //la porta del client
        porta=p.getPort();
        //l'ip del client
        ip=p.getAddress();
        String m=msg.toUpperCase();
        switch (m){
            case "DATA" :
                msg=new Date().toString();
                break;
                case "STOP" :
                    msg="Server in chiusura";
                    break;
                    default:
                        msg="messaggio ricevuto: "+msg;
                        break;
        }
        //trasformo la stringa in un array di byte
        buffer=msg.getBytes();
        //creo pacchetto per la risposta
        p=new DatagramPacket(buffer,buffer.length,ip,porta);
        //invio risposta
        try {
            s.send(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
