package com.example.android.storexyz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {

    private EditText canti;
    private TextView valorUnidad;
    private TextView valorTotal;
    private Spinner comboSexo;
    private Spinner comboTipoZ;
    private Spinner comboMarca;
    private  String[] sexoComprador;
    private ArrayAdapter adapterSexo;
    private  String[] tipoComprador;
    private ArrayAdapter adapterTipo;
    private  String[] marcaComprador;
    private ArrayAdapter adapterMarca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        canti = (EditText)findViewById(R.id.txtCantidad);
        comboSexo = (Spinner)findViewById(R.id.cboSexo);
        valorTotal = (TextView)findViewById(R.id.txtTotCompra);
        valorUnidad = (TextView)findViewById(R.id.txtTunidad);
        comboTipoZ = (Spinner)findViewById(R.id.cboTipoZapato);
        comboMarca = (Spinner)findViewById(R.id.cboMarca);

        sexoComprador =this.getResources().getStringArray(R.array.sexo_comprador);
        adapterSexo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,sexoComprador);
        comboSexo.setAdapter(adapterSexo);

        tipoComprador =this.getResources().getStringArray(R.array.tipo_zapato);
        adapterTipo = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tipoComprador);
        comboTipoZ.setAdapter(adapterTipo);

        marcaComprador =this.getResources().getStringArray(R.array.marca_zapato);
        adapterMarca = new ArrayAdapter(this,android.R.layout.simple_list_item_1,marcaComprador);
        comboMarca.setAdapter(adapterMarca);

    }


    public void calcular (View v){



        int op1, op2, op3, cant, res=0,uni=0;
        int nikeZ1=120000, adidasZ1=140000, pumaZ1=130000, nikeZ2=100000, adidasZ2=130000, pumaZ2=110000;
        int nikeC1=50000, adidasC1=80000, pumaC1=100000, nikeC2=60000, adidasC2=70000, pumaC2=120000;

        if (validar()) {

            cant = Integer.parseInt(canti.getText().toString());

            op1 = comboSexo.getSelectedItemPosition();
            op2 = comboTipoZ.getSelectedItemPosition();
            op3 = comboMarca.getSelectedItemPosition();


            switch (op1) {

                case 0:

                    switch (op2) {

                        case 0:

                            switch (op3) {

                                case 0:
                                    res = cant * nikeZ1;
                                    uni = cant;
                                    break;
                                case 1:
                                    res = cant * adidasZ1;
                                    uni = cant;
                                    break;
                                case 2:
                                    res = cant * pumaZ1;
                                    uni = cant;
                                    break;


                            }
                            break;
                        case 1:

                            switch (op3) {

                                case 0:
                                    res = cant * nikeC1;
                                    uni = cant;
                                    break;
                                case 1:
                                    res = cant * adidasC1;
                                    uni = cant;
                                    break;
                                case 2:
                                    res = cant * pumaC1;
                                    uni = cant;
                                    break;
                            }
                            break;

                    }
                    break;

                case 1:

                    switch (op2) {

                        case 0:

                            switch (op3) {

                                case 0:
                                    res = cant * nikeZ2;
                                    uni = cant;
                                    break;
                                case 1:
                                    res = cant * adidasZ2;
                                    uni = cant;
                                    break;
                                case 2:
                                    res = cant * pumaZ2;
                                    uni = cant;
                                    break;


                            }
                            break;
                        case 1:

                            switch (op3) {

                                case 0:
                                    res = cant * nikeC2;
                                    uni = nikeC2/cant;
                                    break;
                                case 1:
                                    res = cant * adidasC2;
                                    uni = adidasC2/cant;
                                    break;
                                case 2:
                                    res = cant * pumaC2;
                                    uni = cant;
                                    break;
                            }
                            break;

                    }

                    break;
            }
            valorTotal.setText("" + res);
            valorUnidad.setText("" + uni);
        }
    }



    public boolean validar() {

        if (canti.getText().toString().isEmpty()) {
            canti.setError(this.getResources().getString(R.string.error_c));
            canti.requestFocus();
            return false;
        }
        if (Integer.parseInt(canti.getText().toString()) == 0) {
            canti.setError(this.getResources().getString(R.string.error_cero));
            canti.requestFocus();
            return false;

        }
        return true;
    }
}
