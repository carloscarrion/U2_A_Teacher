package com.example.carlos.u2_a_teacher;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class U2_A_Teacher extends AppCompatActivity {
    EditText et1;
    CheckBox cb1;
    TextView tv1;
    Spinner sp1;
    Chronometer ch1;
    Switch sw1;
    int tempoAutodestrucion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2__a__teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        et1 = (EditText) findViewById(R.id.et1);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        tv1 = (TextView) findViewById(R.id.tv1);
        sp1 = (Spinner) findViewById(R.id.spin_provincias);
        ch1 = (Chronometer) findViewById(R.id.cronometro);
        sw1 = (Switch) findViewById(R.id.sw);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                // TODO Auto-generated method stub

                if (pos == 4)
                    Toast.makeText(getBaseContext(),
                            R.string.text_toast_no_gal, Toast.LENGTH_SHORT)
                            .show();
                else
                    Toast.makeText(getBaseContext(), R.string.text_toast_gal,
                            Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        ch1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                // TODO Auto-generated method stub

                long tempoPasado = SystemClock.elapsedRealtime()
                        - chronometer.getBase();
                int tempoSeg = (int) tempoPasado / 1000;
                if (tempoSeg == tempoAutodestrucion)
                    finish();

            }
        });

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    tempoAutodestrucion = 15;
                    ch1.setBase(SystemClock.elapsedRealtime());
                    ch1.start();

                } else {
                    ch1.setBase(SystemClock.elapsedRealtime());
                    ch1.stop();
                }
            }
        });



    }

    public void onButtonClick(View v) {
        if (cb1.isChecked())
            tv1.setText("");
        else
            // tv1.setText(tv1.getText()+" "+et1.getText());
            tv1.append(" " + et1.getText());

        et1.setText("");

    }

    public void onRbClick(View v) {

        if (v.getId() == R.id.rb_red)

            tv1.setTextColor(getResources().getColor(R.color.red));
        else
            tv1.setTextColor(getResources().getColor(R.color.blue));

    }

    public void onImageClick(View v) {
        ImageView im = (ImageView) v;
        Toast.makeText(getBaseContext(), im.getTag().toString(),
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_u2__a__teacher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
