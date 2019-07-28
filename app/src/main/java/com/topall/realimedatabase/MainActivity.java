package com.topall.realimedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit,ageEdit;
    Button pushData,retriveData;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit=findViewById(R.id.nameEdit);
        ageEdit=findViewById(R.id.ageEdit);
        pushData=findViewById(R.id.pushData);
        retriveData=findViewById(R.id.retriveData);

        databaseReference= FirebaseDatabase.getInstance().getReference("User");

        pushData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEdit.getText().toString();
                String age=ageEdit.getText().toString();
                String key=databaseReference.push().getKey();

                Users users=new Users(name,age);
                databaseReference.child(key).setValue(users);

            }
        });

        retriveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DetailsActivity.class));
            }
        });
    }
}
