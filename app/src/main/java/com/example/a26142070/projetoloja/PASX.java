package com.example.a26142070.projetoloja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.firebase.database.*;

import java.util.ArrayList;

public class PASX extends AppCompatActivity {
     private DatabaseReference reference;
    Bundle dados;
    private ListView valores;
    Parafuzo us = new Parafuzo();
    ArrayList<Parafuzo> listaResultado = new ArrayList<Parafuzo>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasx);
       valores = findViewById(R.id.lista1);
        dados = getIntent().getExtras();
        String modelo = dados.getString("parafuzo");
        reference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference parafuzo = reference.child("parafuzos");
        //Log.i("INFO", modelo);
        Query usPesquisa = parafuzo.orderByChild("descricao").startAt(modelo);
        usPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    us = child.getValue(Parafuzo.class);
                    listaResultado.add(us);
                    //Log.i("INFO", us.getDescricao());

                }
                //Log.i("INFO", us.getTamanho());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ArrayAdapter<Parafuzo> adapter = new ArrayAdapter<Parafuzo>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1, listaResultado);
        valores.setAdapter(adapter);
    }
}
