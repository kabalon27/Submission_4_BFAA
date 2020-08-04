package com.example.mysubmission4bfaa.viewmodel.viewmodeltv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mysubmission4bfaa.model.tvmodel.ResultsItemTv;
import com.example.mysubmission4bfaa.model.tvmodel.TvShowResponse;
import com.example.mysubmission4bfaa.service.servicetvshow.TvShowService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowViewModel extends ViewModel {
    private TvShowService tvShowService;
    String language;
    private MutableLiveData<ArrayList<ResultsItemTv>> listTvShow = new MutableLiveData<>();

    public LiveData<ArrayList<ResultsItemTv>> getTvShow(){
        return listTvShow;
    }

    public void loadTvshow(String language){
        this.language = language;
        if (this.tvShowService == null){
            tvShowService = new TvShowService();
        }
        tvShowService.getTvShowApi().getTvShows(language).enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                if (response.isSuccessful()){
                    listTvShow.setValue(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {

            }
        });
    }
}
