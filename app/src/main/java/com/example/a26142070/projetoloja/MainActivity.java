package com.example.a26142070.projetoloja;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText pesquisa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesquisa = findViewById(R.id.PE);
    }
    public void Pesquisar(View v){
        String pesq = pesquisa.getText().toString();
        Intent encaminhar = new Intent(getApplicationContext(), PASX.class);
        encaminhar.putExtra("parafuzo", pesq);
        startActivity(encaminhar);
    }
}
