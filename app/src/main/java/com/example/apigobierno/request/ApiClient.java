package com.example.apigobierno.request;

import android.util.Log;

import com.example.apigobierno.model.Resultado;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class ApiClient {

    private static final String PATH="https://apis.datos.gob.ar/georef/api/";
    private static  MyApiInterface myApiInteface;

    public static MyApiInterface getMyApiClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("mensaje",retrofit.baseUrl().toString());
        myApiInteface=retrofit.create(MyApiInterface.class);
        return myApiInteface;
    }





    public interface MyApiInterface {

        String prov="74";
        @GET("municipios?provincia="+prov)
        Call<Resultado> leer();
        //listarClientes.php
        //@GET("listarClientes.php")
        //Call<List<Cliente>> getClientes();

        //@GET("insertarClientes.php")
        //Call<Cliente> createCliente(@Query("dni") int dni, @Query("apellido") String apellido, @Query("nombre") String nombre);
    }

}
