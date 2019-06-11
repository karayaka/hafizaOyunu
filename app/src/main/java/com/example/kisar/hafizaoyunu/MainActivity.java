package com.example.kisar.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnbasla;
    EditText etisim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbasla=(Button)findViewById(R.id.btnbasla);
        etisim=(EditText)findViewById(R.id.etisim);

        btnbasla.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,kartEkrani.class);
                i.putExtra("mesaj",etisim.getText().toString());
                startActivity(i);
            }
        });
    }
}
