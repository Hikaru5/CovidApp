package com.example.covidapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidapp.models.State;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.Viewholder> {

    Context context;
    List<State> states;

    public StateAdapter(Context context, List<State> states){
        this.context = context;
        this.states = states;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_state, parent, false);
        return new Viewholder(view);
    }

    //bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        //Get the data at position
        State state = states.get(position);
        //Bind the tweet with viewholder
        holder.bind(state);
        //launches new activity when state is clicked

        holder.btnStateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(), SpecificStateStatsActivity.class);

                State state = states.get(position);//passes the selected state to the new intent
                i.putExtra("state", Parcels.wrap(state));

                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    //clean all elements of the recycler
    public void clear(){
        states.clear();
        notifyDataSetChanged();
    }

    //add a list of items
    public void addAll(List<State> tweetList){
        states.addAll(tweetList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return states.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{

        TextView tvStateTitle;
        TextView tvStat1;
        TextView tvStat2;
        TextView tvStat3;
        ImageView ivStateImage;
        Button btnStateSelect;

        public Viewholder(@NonNull View itemView){
            super(itemView);
            tvStateTitle = itemView.findViewById(R.id.tvStateTitle);
            tvStat1 = itemView.findViewById(R.id.tvStateStat1);
            tvStat2 = itemView.findViewById(R.id.tvStateStat2);
            tvStat3 = itemView.findViewById(R.id.tvStateStat3);
            ivStateImage = itemView.findViewById(R.id.ivStatePicture);
            btnStateSelect = itemView.findViewById(R.id.btnStateSelect);
        }

        public void bind(State state){
            if(state.fullStateName == ""){
                tvStateTitle.setText(state.stateName);
            }else{
                tvStateTitle.setText(state.fullStateName);
            }

            tvStat1.setText("Deaths: " + state.deathCount);
            tvStat2.setText("Total Cases: " + state.infectedCount);
            tvStat3.setText("Vaccinated: " + state.fullyVaccinated);
            Context context = ivStateImage.getContext();//setting the state picture
            int id = context.getResources().getIdentifier(state.stateImage, "drawable", context.getPackageName());

            ivStateImage.setImageResource(id);

        }
    }



}
