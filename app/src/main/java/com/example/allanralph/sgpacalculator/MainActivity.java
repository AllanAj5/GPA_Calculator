package com.example.allanralph.sgpacalculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    /***
     *
     */
    EditText e1, e2, e3, e4, e5;
    Button b1, re;
    TextView aa, bb, cc, dd, ee, ff, gg;
    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.ds);
        e2 = (EditText) findViewById(R.id.db);
        e3 = (EditText) findViewById(R.id.os);
        e4 = (EditText) findViewById(R.id.sw);
        e5 = (EditText) findViewById(R.id.cp);


                b1 = (Button) findViewById(R.id.but);
        re = (Button) findViewById(R.id.reset);


        aa = (TextView) findViewById(R.id.ds1);
        bb = (TextView) findViewById(R.id.ds2);
        cc = (TextView) findViewById(R.id.ds3);
        dd = (TextView) findViewById(R.id.ds4);
        ee = (TextView) findViewById(R.id.ds5);
        ff = (TextView) findViewById(R.id.result);
        gg = (TextView) findViewById(R.id.fail);
        //Registering View Components
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gg.setText("");
                ff.setText("");
                aa.setText("");
                bb.setText("");
                cc.setText("");
                dd.setText("");
                ee.setText("");
                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");

            }
        });
        //For custom toast we are inflating our screen with an image object
        LayoutInflater lf = getLayoutInflater();

        final View uv = lf.inflate(R.layout.pik,(ViewGroup) findViewById(R.id.happ));


        final View vv = lf.inflate(R.layout.activity_main,
                (ViewGroup) findViewById(R.id.ssad));


        //to generate the sgpa registernig for submit button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*the mthod i used to follow previously

                 String str=e1.getText().toString();
                 int x=Integer.parseInt(str);

                instead in one line u get the input object convernted to integer type
                 */
                int a = new Integer(e1.getText().toString()).intValue();

                int b = Integer.parseInt(e2.getText().toString());
                int c = Integer.parseInt(e3.getText().toString());
                int d = Integer.parseInt(e4.getText().toString());
                int e = Integer.parseInt(e5.getText().toString());
                // if()

                //getting grade for each subject
                String aaa = check(a);
                String bbb = check(b);
                String ccc = check(c);
                String ddd = check(d);
                String eee = check(e);

                if (aaa.equals("F") || bbb.equals("F") || ccc.equals("F") || ddd.equals("F") || eee.equals("F")) {
                    gg.setText("Reapperance required");
                    Toast t = new Toast(getApplicationContext());

                    t.setDuration(Toast.LENGTH_LONG);
                    t.setView(vv);
                    t.show();

                } else {
                    ff.setText("Congratulations !! you have cleared all papers ");
                    Toast tt = new Toast(getApplicationContext());
                    tt.setDuration(Toast.LENGTH_LONG);
                    tt.setView(uv);
                    tt.show();
                }

                //setting the obtained grades in TextView
                aa.setText(aaa);
                bb.setText(bbb);
                cc.setText(ccc);
                dd.setText(ddd);
                ee.setText(eee);

                //calculating the sgpa
                calc(aaa);
                calc(bbb);
                calc(ccc);
                calc(ddd);
                calc(eee);
                double mark = (double) grade / 5;
                final double show = mark;

                Toast.makeText(getApplicationContext(), "Your SGPA is : " + show, Toast.LENGTH_LONG).show();

                //Toast.makeText(getApplicationContext(), "Your SGPA is : " + show, Toast.LENGTH_LONG).show();

                grade = 0;


            }

            String check(int n) {
                if (n >= 90 && n <= 100) {
                    return "O";
                }
                if (n >= 80 && n <= 89) {
                    return "S";
                }
                if (n >= 70 && n <= 79) {
                    return "A";
                }
                if (n >= 60 && n <= 69) {
                    return "B";
                }
                if (n >= 50 && n <= 59) {
                    return "C";
                }
                if (n >= 40 && n <= 49) {
                    return "D";
                }
                if (n < 40) {
                    return "F";
                }
                return "M";
            }

            int calc(String z) {
                if (z.equals("O")) {
                    grade += 10;
                }
                if (z.equals("S")) {
                    grade += 9;
                }
                if (z.equals("A")) {
                    grade += 8;
                }
                if (z.equals("B")) {
                    grade += 7;
                }
                if (z.equals("C")) {
                    grade += 6;
                }
                if (z.equals("D")) {
                    grade += 5;
                }
                if (z.equals("F")) {
                    grade += 4;
                }
                return grade;
            }
        });


    }

}