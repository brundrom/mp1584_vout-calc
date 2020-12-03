package ru.brundrom.progdata2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText pole;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // создание LinearLayout
        LinearLayout linLayout = new LinearLayout(this);
        // установим вертикальную ориентацию
        linLayout.setOrientation(LinearLayout.VERTICAL);
        // создаем LayoutParams
        LinearLayout.LayoutParams linLayoutParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        // устанавливаем linLayout как корневой элемент экрана
        LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        tv = new TextView(this);
        tv.setText("Input needed output voltage:");
        tv.setLayoutParams(lpView);
        tv.setTag("tvHere");
        linLayout.addView(tv);

        pole = new EditText(this);
        pole.setWidth(1000);
        pole.setText("0");
        pole.setLayoutParams(lpView);
        linLayout.addView(pole);

        btn = new Button(this);
        btn.setText("Calculate");
        btn.setTag("btOK");
        btn.setOnClickListener(btnDo);
        linLayout.addView(btn, lpView);

        setContentView(linLayout, linLayoutParam);
    }

    View.OnClickListener btnDo = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            float v_out = Float.parseFloat(pole.getText().toString());
            float resistor = (float) (10.25 * (v_out - 0.8));
            String res_out = Float.toString(resistor);
            tv.setText(res_out + "kOhm and highter +vout");
        }
    };

}