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
                                         .baseUrl(Constant.BASE_URL_COOK)
                                         .addConverterFactory(GsonConverterFactory.create())
                                         .build();
        MyServe myServe = retrofit.create(MyServe.class);
        Call<CookModel> call = myServe.getCook(1);
        call.enqueue(new Callback<CookModel>() {
            @Override
            public void onResponse(Call<CookModel> call, Response<CookModel> response) {
                if(response.isSuccessful()){
                     textView.setText(response.body().getResult().getData().get(1).getTitle());
                    Toast.makeText(MainActivity.this,"aaaaaa",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CookModel> call, Throwable t) {

            }
        });

    }
}
