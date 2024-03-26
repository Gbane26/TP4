package com.example.tp4;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4.databinding.PlaneteBinding;

public class PlaneteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final PlaneteBinding ui;
    private PlaneteAdapter.OnItemClickListener listener;

    public void setOnItemClickListener(PlaneteAdapter.OnItemClickListener l) {
        this.listener = l;
    }
    public PlaneteViewHolder(PlaneteBinding ui) {
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        listener.onItemClick(getAdapterPosition());
    }

    public void setPlanete(Planete planete) {
        ui.nom.setText(planete.getNom());
        ui.distance.setText(Integer.toString(planete.getDistance()));
        ui.imageView.setImageResource(planete.getImage());

    }
}
