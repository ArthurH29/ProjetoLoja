package com.example.a26142070.projetoloja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.firebase.database.*;

public class PASX extends AppCompatActivity {
     private DatabaseReference reference;
    Bundle dados;
    private TextView par;
    Parafuzo us = new Parafuzo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasx);
        par = findViewById(R.id.PA);
        dados = getIntent().getExtras();
        String modelo = dados.getString("parafuzo");
        reference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference parafuzo = reference.child("parafuzos");
        Query usPesquisa = parafuzo.orderByChild("descricao").equalTo(modelo);
        usPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                us = dataSnapshot.getValue(Parafuzo.class);
                Log.i("INFO", us.getDescricao());
                Log.i("INFO", us.getTamanho());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        par.setText(us.getDescricao());
    }
}
