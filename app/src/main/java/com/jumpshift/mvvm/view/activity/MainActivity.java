package com.jumpshift.mvvm.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.jumpshift.mvvm.R;
import com.jumpshift.mvvm.model.NetworkModel;
import com.jumpshift.mvvm.view.adapter.BikeListAdapter;
import com.jumpshift.mvvm.viewmodel.BikeListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BikeListViewModel bikeListViewModel;
    private RecyclerView rvBikeList;
    private BikeListAdapter bikeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bikeListViewModel = ViewModelProviders.of(this).get(BikeListViewModel.class);

        initView();

        //TODO API Call
        bikeListViewModel.setBikeListResponse();
        bikeListViewModel.getBikeListResponse().observe(this, bikeDetailsResponseModel -> {
            if (bikeDetailsResponseModel != null) {
                setUpAdapter(bikeDetailsResponseModel.getNetworks());
            }
        });
    }

    private void initView() {
        rvBikeList = findViewById(R.id.rvBikeList);
        rvBikeList.setHasFixedSize(true);
    }

    private void setUpAdapter(List<NetworkModel> networks) {
        bikeListAdapter = new BikeListAdapter(this, networks);
        rvBikeList.setAdapter(bikeListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                bikeListAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

}
