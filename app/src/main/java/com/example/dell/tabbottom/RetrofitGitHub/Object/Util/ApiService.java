package com.example.dell.tabbottom.RetrofitGitHub.Object.Util;

import com.example.dell.tabbottom.Retrofit.ObjectRe.Example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Pratik Butani.
 */
public interface ApiService {

    /*
    Retrofit get annotation with our URL
    And our method that will return us the List of ContactList
    */
    @GET("users?q=nic+repos:%3E42+followers:%3E100")
    Call<com.example.dell.tabbottom.RetrofitGitHub.Object.Example> getMyJSON();
}
