package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.planillaAdapter;
import com.example.myapplication.models.planilla;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    Button btnScan;
    EditText txtResultado;
    RecyclerView mRecycler;
    planillaAdapter mAdapter;
    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirestore = FirebaseFirestore.getInstance();
        mRecycler = findViewById(R.id.reclyclerView);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("planilla");
        FirestoreRecyclerOptions<planilla> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<planilla>().setQuery(query, planilla.class).build();
        mAdapter = new planillaAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);

        btnScan = findViewById(R.id.btnScan);
        txtResultado = findViewById(R.id.txtResult);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator( MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Lector - CDP");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode,  data);

        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                txtResultado.setText(result.getContents());
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);

        }
    }

}