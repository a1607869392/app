package com.coolweather.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coolweather.myapplication.R;
import com.coolweather.myapplication.adapter.FutureWeatherAdapter;
import com.coolweather.myapplication.bean.DayWeatherBean;
import com.coolweather.myapplication.bean.WeatherBean;

import com.coolweather.myapplication.util.NetUtil;
import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String>mSpAdapter;
    private String[] mCities;
    private TextView tvWeather,tvTem,tvTemLowHigh,tvWin,tvAir;

    private RecyclerView rlvFutureWeather;
   private FutureWeatherAdapter mWeatherAdapter;
    private DayWeatherBean todayWeather;
    private Handler mHandler=new Handler(Looper.myLooper()){
       @Override
       public void handleMessage(@NonNull Message msg) {
           super.handleMessage(msg);
           if (msg.what == 0) {
               String weather = (String) msg.obj;

               //记录主线程收没收到
               Log.d("fan", "-----主线程收到了数据------" + weather);


               try {
                   Gson gson = new Gson();
                   WeatherBean weatherBean = gson.fromJson(weather, WeatherBean.class);


                   if (weatherBean != null) {
                       Log.d("fan", "--解析后的数据-weather---" + weatherBean.toString());
                   }

                   updateUiOfWeather(weatherBean);

                   Toast.makeText(MainActivity.this, "更新天气~", Toast.LENGTH_SHORT).show();

               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
   };

    private void updateUiOfWeather(WeatherBean weatherBean) {
        if(weatherBean==null){
            return;
        }
        List<DayWeatherBean>dayWeathers=weatherBean.getDayWeathers();
        todayWeather=dayWeathers.get(0);


        if (todayWeather==null){
            Toast.makeText(MainActivity.this, "获取今日天气失败！", Toast.LENGTH_SHORT).show();
            return;
        }

        tvTem.setText(todayWeather.getTem()+"℃");
        tvWeather.setText(todayWeather.getWea()+","+todayWeather.getDay());
        tvTemLowHigh.setText(todayWeather.getTem2() +"~"+todayWeather.getTem1()+"℃");
        tvWin.setText("风力"+todayWeather.getWinSpeed());
        tvAir.setText("空气"+todayWeather.getAirLevel()+"\n"+todayWeather.getAirTips());
        dayWeathers.remove(0);
        //未来
        mWeatherAdapter=new FutureWeatherAdapter( this, dayWeathers);
        rlvFutureWeather.setAdapter(mWeatherAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rlvFutureWeather.setLayoutManager(layoutManager);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();

    }

    private void initEvent() {
    }

    private void initView() {
        mSpinner=findViewById(R.id.sp_city);
        mCities=getResources().getStringArray(R.array.cities);
        mSpAdapter=new ArrayAdapter<>(this,R.layout.sp_item_layout,mCities);
        mSpinner.setAdapter(mSpAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              String selectedCity=mCities[position];
              getWeatherOfCity(selectedCity);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        tvWeather=findViewById(R.id.tv_weather);
        tvAir=findViewById(R.id.tv_air);
        tvTem=findViewById(R.id.tv_tem);
        tvTemLowHigh=findViewById(R.id.tv_tem_low_high);
        tvWin=findViewById(R.id.tv_win);
         rlvFutureWeather=findViewById(R.id.rlv_future_weather);
    }

    private void getWeatherOfCity(String selectedCity) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            //请求网络
        String weatherOfCity= NetUtil.getWeatherOfCity(selectedCity);
        //传数据给主线程
            Message message=Message.obtain();
            message.what=0;
            message.obj=weatherOfCity;
            mHandler.sendMessage(message);
        }
    }).start();
    }
}