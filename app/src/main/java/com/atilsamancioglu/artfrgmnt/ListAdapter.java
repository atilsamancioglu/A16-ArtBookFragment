package com.atilsamancioglu.artfrgmnt;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.atilsamancioglu.artfrgmnt.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ArtHolder> {

    ArrayList<String> artList;
    ArrayList<Integer> idList;

    public ListAdapter(ArrayList<String> artList, ArrayList<Integer> idList) {
        this.artList = artList;
        this.idList = idList;
    }

    class ArtHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public ArtHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ArtHolder(binding);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ArtHolder holder, int position) {
        holder.binding.rowTextView.setText(artList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListFragmentDirections.ActionListFragmentToDetailsFragment action = ListFragmentDirections.actionListFragmentToDetailsFragment("old");
                action.setArtId(idList.get(position));
                action.setInfo("old");
                Navigation.findNavController(view).navigate(action);

            }
        });
    }


    @Override
    public int getItemCount() {
        return artList.size();
    }


}
