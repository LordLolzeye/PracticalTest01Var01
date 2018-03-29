package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var01Service extends Service {

    public PracticalTest01Var01Service() {
    }

    @Override
    public void onCreate() {
        Log.d("[TAG-SS]", "Started service");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ProcessingThread processingThread = new ProcessingThread(this, intent.getStringExtra("COORDINATES"));
        processingThread.start();

        Log.d("[TAG-SS]", "Started service");

        return START_REDELIVER_INTENT;
    }
}
