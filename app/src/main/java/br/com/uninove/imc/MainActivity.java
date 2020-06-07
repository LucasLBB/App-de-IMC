package br.com.uninove.imc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {


    EditText txtPeso;
    EditText txtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtPeso = findViewById(R.id.txtPeso);
        this.txtAltura = findViewById(R.id.txtAltura);


    }

    public void calcularIMC(View view) {
        double peso = Double.parseDouble(this.txtPeso.getText().toString());
        double altura = Double.parseDouble(this.txtAltura.getText().toString());

        double imc = getIMC(peso, altura);
        String mensagem = "";
        if (imc < 18.5) {
            mensagem ="Abaixo do Peso";
        } else if (imc < 24.9) {
            mensagem = "Peso Normal";
        } else if (imc < 29.9) {
            mensagem ="Sobrepeso";
        } else {
            mensagem ="Obesidade";
        }
        exibirMensagemSnack(mensagem);
    }

    public double getIMC(double peso, double altura){
        double imc = peso / (altura * altura);
        return imc;
    }

    public void exibirMensagemToast(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    public void exibirMensagemSnack(String mensagem){
        Snackbar.make(this.txtPeso,mensagem,Snackbar.LENGTH_LONG).show();
    }

}






























    /*
    public void exibirMensagemSnack(String mensagem){

        Snackbar.make(this.txtPeso,mensagem, BaseTransientBottomBar.LENGTH_LONG).show();
    }


    public void exibirMensagemToast(String mensagem){
        Toast.makeText(this, mensagem,Toast.LENGTH_LONG).show();

    }

    public void exibirMensagemDialogBuilder(String mensagem){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(mensagem);
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exibirMensagemSnack("Mais um usuário conformado");
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exibirMensagemToast("Mais um usuário em negação");
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Você concorda?");
        alert.show();
    }*/



