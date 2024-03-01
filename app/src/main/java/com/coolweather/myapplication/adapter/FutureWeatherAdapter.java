package com.coolweather.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.myapplication.R;
import com.coolweather.myapplication.bean.DayWeatherBean;
import com.coolweather.myapplication.bean.WeatherBean;

import java.util.List;

public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.WeatherViewHolder> {
    private Context mContext;
    private List<DayWeatherBean>mWeatherBeans;

    public FutureWeatherAdapter(Context Context,List<DayWeatherBean>weatherBeans) {
        mContext = Context;
    this.mWeatherBeans=weatherBeans;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=   LayoutInflater.from(mContext).inflate(R.layout.weather_item_layout,parent,false);
     WeatherViewHolder weatherViewHolder=new WeatherViewHolder(view);

     return weatherViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
    DayWeatherBean  weatherBean= mWeatherBeans.get(position);
    holder.tvWeather.setText(weatherBean.getWea());
    holder.tvTem.setText(weatherBean.getTem()+"℃");
    holder.tvTemLowHigh.setText(weatherBean.getTem2()+"~"+weatherBean.getTem1()+"℃");
    holder.tvWin.setText("风力"+weatherBean.getWinSpeed());
    holder.tvAir.setText("空气:"+weatherBean.getAirTips()+"\n"+weatherBean.getAirLevel());
    holder.tvDate.setText(weatherBean.getDate());
    }


    @Override
    public int getItemCount()
    {
        if (mWeatherBeans==null){
        return 0;
        }
        return mWeatherBeans.size();
    }

    class  WeatherViewHolder extends  RecyclerView.ViewHolder{
        TextView tvWeather,tvTem,tvTemLowHigh,tvWin,tvAir,tvDate;
        public WeatherViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tvWeather = itemView.findViewById(R.id.tv_weather);
            tvAir = itemView.findViewById(R.id.tv_air);
            tvTem = itemView.findViewById(R.id.tv_tem);
            tvTemLowHigh = itemView.findViewById(R.id.tv_tem_low_high);
            tvWin = itemView.findViewById(R.id.tv_win);
            tvDate = itemView.findViewById(R.id.tv_date);
        }

    }
}
