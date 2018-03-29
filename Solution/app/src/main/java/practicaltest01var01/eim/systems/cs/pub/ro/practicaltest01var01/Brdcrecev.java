package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

/**
 * Created by student on 29.03.2018.
 */

public class Brdcrecev extends BroadcastReceiver {

    private TextView messageTextView;

    public Brdcrecev() {
        this.messageTextView = null;
    }

    public Brdcrecev(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals("DATE_ACTION")) {
            messageTextView.setText("I HAVE RECEIVED THE DATE! " + intent.getStringExtra("DATE"));
        }
    }

}

