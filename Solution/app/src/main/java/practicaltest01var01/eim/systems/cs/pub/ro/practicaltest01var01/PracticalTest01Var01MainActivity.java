package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private int numberOfClicks = 0;

    private CoordinateButton coordButton = new CoordinateButton();
    private class CoordinateButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String text = "";
            switch(view.getId()) {
                case R.id.button:
                        text = "north, ";
                    break;
                case R.id.button2:
                        text = "east, ";
                    break;
                case R.id.button3:
                        text = "west, ";
                    break;
                case R.id.button4:
                        text = "south, ";
                    break;
            }

            numberOfClicks++;

            if (numberOfClicks == 4) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("ro.pub.cs.systems.eim.practicaltest01var01", "ro.pub.cs.systems.eim.practicaltest01var01.service.PracticalTest01Var01Service"));
                startService(intent);
            }

            counter.setText(String.valueOf(numberOfClicks));

            coordinatesText.setText(coordinatesText.getText() + text);
        }
    }

    private Button east, west, north, south, secondaryActivityButton;
    private EditText coordinatesText, counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        east = findViewById(R.id.button2);
        west = findViewById(R.id.button3);
        south = findViewById(R.id.button4);
        north = findViewById(R.id.button);

        coordinatesText = findViewById(R.id.textView2);
        counter = findViewById(R.id.counter);

        east.setOnClickListener(coordButton);
        west.setOnClickListener(coordButton);
        south.setOnClickListener(coordButton);
        north.setOnClickListener(coordButton);

        secondaryActivityButton = findViewById(R.id.button_secondactivity);
        secondaryActivityButton.setOnClickListener(secondActivity);

        // TODO: exercise 8a - create an instance of the StartedServiceBroadcastReceiver broadcast receiver
        BroadcastReceiver startedServiceBroadcastReceiver = new Brdcrecev(counter);

        // TODO: exercise 8b - create an instance of an IntentFilter
        // with all available actions contained within the broadcast intents sent by the service
        IntentFilter startedServiceIntentFilter = new IntentFilter();
        startedServiceIntentFilter.addAction("DATE_ACTION");
    }

    private SecondaryActivity secondActivity = new SecondaryActivity();
    private class SecondaryActivity implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var01.intent.action.PracticalTest01Var01SecondaryActivity");
            intent.putExtra("ro.pub.cs.systems.eim.practicaltest01var01.coordinatesText", coordinatesText.getText());
            startActivityForResult(intent, 666);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case 666:
                Toast.makeText(this, "Activity has returned from the context! " + intent.getStringExtra("RESULT_STRING"), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
