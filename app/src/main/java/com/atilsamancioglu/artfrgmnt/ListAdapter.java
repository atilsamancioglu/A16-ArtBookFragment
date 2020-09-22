package com.atilsamancioglu.artfrgmnt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ArtHolder> {

    ArrayList<String> artList;
    ArrayList<Integer> idList;

    public ListAdapter(ArrayList<String> artList, ArrayList<Integer> idList) {
        this.artList = artList;
        this.idList = idList;
    }

    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View customView = layoutInflater.inflate(R.layout.recycler_row,parent,false);
        return new ArtHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtHolder holder, final int position) {
        TextView rowTextView = holder.itemView.findViewById(R.id.rowTextView);
        rowTextView.setText(artList.get(position));
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

    class ArtHolder extends RecyclerView.ViewHolder {

        public ArtHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

}
