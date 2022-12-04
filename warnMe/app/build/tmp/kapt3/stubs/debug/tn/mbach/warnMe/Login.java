package tn.mbach.warnMe;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u0006\u0010*\u001a\u00020(J\u0006\u0010+\u001a\u00020(J\b\u0010,\u001a\u00020(H\u0002J\u0006\u0010-\u001a\u00020(J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u000100H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Ltn/mbach/warnMe/Login;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "AllOfPageLogin", "Landroid/widget/RelativeLayout;", "EmailtxtWatcher", "Landroid/text/TextWatcher;", "MySharedPref", "Landroid/content/SharedPreferences;", "PasswordtxtWatcher", "ProgressbarLogin", "Landroid/widget/ProgressBar;", "ReadyFunction", "Ltn/mbach/warnMe/Utils/ReadyFunction;", "getReadyFunction", "()Ltn/mbach/warnMe/Utils/ReadyFunction;", "Validator", "Ltn/mbach/warnMe/Utils/Validator;", "getValidator", "()Ltn/mbach/warnMe/Utils/Validator;", "btnGoToSignUp", "Landroid/widget/TextView;", "btnLogin", "Landroid/widget/Button;", "cbRememberMe", "Landroid/widget/CheckBox;", "txtEmail", "Lcom/google/android/material/textfield/TextInputEditText;", "txtEmailLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "txtForgetPassword", "txtPasswordLayout", "txtPwd", "viewModel", "Ltn/mbach/warnMe/ViewModel/UserViewModel;", "getViewModel", "()Ltn/mbach/warnMe/ViewModel/UserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "CLickToHidKeyBoard", "", "DoActionLogin", "GoToSignUp", "SetLastEmail", "gettextwathcerlogin", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class Login extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.TextView txtForgetPassword;
    private android.widget.TextView btnGoToSignUp;
    private com.google.android.material.textfield.TextInputLayout txtEmailLayout;
    private com.google.android.material.textfield.TextInputLayout txtPasswordLayout;
    private com.google.android.material.textfield.TextInputEditText txtEmail;
    private com.google.android.material.textfield.TextInputEditText txtPwd;
    private android.widget.CheckBox cbRememberMe;
    private android.widget.ProgressBar ProgressbarLogin;
    private android.widget.Button btnLogin;
    private android.widget.RelativeLayout AllOfPageLogin;
    @org.jetbrains.annotations.NotNull()
    private final tn.mbach.warnMe.Utils.ReadyFunction ReadyFunction = null;
    @org.jetbrains.annotations.NotNull()
    private final tn.mbach.warnMe.Utils.Validator Validator = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private android.content.SharedPreferences MySharedPref;
    private final android.text.TextWatcher EmailtxtWatcher = null;
    private final android.text.TextWatcher PasswordtxtWatcher = null;
    
    public Login() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tn.mbach.warnMe.Utils.ReadyFunction getReadyFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tn.mbach.warnMe.Utils.Validator getValidator() {
        return null;
    }
    
    private final tn.mbach.warnMe.ViewModel.UserViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void SetLastEmail() {
    }
    
    public final void initView() {
    }
    
    public final void GoToSignUp() {
    }
    
    public final void DoActionLogin() {
    }
    
    public final void CLickToHidKeyBoard() {
    }
    
    private final void gettextwathcerlogin() {
    }
}