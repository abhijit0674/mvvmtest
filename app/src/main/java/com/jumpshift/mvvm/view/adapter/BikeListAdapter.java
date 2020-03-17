package com.jumpshift.mvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jumpshift.mvvm.R;
import com.jumpshift.mvvm.model.NetworkModel;

import java.util.ArrayList;
import java.util.List;

public class BikeListAdapter extends RecyclerView.Adapter<BikeListAdapter.MyViewHolder>
        implements Filterable {

    private Context context;
    private List<NetworkModel> networkModels;
    private List<NetworkModel> mFilteredList;

    public BikeListAdapter(Context context, List<NetworkModel> networks) {
        this.context = context;
        this.networkModels = networks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvBikeName.setText(networkModels.get(position).getName());
        holder.tvBikeCity.setText(networkModels.get(position).getLocation().getCity());
        holder.tvBikeCountry.setText(networkModels.get(position).getLocation().getCountry());
        holder.tvBikeLocation.setText(" ( " + networkModels.get(position).getLocation().getLatitude()
                + ", " + networkModels.get(position).getLocation().getLongitude() + " ) ");
    }

    @Override
    public int getItemCount() {
        return networkModels.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = networkModels;
                } else {

                    ArrayList<NetworkModel> filteredList = new ArrayList<>();

                    for (NetworkModel androidVersion : networkModels) {

                        if (androidVersion.getName().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<NetworkModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvBikeName;
        private TextView tvBikeCity;
        private TextView tvBikeCountry;
        private TextView tvBikeLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBikeName = itemView.findViewById(R.id.tvBikeName);
            tvBikeCity = itemView.findViewById(R.id.tvBikeCity);
            tvBikeCountry = itemView.findViewById(R.id.tvBikeCountry);
            tvBikeLocation = itemView.findViewById(R.id.tvBikeLocation);
        }
    }
}
