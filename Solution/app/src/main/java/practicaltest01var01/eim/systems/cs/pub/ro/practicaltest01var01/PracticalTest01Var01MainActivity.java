package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private int numberOfClicks = 0;

    private CoordinateButton coordButton = new CoordinateButton();
    private class CoordinateButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String text = "";
            switch(view.getId()) {
                case R.id.button:
                        text = "north";
                    break;
                case R.id.button2:
                        text = "east";
                    break;
                case R.id.button3:
                        text = "west";
                    break;
                case R.id.button4:
                        text = "south";
                    break;
            }

            numberOfClicks++;
            coordinatesText.setText(coordinatesText.getText() + text);
        }
    }

    private Button east, west, north, south;
    private EditText coordinatesText;
//    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        east = findViewById(R.id.button2);
        west = findViewById(R.id.button3);
        south = findViewById(R.id.button4);
        north = findViewById(R.id.button);

        coordinatesText = findViewById(R.id.textView2);

        east.setOnClickListener(coordButton);
        west.setOnClickListener(coordButton);
        south.setOnClickListener(coordButton);
        north.setOnClickListener(coordButton);
    }
}
