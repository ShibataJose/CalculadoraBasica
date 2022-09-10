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
    double num1, num2;

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
            recebeNumeros();
            verificaInteiros(operacoes.soma(num1,num2), operacoes.soma(num1,num2));
        }
    }

    public void botaoSub(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            recebeNumeros();
            verificaInteiros(operacoes.subtracao(num1,num2), operacoes.subtracao(num1,num2));
        }
    }

    public void botaoMult(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            recebeNumeros();
            verificaInteiros(operacoes.multiplicacao(num1,num2), operacoes.multiplicacao(num1,num2));
        }
    }

    public void botaoDiv(View v){
        verificaDados = dadosVerificados();
        if(verificaDados) {
            recebeNumeros();
            verificaInteiros(operacoes.divisao(num1,num2), operacoes.divisao(num1,num2));
        }
    }

    public void botaoExpo(View v) {
        verificaDados = dadosVerificados();
        if(verificaDados){
            recebeNumeros();
            verificaInteiros(operacoes.exponenciacao(num1,num2), operacoes.exponenciacao(num1,num2));
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

    public boolean verificaInteiros(double resultado, double resultado2){

        boolean retorno;

        if(resultado%1==0){
            int convNum = (int)resultado;
            campoResultado.setText(""+convNum);
            retorno = true;
        }else {
            campoResultado.setText("" + resultado2);
            retorno = false;
        }
        return retorno;
    }

    public void recebeNumeros(){
        num1 = Double.valueOf(valor1.getText().toString());
        num2 = Double.valueOf(valor2.getText().toString());
    }
}