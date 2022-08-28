package com.example.calculadorabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText valor1;
    EditText valor2;
    TextView campoResultado;
    boolean verificaDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        campoResultado = findViewById(R.id.resultado);

    }

    Operacoes operacoes = new Operacoes();

    public void botaoSoma(View v){
        verificaDados = dadosVerificados();
        if(verificaDados){
            double num1 = Double.valueOf(valor1.getText().toString());
            double num2 = Double.valueOf(valor2.getText().toString());
            //double resultadoSoma = operacoes.soma(num1,num2);
            System.out.println(operacoes.soma(num1,num2));
            campoResultado.setText(""+operacoes.soma(num1,num2));
        }
    }

    public void botaoSub(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            double num1 = Double.valueOf(valor1.getText().toString());
            double num2 = Double.valueOf(valor2.getText().toString());
            System.out.println(operacoes.subtracao(num1, num2));
            campoResultado.setText("" + operacoes.subtracao(num1, num2));
        }
    }

    public void botaoMult(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            double num1 = Double.valueOf(valor1.getText().toString());
            double num2 = Double.valueOf(valor2.getText().toString());
            System.out.println(operacoes.multiplicacao(num1, num2));
            campoResultado.setText("" + operacoes.multiplicacao(num1, num2));
        }
    }

    public void botaoDiv(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            double num1 = Double.valueOf(valor1.getText().toString());
            double num2 = Double.valueOf(valor2.getText().toString());
            double resultadoDiv = operacoes.divisao(num1, num2);
            System.out.println(resultadoDiv);
            campoResultado.setText(Double.toString(resultadoDiv));
        }
    }

    public void botaoExpo(View v) {
        verificaDados = dadosVerificados();
        if(verificaDados){
            double num1 = Double.valueOf(valor1.getText().toString());
            double num2 = Double.valueOf(valor2.getText().toString());
            double resultadoExpo = operacoes.exponenciacao(num1, num2);
            System.out.println(resultadoExpo);
            campoResultado.setText("" + resultadoExpo);
        }
    }

    private boolean dadosVerificados() {

        boolean retorno;

        if (!TextUtils.isEmpty(valor1.getText().toString()) && !TextUtils.isEmpty(valor2.getText().toString())) {
            retorno = true;
        }
        else if(TextUtils.isEmpty(valor1.getText().toString()) && TextUtils.isEmpty(valor2.getText().toString())){
            valor1.setError("*");
            valor1.requestFocus();
            valor2.setError("*");
            retorno = false;
        }
        else if(TextUtils.isEmpty(valor1.getText().toString())){
            valor1.setError("*");
            valor1.requestFocus();
            retorno = false;
        }else{
            valor2.setError("*");
            valor2.requestFocus();
            retorno = false;
        }

        return retorno;
    }

}
