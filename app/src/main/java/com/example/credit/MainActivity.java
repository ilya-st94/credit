package com.example.credit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private EditText suma;
    private EditText procent;
    private EditText period;
    private Button knopka;
    private Spinner spinner;
    private EditText periodoo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        suma = findViewById(R.id.summa);
        procent = findViewById(R.id.pr);
        text = findViewById(R.id.raschet);
        knopka = findViewById(R.id.button);
        period = findViewById(R.id.period);
        periodoo2 =findViewById(R.id.period2);
        spinner = findViewById(R.id.spiner);

periodoo2.setVisibility(View.INVISIBLE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int i, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.namearay);


if(2==i){
    periodoo2.setVisibility(View.VISIBLE);
    period.setVisibility(View.INVISIBLE);

    knopka.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {



            if(suma.getText().toString().equals("")==true && periodoo2.getText().toString().equals("")==true && procent.getText().toString().equals("")==true){

                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                bilder.setTitle("Ошибка!");
                bilder.setMessage("Заполните все поля");
                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                bilder.show();
            }else {
                if(suma.getText().toString().equals("")==true){
                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                    bilder.setTitle("Ошибка!");
                    bilder.setMessage("Введите число в строке сумма");
                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    bilder.show();
                }

                if(periodoo2.getText().toString().equals("")==true){
                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                    bilder.setTitle("Ошибка!");
                    bilder.setMessage("Введите число в строке дни");
                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    bilder.show();
                }
                if(procent.getText().toString().equals("")==true){
                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                    bilder.setTitle("Ошибка!");
                    bilder.setMessage("Введите число в строке %");
                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    bilder.show();
                }
            }


            if(procent.getText().toString().equals("")!=true && periodoo2.getText().toString().equals("")!=true &&  suma.getText().toString().equals("")!=true ) {

                String s1 ="", s2 = "", s3 ="";
                s1 = suma.getText().toString();
                s2 = procent.getText().toString();
                s3 = periodoo2.getText().toString();



                if(s2.contains("," ) || s2.contains("#")|| s2.contains("*") || s2.contains("-") || s2.contains("+") || s2.contains(")")|| s2.contains("(")|| s2.contains(";")|| s2.contains("/")|| s2.contains("N")||  s1.contains("," ) || s1.contains("#")|| s1.contains("*") || s1.contains("-") || s1.contains("+")|| s1.contains(")")|| s1.contains("(")|| s1.contains(";")|| s1.contains("/")|| s1.contains("N") || s3.contains("," ) || s3.contains("#")|| s3.contains("*") || s3.contains("-") || s3.contains("+")|| s3.contains(")")|| s3.contains("(")|| s3.contains(";")|| s3.contains("/")|| s3.contains("N") ){
    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
    bilder.setTitle("Ошибка!");
    bilder.setMessage("Не допустимые символы * / - + # N ; , ");
    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    });
    bilder.show();
} else  if(s2.contains(" ") || s1.contains(" ") || s3.contains(" ")){
                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                    bilder.setTitle("Ошибка!");
                    bilder.setMessage(" Пробел не допустим ");
                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    bilder.show();
                }
else{
    double a, b, c, A, k1;
    a = Double.parseDouble(s1);
    b = Double.parseDouble(s2);
    c = Double.parseDouble(s3);
    A = a + (a * (b / 365) * c) / 365;
    k1 = A / c;
    BigDecimal bd = new BigDecimal(A);
    bd = bd.setScale(7, bd.ROUND_CEILING);
    BigDecimal bd1 = new BigDecimal(k1);
    bd1 = bd1.setScale(7, bd1.ROUND_CEILING);

    text.setText("Итоговая сумма возврата " + bd + "\t" + "\t" + "\n" + "\n" + " ежедневный платеж равен " + bd1);
}

            }


            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(knopka.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        }
    });
}



            if(1==i){
                periodoo2.setVisibility(View.INVISIBLE);
                period.setVisibility(View.VISIBLE);
                knopka.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View view) {


                        if(suma.getText().toString().equals("")==true && period.getText().toString().equals("")==true && procent.getText().toString().equals("")==true){

                            AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                            bilder.setTitle("Ошибка!");
                            bilder.setMessage("Заполните все поля");
                            bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                            bilder.show();
                        }else {
                            if(suma.getText().toString().equals("")==true){
                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage("Введите число в строке сумма");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                bilder.show();
                            }
                            if(period.getText().toString().equals("")==true){
                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage("Введите число в строке месяцы");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                bilder.show();
                            }
                            if(procent.getText().toString().equals("")==true){
                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage("Введите число в строке %");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                bilder.show();
                            }

                        }



                        if(procent.getText().toString().equals("")!=true && period.getText().toString().equals("")!=true &&  suma.getText().toString().equals("")!=true ){


                            String s1 = "", s2 = "", s3 = "";
                            s1 = suma.getText().toString();
                            s2 = procent.getText().toString();
                            s3 = period.getText().toString();




                            if(s2.contains("," ) || s2.contains("#")|| s2.contains("*") || s2.contains("-") || s2.contains("+") || s2.contains(")")|| s2.contains("(")|| s2.contains(";")|| s2.contains("/")|| s2.contains("N")||  s1.contains("," ) || s1.contains("#")|| s1.contains("*") || s1.contains("-") || s1.contains("+")|| s1.contains(")")|| s1.contains("(")|| s1.contains(";")|| s1.contains("/")|| s1.contains("N") || s3.contains("," ) || s3.contains("#")|| s3.contains("*") || s3.contains("-") || s3.contains("+")|| s3.contains(")")|| s3.contains("(")|| s3.contains(";")|| s3.contains("/")|| s3.contains("N")){
                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage("Не допустимые символы * / - + # N ; , ");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                bilder.show();
                            } else if(s2.contains(" ") || s1.contains(" ") || s3.contains(" ")){
                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage(" Пробел не допустим ");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                bilder.show();
                            }else{
                                double a, b, c, A, k1, k2;

                                a = Double.parseDouble(s1);
                                b = Double.parseDouble(s2);
                                c = Double.parseDouble(s3);
                                String str = "";
                                String str1 = "";
                                String str2 ="";

                                b = b / 100;
                                int scet = 0;
                                k1 = a / c;
                                k2 = 0;
                                for (int j = 0; j < c; j++) {
                                    scet++;
                                    A = k1 + (a - (k1 * j)) * b / 12;
                                    BigDecimal bd = new BigDecimal(A);
                                    bd = bd.setScale(2, bd.ROUND_CEILING);
                                    str = str + "\n" + bd + "\t" + "\t" + "\t"  + scet + " й месяц";
                                    double AA = bd.doubleValue();
                                    k2 = k2 + AA;



                                    if(!("".equalsIgnoreCase(str.trim()))) {
                                        text.setText(str);
                                    }

                                    if (scet % 12 == 0) {

                                        BigDecimal bdd = new BigDecimal(k2);
                                        bdd = bdd.setScale(2, bdd.ROUND_CEILING);
                                        str1 = str1 + "\n" + "Сумма за " + scet/12 + " год " + "\n" + bdd;

                                        k2 = 0;

                                    }
                                    if(!("".equalsIgnoreCase(str1.trim()))) {
                                        text.append(str1);
                                    }


                                    if(scet==c){
                                        BigDecimal bdd = new BigDecimal(k2);
                                        bdd = bdd.setScale(2, bdd.ROUND_CEILING);
                                        String sss = bdd.toString();
                                        double iii = Double.parseDouble(sss);
                                        if(iii==0){

                                        }else {
                                            str2 = str2 + "\n" + "Остаточная сумма выплат " + bdd;
                                        }
                                    }

                                    if(!("".equalsIgnoreCase(str2.trim()))) {
                                        text.append(str2);
                                    }
                                }
                            }
                        }

                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(knopka.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                });
            }

                if (0==i){
                    periodoo2.setVisibility(View.INVISIBLE);
                    period.setVisibility(View.VISIBLE);
                    knopka.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if(suma.getText().toString().equals("")==true && period.getText().toString().equals("")==true && procent.getText().toString().equals("")==true){

                                AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                bilder.setTitle("Ошибка!");
                                bilder.setMessage("Заполните все поля");
                                bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                bilder.show();
                            }else {
                                if(suma.getText().toString().equals("")==true){
                                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                    bilder.setTitle("Ошибка!");
                                    bilder.setMessage("Введите число в строке сумма");
                                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    bilder.show();
                                }
                                if(period.getText().toString().equals("")==true){
                                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                    bilder.setTitle("Ошибка!");
                                    bilder.setMessage("Введите число в строке месяцы");
                                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    bilder.show();
                                }
                                if(procent.getText().toString().equals("")==true){
                                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                    bilder.setTitle("Ошибка!");
                                    bilder.setMessage("Введите число в строке %");
                                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    });
                                    bilder.show();
                                }
                            }


                            if(procent.getText().toString().equals("")!=true && period.getText().toString().equals("")!=true &&  suma.getText().toString().equals("")!=true ){

                                String s1 = "",s2 = "",s3 = "";

                                s1= suma.getText().toString();
                                s2= procent.getText().toString();
                                s3= period.getText().toString();



                                if( s2.contains("," ) || s2.contains("#")|| s2.contains("*") || s2.contains("-") || s2.contains("+") || s2.contains(")")|| s2.contains("(")|| s2.contains(";")|| s2.contains("/")|| s2.contains("N")||  s1.contains("," ) || s1.contains("#")|| s1.contains("*") || s1.contains("-") || s1.contains("+")|| s1.contains(")")|| s1.contains("(")|| s1.contains(";")|| s1.contains("/")|| s1.contains("N") || s3.contains("," ) || s3.contains("#")|| s3.contains("*") || s3.contains("-") || s3.contains("+")|| s3.contains(")")|| s3.contains("(")|| s3.contains(";")|| s3.contains("/")|| s3.contains("N")){
                                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                    bilder.setTitle("Ошибка!");
                                    bilder.setMessage("Не допустимые символы * / - + # N ; , ) (");
                                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                                    bilder.show();
                                }else if(s2.contains(" ") || s1.contains(" ") || s3.contains(" ")){
                                    AlertDialog.Builder bilder = new AlertDialog.Builder(MainActivity.this);
                                    bilder.setTitle("Ошибка!");
                                    bilder.setMessage(" Пробел не допустим ");
                                    bilder.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                        }
                                    });
                                    bilder.show();
                                }else{
                                    double a,b,c,k, b1, i,k1,k3,A, A1;

                                    a = Double.parseDouble(s1);
                                    b = Double.parseDouble(s2);
                                    c = Double.parseDouble(s3);

                                    b1 = (b/12)/100;
                                    i =(b1+1);

                                    k = Math.pow(i,c)*b1;
                                    k1 = Math.pow(i,c)-1;
                                    k3=k/k1;
                                    A=k3*a;
                                    A1 = A*c;
                                    BigDecimal bd = new BigDecimal(A);
                                    BigDecimal bd1 = new BigDecimal(A1);
                                    bd1=bd1.setScale(2,bd1.ROUND_CEILING);
                                    bd = bd.setScale(2,bd.ROUND_CEILING);
                                    text.setText("Сумма ежемесечного платежа " + bd + "\t" + "\n" + "\n" + "вся сумма выплат" + bd1);
                                }

                            }
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(knopka.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                        }
                    });
                }

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });





    }

}