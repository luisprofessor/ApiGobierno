package com.example.apigobierno.vistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.apigobierno.R;
import com.example.apigobierno.model.Resultado;
import com.example.apigobierno.model.Municipio;
import com.example.apigobierno.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private TextView salida;
private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configView();

    }


    private void configView(){
        salida=findViewById(R.id.salida);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getLista().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                salida.setText(s);
            }
        });
    }

    public void buscar(View v){
        mainViewModel.buscarVM();

    }

}
