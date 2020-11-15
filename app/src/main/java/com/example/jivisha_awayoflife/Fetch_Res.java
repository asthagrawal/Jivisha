package com.example.jivisha_awayoflife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fetch_Res extends AppCompatActivity {
    TextView a,b,c,d;
    Button btn;
    DatabaseReference reff;
    String DoshaName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch__res);

        a=(TextView)findViewById(R.id.Dosha);
        b=(TextView)findViewById(R.id.doshinfo);

        DoshaName = getIntent().getStringExtra("DOSHA");

        updateUI();
    }

    void updateUI() {
        a.setText(DoshaName);
        reff= FirebaseDatabase.getInstance().getReference().child("Dosha");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String doshinfo = dataSnapshot.child(DoshaName).getValue().toString();
                b.setText(doshinfo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}