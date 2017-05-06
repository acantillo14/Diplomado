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
        int cbsexo, cbtipo, cbmarca, cant, res=0,uni=0;
        int Hombren=120000, Hombrea=140000, Hombrep=130000;
        int Hombrecn=50000, Hombreca=80000, Hombrecp=100000;
        int Mujern=100000, Mujera=130000, Mujerp=110000;
        int Mujercn=60000, Mujerca=70000, Mujercp=120000;

        if (validar()) {

            cant = Integer.parseInt(canti.getText().toString());

            cbsexo = comboSexo.getSelectedItemPosition();
            cbtipo = comboTipoZ.getSelectedItemPosition();
            cbmarca = comboMarca.getSelectedItemPosition();


            switch (cbsexo) {

                case 0:

                    switch (cbtipo) {

                        case 0:

                            switch (cbmarca) {

                                case 0:
                                    res = cant * Hombren;
                                    uni = Hombren;
                                    break;
                                case 1:
                                    res = cant * Hombrea;
                                    uni = Hombrea;
                                    break;
                                case 2:
                                    res = cant * Hombrep;
                                    uni = Hombrep;
                                    break;


                            }
                            break;
                        case 1:

                            switch (cbmarca) {

                                case 0:
                                    res = cant * Hombrecn;
                                    uni = Hombrecn;
                                    break;
                                case 1:
                                    res = cant * Hombreca;
                                    uni = Hombreca;
                                    break;
                                case 2:
                                    res = cant * Hombrecp;
                                    uni = Hombrecp;
                                    break;
                            }
                            break;

                    }
                    break;

                case 1:

                    switch (cbtipo) {

                        case 0:

                            switch (cbmarca) {

                                case 0:
                                    res = cant * Mujern;
                                    uni = Mujern;
                                    break;
                                case 1:
                                    res = cant * Mujera;
                                    uni = Mujera;
                                    break;
                                case 2:
                                    res = cant * Mujerp;
                                    uni = Mujerp;
                                    break;


                            }
                            break;
                        case 1:

                            switch (cbmarca) {

                                case 0:
                                    res = cant * Mujercn;
                                    uni = Mujercn;
                                    break;
                                case 1:
                                    res = cant * Mujerca;
                                    uni = Mujerca;
                                    break;
                                case 2:
                                    res = cant * Mujercp;
                                    uni = Mujercp;
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

    public void borrar(View v){
        valorTotal.setText("");
        valorUnidad.setText("");
        canti.setText("");
        canti.requestFocus();
    }
}
