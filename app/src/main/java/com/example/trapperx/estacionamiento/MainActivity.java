package com.example.trapperx.estacionamiento;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textTotal;
    EditText editEntrada, editSalida, editCosto, editFraccion;
    Button entradaOk, salidaOk, buttonCalculo;



    int h, m, h1, m1, enteros;
    private int thoras, thoras1, tminutos, tminutos1;
    double unahora, fraccion, horaent, minent, horasal, minsal, total, i,
            horaent1, horasal1, minse, minssal, mintotal, quince,
            fraccionario, j, k, fraccionario1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaOk=(Button)findViewById(R.id.entradaOk);
        editEntrada=(EditText)findViewById(R.id.editEntrada);
        entradaOk.setOnClickListener(this);
        salidaOk=(Button)findViewById(R.id.salidaOk);
        editSalida=(EditText)findViewById(R.id.editSalida);
        salidaOk.setOnClickListener(this);
        editCosto=(EditText)findViewById(R.id.editCosto);
        editFraccion=(EditText)findViewById(R.id.editFraccion);
        buttonCalculo=(Button)findViewById(R.id.buttonCalculo);
        textTotal=(TextView)findViewById(R.id.textTotal);


    }

    @Override
    public void onClick(View v) {
        if (v==entradaOk) {
            final Calendar c= Calendar.getInstance();
            thoras= c.get(Calendar.HOUR_OF_DAY);
            tminutos= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editEntrada.setText(hourOfDay+":"+minute);
                    h= hourOfDay;
                    m= minute;
                }
            },thoras,tminutos,true);

            timePickerDialog.show();
        }
        if (v==salidaOk) {
            final Calendar c= Calendar.getInstance();
            thoras1= c.get(Calendar.HOUR_OF_DAY);
            tminutos1= c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    editSalida.setText(hourOfDay+":"+minute);
                    h1= hourOfDay;
                    m1= minute;
                }
            },thoras1,tminutos1,true);
            timePickerDialog.show();
        }
        buttonCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unahora= Double.parseDouble(editCosto.getText().toString());
                fraccion= Double.parseDouble(editFraccion.getText().toString());
                horaent= h;
                minent= m;

                horasal= h1;
                minsal= m1;
                i= horasal-horaent;


                if (i>=0){
                    horaent1= horaent*60;
                    horasal1= horasal*60;
                    minent= horaent1+minent;
                    minsal= horasal1+minssal;
                    mintotal= minsal-minent;

                    quince= 15;
                    fraccionario= mintotal/quince;
                    j =mintotal%quince;



                    if (j==0){
                        if (fraccionario<=4){
                            total= unahora;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                        if (fraccionario>4){
                            fraccionario1= fraccionario-4;
                            k= fraccionario1 * fraccion;
                            total= unahora+k;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                    }


                    if (j!=0){
                        if (fraccionario<=4){
                            total= unahora;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                        if (fraccionario>4) {
                            enteros =(int) fraccionario;
                            fraccionario1= enteros-4;
                            k= fraccionario1 * fraccion;
                            total= unahora+k+fraccion;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                    }
                }


                if (i<0) {
                    horaent1= horaent*60;
                    horasal1= horasal*60;
                    minent= horaent1+minse;
                    minsal= horasal1+minssal;
                    mintotal= (minsal-minent)+1440;

                    quince= 15;
                    fraccionario= mintotal/quince;
                    j= mintotal%quince;

                    if (j==0){
                        if (fraccionario<=4){
                            total= unahora;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                        if (fraccionario>4){
                            fraccionario1= fraccionario-4;
                            k= fraccionario1 * fraccion;
                            total = unahora+k;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                    }


                    if (j!=0){
                        if (fraccionario<=4){
                            total= unahora;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }



                        if (fraccionario>4) {
                            enteros = (int) fraccionario;
                            fraccionario1= enteros-4;
                            k= fraccionario1 * fraccion;
                            total= unahora+k+fraccion;
                            textTotal.setText("*** TE TOCA PAGAR $" + total + " ***");
                        }
                    }
                }
            }
        });
    }
}
