package com.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
  private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        Retrofit retrofit = new Retrofit.Builder()
                                         .baseUrl(Constant.BASE_URL_WEATHER)
                                         .addConverterFactory(GsonConverterFactory.create())
                                         .build();
        MyServe myServe = retrofit.create(MyServe.class);
        Call<WeatherModel> call = myServe.getWeather();
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response.isSuccessful()){
                     textView.setText(response.body().getResult().toString());
                    Toast.makeText(MainActivity.this,"aaaaaa",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });

    }
}
