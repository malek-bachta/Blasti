package tn.mbach.warnMe.Network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\'J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0003H\'\u00a8\u0006\n"}, d2 = {"Ltn/mbach/warnMe/Network/MoviesApi;", "", "addmovie", "Lretrofit2/Call;", "Ljava/util/HashMap;", "", "map", "showmovies", "", "Ltn/mbach/warnMe/Models/moviesss;", "app_debug"})
public abstract interface MoviesApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "api/movies/all")
    public abstract retrofit2.Call<java.util.List<tn.mbach.warnMe.Models.moviesss>> showmovies();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api/movies/add")
    public abstract retrofit2.Call<java.util.HashMap<java.lang.String, java.lang.String>> addmovie(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> map);
}