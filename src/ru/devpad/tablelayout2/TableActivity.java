package ru.devpad.tablelayout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class TableActivity extends Activity {
    private TableLayout table;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.table_ex3);

        setTitle("Example #3 - программное добавление строк");

        Button buttonAdd = (Button) findViewById(R.id.add_button);
        table = (TableLayout) findViewById(R.id.table);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText addUser = (EditText) findViewById(R.id.add_user);
                EditText addPoint = (EditText) findViewById(R.id.add_point);

                String addUserValue = addUser.getText().toString();
                String addPointValue = addPoint.getText().toString();

                if (addUserValue.equals("") || addPointValue.equals("")) {
                    Toast.makeText(getApplicationContext(), "Не заполнены все поля!", Toast.LENGTH_SHORT).show();
                } else {
                    TextView textUser = new TextView(getApplicationContext());
                    textUser.setGravity(Gravity.CENTER_HORIZONTAL);
                    textUser.setTextColor(0xff000000);
                    textUser.setText(addUserValue);

                    TextView textPoint = new TextView(getApplicationContext());
                    textPoint.setGravity(Gravity.CENTER_HORIZONTAL);
                    textPoint.setTextColor(0xff000000);
                    textPoint.setText(addPointValue);

                    TableRow row = new TableRow(getApplicationContext());
                    row.addView(textUser);
                    row.addView(textPoint);

                    addUser.setText("");
                    addPoint.setText("");

                    table.addView(row);
                }
            }
        });
    }
}