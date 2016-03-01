package com.example.nikhiltr.swahgaura_parivar;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
/**
 * Created by NIKHIL TR on 1/26/2016.
 */
public interface SCService {
    @GET("/tracks?client_id=" + Config.CLIENT_ID)
    public void getRecentTracks(@Query("created_at[from]") String date, Callback<List<Track>> cb);


}
