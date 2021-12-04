package manipulation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHours {

    public static void main(String[] args) {
//        long time = (System.currentTimeMillis() - 24L * 60L * 60L * 1000L) - 33L * 60L * 60L * 1000L;
        long time = 1638442960408L - (-5L * 60L * 60L * 1000L);
        System.out.printf("imprimir: %1$s%n", time);
        SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        date.setTime(time);
        System.out.println("data: "+sfd.format(date));
        Date dateNotion = new Date();
        dateNotion.setTime(1638442960408L);
        System.out.println("verificar o timestamp: "+sfd.format(dateNotion));
        System.out.println();
    }
}
