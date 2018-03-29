package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    private EditText completeText;

    private Button register, cancel;

    private RegisterButton registerClick = new RegisterButton();
    private class RegisterButton implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String youPressed = "";
            switch(view.getId()) {
                case R.id.register:
                    youPressed = "Register";
                    break;
                case R.id.cancel:
                    youPressed = "Cancel";
                    break;
            }

//            Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var01.intent.action.PracticalTest01Var01SecondaryActivity");
//            intent.putExtra("ro.pub.cs.systems.eim.practicaltest01var01.coordinatesText", coordinatesText.getText());
//            startActivityForResult(intent, 666);

            Intent intent = new Intent();
            intent.putExtra("RESULT_STRING", youPressed);
            setResult(RESULT_OK, intent);

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        completeText = findViewById(R.id.instructions);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        register.setOnClickListener(registerClick);
        cancel.setOnClickListener(registerClick);


        Intent intent = getIntent();
        if (intent != null) {
            String directions = intent.getStringExtra("ro.pub.cs.systems.eim.practicaltest01var01.coordinatesText");
            if (directions != null) {
                completeText.setText(directions);
            }
        }
    }

}
