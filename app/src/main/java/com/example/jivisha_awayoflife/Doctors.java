package com.example.jivisha_awayoflife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Nullable;

public class Doctors extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ParseAdapter adapter;
    private ArrayList<ParseItem> parseItems = new ArrayList<>();
    private ProgressBar progressBar;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    TextView textView;
    TextView textView2;
    EditText location;
    Button button;
    String location1;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        //DocumentReference documentReference = fStore.collection("users").document(userId);
        //documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
           // @Override
           // public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
           //     location.setText(documentSnapshot.getString("location"));
          //  }
        //});


        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ParseAdapter(parseItems, this);
        recyclerView.setAdapter(adapter);


        textView=(TextView)findViewById(R.id.text);
        textView2=(TextView)findViewById(R.id.textView2);
        location = (EditText) findViewById(R.id.location);;
        button = (Button) findViewById(R.id.button);

        city="delhi";
//        location.setText(city);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                if(location.getText().toString().equals(null))
                    city= "delhi";
                else {
                    city = location.getText().toString();
                    location.setText(city);
                }

                adapter.notifyDataSetChanged();






              }
        });

        Content content = new Content();
        content.execute();


    }

    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(Doctors.this, android.R.anim.fade_in));
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.GONE);
            progressBar.startAnimation(AnimationUtils.loadAnimation(Doctors.this, android.R.anim.fade_out));
            adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String url = "https://www.practo.com/"+city+"/ayurveda";

                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("div.listing-doctor-card");
                int size =data.size();
                        Log.d("doc", "doc: "+doc);
                Log.d("data", "data: "+data);
                Log.d("size", ""+size);
                for (int i = 0; i < size; i++) {
                    String title = data.select("div")
                            .select("h2")
                            .eq(i)
                            .text();
                    String title2 = data.select("div")
                            .select("a")
                            .eq(i)
                            .text();
                    String imgUrl = data.select("div.u-d-flex")
                            .select("img.alt")
                            .eq(i)
                            .attr("src");


                    parseItems.add(new ParseItem(imgUrl,title, title2));
                    Log.d("img: "+ imgUrl+ "items", " . title: " + title + " . title2: " + title2);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }


}

