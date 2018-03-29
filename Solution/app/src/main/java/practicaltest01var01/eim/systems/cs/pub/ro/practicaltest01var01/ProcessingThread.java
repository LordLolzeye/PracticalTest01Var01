package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Context;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProcessingThread extends Thread {

    private Context context;
    private String coordinates;

    public ProcessingThread(Context context, String coordinates) {
        this.context = context;
        this.coordinates = coordinates;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        while (true) {
            Date c = Calendar.getInstance().getTime();

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c);

            sendMessage(formattedDate);
            sleep();
        }
    }

    private void sendMessage(String messageType) {
        Intent intent = new Intent();
        intent.setAction("DATE_ACTION");
        intent.putExtra("DATE", messageType);
        intent.putExtra("COORDINATES", coordinates);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

}