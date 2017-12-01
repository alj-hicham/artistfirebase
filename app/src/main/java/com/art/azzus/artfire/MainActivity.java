package com.art.azzus.artfire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
EditText editTextname;
Button buttonadd;
Spinner spinnersGenres;

DatabaseReference databaseArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextname = (EditText) findViewById(R.id.editTextname);
        buttonadd=(Button) findViewById(R.id.buttonAddartisit);
        spinnersGenres = (Spinner) findViewById(R.id.spinnergenre);
        databaseArtist= FirebaseDatabase.getInstance().getReference("artists");
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        addArtist();
            }

        });

    }
    private void addArtist(){
        String name= editTextname.getText().toString().trim();
        String genre=spinnersGenres.getSelectedItem().toString();


        if(!TextUtils.isEmpty(name)){
            String id=databaseArtist.push().getKey();
             artist Artist= new artist(id, name, genre);
            databaseArtist.child(id).setValue(Artist);
            Toast.makeText(this,"artist added" , Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this ,"you should enter a name" , Toast.LENGTH_LONG).show();
        }

    }
}
