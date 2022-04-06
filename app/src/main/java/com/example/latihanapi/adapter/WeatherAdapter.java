package com.example.latihanapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.latihanapi.R;
import com.example.latihanapi.model.Main;
import com.example.latihanapi.model.Weather;

public class WeatherAdapter {

    private Context context;
    private Main main;
    private Weather weather;

    public WeatherAdapter(Context context, Main main, Weather weather) {
        this.context = context;
        this.main = main;
        this.weather = weather;

    }


    @NonNull
    @Override
    public WeatherAdapter.WeatherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_main,parent,false);
        return new WeatherAdapter.WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherHolder holder, int position) {
        holder.txtTemperatur.setText(String.valueOf(weather.getMain().getTemp()));
        holder.txtHumidity.setText(weather.getMain().getHumidity());
        holder.txtDescription.setText(weather.getWeather().get(position).getDescription());
        Glide.with(context).load(weather.getWeather().get(position)).into(holder.imageIcon);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class WeatherHolder extends RecyclerView.ViewHolder{

        ImageView imageIcon;
        TextView txtDescription,txtTemperatur,txtHumidity;
        Button btnSearch;


        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            imageIcon = itemView.findViewById(R.id.imageIcon);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTemperatur = itemView.findViewById(R.id.txtTemperatur);
            txtHumidity = itemView.findViewById(R.id.txtHumidity);
            btnSearch = itemView.findViewById(R.id.btnSearch);
        }
    }

}
