package com.example.dell.tabbottom.Retrofit;

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
    @GET("search?part=snippet&q=eminem&type=video&key=AIzaSyBQ-JrF3Kl3Ph7CaNam_M5zeta7QKSqDjo")
    Call<Example> getMyJSON();
}
