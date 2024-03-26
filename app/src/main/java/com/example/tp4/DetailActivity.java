package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name, distances;
    ImageView image;
    Button btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        name = findViewById(R.id.nameEdit);
        distances = findViewById(R.id.distance);
        image = findViewById(R.id.imagePlanete);

        btn_close = findViewById(R.id.btn_close);

        String nomPlanete = getIntent().getStringExtra("name");
        int distancePlanete = getIntent().getIntExtra("dist", 0);
        int imagePlanete = getIntent().getIntExtra("img", 0);


        name.setText(nomPlanete);
        distances.setText(Integer.toString(distancePlanete));
        image.setImageResource(imagePlanete);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( DetailActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}