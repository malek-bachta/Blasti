package tn.mbach.warnMe.Network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\'J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Ltn/mbach/warnMe/Network/UserApi;", "", "login1", "Lretrofit2/Call;", "Lcom/google/gson/JsonObject;", "body", "login2", "Lretrofit2/Response;", "Ltn/mbach/warnMe/Network/Loginresponse;", "User", "(Ltn/mbach/warnMe/Network/Loginresponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signup", "map", "Ljava/util/HashMap;", "", "app_debug"})
public abstract interface UserApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api/user/login")
    public abstract retrofit2.Call<com.google.gson.JsonObject> login1(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.google.gson.JsonObject body);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/user/login")
    public abstract java.lang.Object login2(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    tn.mbach.warnMe.Network.Loginresponse User, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<tn.mbach.warnMe.Network.Loginresponse>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "api/user/register")
    public abstract retrofit2.Call<com.google.gson.JsonObject> signup(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    java.util.HashMap<java.lang.String, java.lang.String> map);
}