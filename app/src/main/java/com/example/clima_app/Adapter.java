package com.example.clima_app;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clima_app.Model.DailyForecasts;
import com.squareup.picasso.Picasso;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<DailyForecasts> listDailyForecast;


    public Adapter(List<DailyForecasts> listDailyForecast) {
        this.listDailyForecast = listDailyForecast;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.asignarDatos(listDailyForecast.get(position));
    }

    @Override
    public int getItemCount() {
        return listDailyForecast.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView fecha, maxtemp, mintemp, climadia, climanoche;
        ImageView imgclimaday, imgclimanight;
        String iconurlday, iconurlday2, iconurlnight, iconurlnight2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha);
            maxtemp = itemView.findViewById(R.id.maxtemp);
            mintemp = itemView.findViewById(R.id.mintemp);
            climadia = itemView.findViewById(R.id.climadia);
            climanoche = itemView.findViewById(R.id.climanoche);
            imgclimaday = itemView.findViewById(R.id.imgclimaday);
            imgclimanight = itemView.findViewById(R.id.imgclimanight);

        }

        public void asignarDatos(DailyForecasts dailyForecasts) {
            fecha.setText(formatDate(dailyForecasts.getFecha()));
            maxtemp.setText(farhenheitToCelcius(dailyForecasts.getTemperature().getMaximun().getValue()).toString() + " °C");
            mintemp.setText(farhenheitToCelcius(dailyForecasts.getTemperature().getMinimun().getValue()).toString() + " °C");
            climadia.setText(dailyForecasts.getDay().getIconPhrase());
            climanoche.setText(dailyForecasts.getNight().getIconPhrase());


            iconurlday = "https://developer.accuweather.com/sites/default/files/0" + dailyForecasts.getDay().getIcon() + "-s" + ".png";
            iconurlday2 = "https://developer.accuweather.com/sites/default/files/" + dailyForecasts.getDay().getIcon() + "-s" + ".png";

            iconurlnight = "https://developer.accuweather.com/sites/default/files/0" + dailyForecasts.getNight().getIcon() + "-s" + ".png";
            iconurlnight2 = "https://developer.accuweather.com/sites/default/files/" + dailyForecasts.getNight().getIcon() + "-s" + ".png";


            if (dailyForecasts.getDay().getIcon() <= 8) {
                Picasso.get().load(iconurlday).resize(50,50).into(imgclimaday);
            } else {
                Picasso.get().load(iconurlday2).resize(50,50).into(imgclimaday);
            }

            if (dailyForecasts.getNight().getIcon() <= 8) {
                Picasso.get().load(iconurlnight).resize(50,50).into(imgclimanight);
            } else {
                Picasso.get().load(iconurlnight2).resize(50,50).into(imgclimanight);
            }


            if (farhenheitToCelcius(dailyForecasts.getTemperature().getMaximun().getValue()) >= 25) {
                maxtemp.setTextColor(Color.RED);
            } else if (farhenheitToCelcius(dailyForecasts.getTemperature().getMaximun().getValue()) < 25 && (farhenheitToCelcius(dailyForecasts.getTemperature().getMaximun().getValue()) > 15)) {
                maxtemp.setTextColor(Color.GREEN);
            } else if (farhenheitToCelcius(dailyForecasts.getTemperature().getMaximun().getValue()) <= 15) {
                maxtemp.setTextColor(Color.BLUE);
            }


            if (farhenheitToCelcius(dailyForecasts.getTemperature().getMinimun().getValue()) >= 25) {
                mintemp.setTextColor(Color.RED);
            } else if (farhenheitToCelcius(dailyForecasts.getTemperature().getMinimun().getValue()) < 25 && (farhenheitToCelcius(dailyForecasts.getTemperature().getMinimun().getValue()) > 15)) {
                mintemp.setTextColor(Color.GREEN);
            } else if (farhenheitToCelcius(dailyForecasts.getTemperature().getMinimun().getValue()) <= 15) {
                mintemp.setTextColor(Color.BLUE);
            }


        }

        public String formatDate(String dateIso8060) {
            String formattedDate = "";
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
                DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime parsedDate = LocalDateTime.parse(dateIso8060, formatter);

                formattedDate = formatterOut.format(parsedDate);
            } else {
                return dateIso8060;
            }
            return formattedDate;
        }

        public Integer farhenheitToCelcius(Integer farhenheit) {
            return ((farhenheit - 32) * 5 / 9);
        }

    }
}