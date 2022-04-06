package com.example.latihanapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }NewsApiInterface newsApiInterface = NewsApiClient.getRetrofit().create(NewsApiInterface.class);
    Call<News> call = newsApiInterface.getTopHeadLinesNewsByCountry("ca","1c28ae78470c4535b2c3fbc6853d65ce");

        call.enqueue(new Callback<News>() {
        @Override
        public void onResponse(Call<News> call, Response<News> response) {
            NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body().getArticles());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
            rvBerita.setLayoutManager(layoutManager);
            rvBerita.setAdapter(adapter);
        }

        @Override
        public void onFailure(Call<News> call, Throwable t) {
            System.out.println(t);
        }
    });

        btnSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String isi = "jakarta";
            String cari = editSearch.getText().toString();
            if (cari.isEmpty()) {
                cari = isi;
            }

            Call<News> call2 = newsApiInterface.getTopHeadLinesNewsBySearch(cari, "1c28ae78470c4535b2c3fbc6853d65ce");
            call2.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
                    NewsAdapter adapter = new NewsAdapter(MainActivity.this, response.body().getArticles());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                    rvBerita.setLayoutManager(layoutManager);
                    rvBerita.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {

                }
            });
        }
    });
