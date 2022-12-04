package tn.mbach.warnMe.ViewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0014\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0012J6\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\'\u001a\u00020(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Ltn/mbach/warnMe/ViewModel/UserViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "MySharedPref", "Landroid/content/SharedPreferences;", "ReadyFunction", "Ltn/mbach/warnMe/Utils/ReadyFunction;", "getReadyFunction", "()Ltn/mbach/warnMe/Utils/ReadyFunction;", "retrofi", "Lretrofit2/Retrofit;", "getRetrofi", "()Lretrofit2/Retrofit;", "service", "Ltn/mbach/warnMe/Network/UserApi;", "getService", "()Ltn/mbach/warnMe/Network/UserApi;", "statusMessage", "Landroidx/lifecycle/MutableLiveData;", "", "usersList", "", "Ltn/mbach/warnMe/Models/User;", "Register", "", "txtname", "Lcom/google/android/material/textfield/TextInputEditText;", "txtemail", "txtpass", "context", "Landroid/content/Context;", "Activity", "Landroid/app/Activity;", "getUsers", "login1", "loginemail", "loginpassw", "view", "Landroid/view/View;", "cbRememberMe", "Landroid/widget/CheckBox;", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final retrofit2.Retrofit retrofi = null;
    @org.jetbrains.annotations.NotNull()
    private final tn.mbach.warnMe.Network.UserApi service = null;
    @org.jetbrains.annotations.NotNull()
    private final tn.mbach.warnMe.Utils.ReadyFunction ReadyFunction = null;
    private androidx.lifecycle.MutableLiveData<java.util.List<tn.mbach.warnMe.Models.User>> usersList;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> statusMessage = null;
    private android.content.SharedPreferences MySharedPref;
    
    public UserViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit getRetrofi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tn.mbach.warnMe.Network.UserApi getService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tn.mbach.warnMe.Utils.ReadyFunction getReadyFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<java.util.List<tn.mbach.warnMe.Models.User>> getUsers() {
        return null;
    }
    
    public final void login1(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText loginemail, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText loginpassw, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.app.Activity Activity, @org.jetbrains.annotations.NotNull()
    android.widget.CheckBox cbRememberMe) {
    }
    
    public final void Register(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtname, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtemail, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtpass, @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.app.Activity Activity) {
    }
}