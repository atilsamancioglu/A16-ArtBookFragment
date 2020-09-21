package com.atilsamancioglu.artfrgmnt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ListFragment extends Fragment {
    ListView listView;
    ArrayList<String> nameArray;
    ArrayList<Integer> idArray;
    ArrayAdapter arrayAdapter;

    public ListFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);
        nameArray = new ArrayList<String>();
        idArray = new ArrayList<Integer>();


        arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,nameArray);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListFragmentDirections.ActionListFragmentToDetailsFragment action = ListFragmentDirections.actionListFragmentToDetailsFragment("old");
                action.setArtId(idArray.get(position));
                action.setInfo("old");
                Navigation.findNavController(view).navigate(action);

            }
        });


        getData();




    }

    public void getData() {

        try {
            SQLiteDatabase database = getActivity().openOrCreateDatabase("Arts",MODE_PRIVATE,null);

            Cursor cursor = database.rawQuery("SELECT * FROM arts", null);
            int nameIx = cursor.getColumnIndex("artname");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                nameArray.add(cursor.getString(nameIx));
                idArray.add(cursor.getInt(idIx));

            }

            arrayAdapter.notifyDataSetChanged();

            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}