package com.example.tp4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp4.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final Planete[] initdata = {
            new Planete("Mercure", 58, R.drawable.mercure),
            new Planete("Vénus", 108, R.drawable.venus),
            new Planete("Terre", 150, R.drawable.terre),
            new Planete("Mars", 228, R.drawable.mars),
            new Planete("Jupiter", 778, R.drawable.jupiter),
            new Planete("Saturne", 1430, R.drawable.saturne),
            new Planete("Uranus", 2870, R.drawable.uranus),
            new Planete("Neptune", 4500, R.drawable.neptune)

    };
    private List<Planete> liste;
    //private ArrayList<Planete> liste;
    private ActivityMainBinding ui;

    private PlaneteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());

        liste = new ArrayList<>(Arrays.asList(initdata));

        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        ui.recycler.setLayoutManager(lm);

        //LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        //ui.recycler.setLayoutManager(lm);

        //GridLayoutManager lm = new GridLayoutManager(this, 2);
        //ui.recycler.setLayoutManager(lm);

        //StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        //ui.recycler.setLayoutManager(lm);

        ui.recycler.setHasFixedSize(true);

        // Adaptateur
        adapter = new PlaneteAdapter(liste);
        ui.recycler.setAdapter(adapter);

        // Separateur
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ui.recycler.addItemDecoration(dividerItemDecoration);

        //écouteur pour les clics
        adapter.setOnItemClickListener(this::onItemClick);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ouvrir la troisième activité
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }

    private void onItemClick(int position) {
        Planete planete = liste.get(position);
        Intent intent = new Intent( this, DetailActivity.class);
        String nom = planete.getNom();
        int distance = planete.getDistance();
        int image = planete.getImage();
        intent.putExtra("name", nom);
        intent.putExtra("dist", distance);
        intent.putExtra("img", image);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // Récupérer la nouvelle planète de l'Intent de retour
                Planete nouvellePlanete = (Planete) data.getSerializableExtra("nouvelle_planete");

                // Ajouter la nouvelle planète à la liste et notifier l'adaptateur
                liste.add(nouvellePlanete);
                adapter.notifyDataSetChanged();
            }
        }
    }


}