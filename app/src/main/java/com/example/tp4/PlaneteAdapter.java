package com.example.tp4;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp4.databinding.PlaneteBinding;

import java.util.List;

public class PlaneteAdapter extends RecyclerView.Adapter<PlaneteViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }

    private final List<Planete> liste;

    PlaneteAdapter(List<Planete> liste) {
        this.liste = liste;
    }



    @NonNull
    @Override
    public PlaneteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PlaneteBinding binding = PlaneteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlaneteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(PlaneteViewHolder holder, int position) {
        Planete planete = liste.get(position);
        holder.setPlanete(planete);
        holder.setOnItemClickListener(this.listener);

    }

    @Override
    public int getItemCount() {
        return liste.size();
    }
}
