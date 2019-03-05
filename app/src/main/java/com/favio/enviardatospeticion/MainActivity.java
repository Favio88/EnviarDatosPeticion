package com.favio.enviardatospeticion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_enviar;
    EditText et_nombre;
    TextView tv_nombre;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_enviar=findViewById(R.id.btn_enviar);
        et_nombre=findViewById(R.id.et_nombre);
        tv_nombre=findViewById(R.id.tv_nombre);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre=et_nombre.getText().toString();
                tv_nombre.setText(nombre);

                HashMap<String, String> params = new HashMap<String, String>();
                params.put("nombre", nombre);

                Log.d("valor", params.toString());

                //JsonParser parser=new JsonParser();
                //JsonObject json=(JsonObject) parser.parse(nombre);

                //final JSONObject jsonBody = new JSONObject("{\"type\":\"example\"}");


                JsonObjectRequest peticion=new JsonObjectRequest(
                        Request.Method.GET,
                        "http://nuevo.rnrsiilge-org.mx/nombre",
                        new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {

                                    //tv_nombre.setText(response.getString("nombre"));

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                VolleyS.getInstance(MainActivity.this).getRequestQueue().add(peticion);
            }
        });

    }
}
