package com.example.covidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.models.DoubleStat;

import java.util.List;

public class DoubleStatAdapter extends RecyclerView.Adapter<DoubleStatAdapter.Viewholder>{

    Context context;
    List<DoubleStat> stats;

    public DoubleStatAdapter(Context context, List<DoubleStat> stats) {
        this.context = context;
        this.stats = stats;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_double_stat, parent, false);
        return new Viewholder(view);
    }

    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        //Get the data at position
        DoubleStat stat = stats.get(position);
        //Bind the tweet with viewholder
        holder.bind(stat);
    }

    //clean all elements of the recycler
    public void clear(){
        stats.clear();
        notifyDataSetChanged();
    }

    //add a list of items
    public void addAll(List<DoubleStat> tweetList){
        stats.addAll(tweetList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stats.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tvStatTitle1;
        TextView tvStatTitle2;
        TextView tvStat1;
        TextView tvStat2;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvStatTitle1 = itemView.findViewById(R.id.tvStatTitle1);
            tvStatTitle2 = itemView.findViewById(R.id.tvStatTitle2);
            tvStat1 = itemView.findViewById(R.id.tvStat1);
            tvStat2 = itemView.findViewById(R.id.tvStat2);
        }

        public void bind(DoubleStat stat){
            tvStatTitle1.setText(stat.statTitle1);
            tvStatTitle2.setText(stat.statTitle2);
            tvStat1.setText(stat.stat1);
            tvStat2.setText(stat.stat2);
        }

    }
}
