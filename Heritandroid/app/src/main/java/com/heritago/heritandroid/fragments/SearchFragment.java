package com.heritago.heritandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heritago.heritandroid.R;
import com.heritago.heritandroid.adapters.HeritageAdapter;
import com.heritago.heritandroid.model.Heritage;

import java.util.ArrayList;
import java.util.List;



public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private HeritageAdapter adapter;
    private List<Heritage> heritageList = new ArrayList<>();
    private SearchView searchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

//        for (int i = 0; i < 1; i++){
//            heritageList.add(new Heritage("id","Sultanahmet Mosque","description","Suzan U."));
//        }

        adapter = new HeritageAdapter(heritageList);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        searchView = (SearchView) view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                updateCardsForSearch(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        return view;
    }

    private void updateCardsForSearch(String query){
        heritageList.clear();
        for (int i = 0; i < 10; i++){
            heritageList.add(new Heritage("id","Sultanahmet Mosque","description","Suzan U."));
        }
        adapter.notifyDataSetChanged();
    }

}




