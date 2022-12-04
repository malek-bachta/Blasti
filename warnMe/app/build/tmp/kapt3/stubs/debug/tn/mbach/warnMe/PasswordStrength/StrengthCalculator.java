package tn.mbach.warnMe.PasswordStrength;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J*\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J*\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Ltn/mbach/warnMe/PasswordStrength/StrengthCalculator;", "Landroid/text/TextWatcher;", "()V", "_passwordState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltn/mbach/warnMe/PasswordStrength/PasswordUIState;", "_score", "", "passwordUIState", "Lkotlinx/coroutines/flow/StateFlow;", "getPasswordUIState", "()Lkotlinx/coroutines/flow/StateFlow;", "rules", "Ltn/mbach/warnMe/PasswordStrength/StrengthRules;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "p2", "p3", "calculateStrength", "password", "", "measureStrength", "onTextChanged", "app_debug"})
public final class StrengthCalculator implements android.text.TextWatcher {
    private final tn.mbach.warnMe.PasswordStrength.StrengthRules rules = null;
    private int _score = 0;
    private final kotlinx.coroutines.flow.MutableStateFlow<tn.mbach.warnMe.PasswordStrength.PasswordUIState> _passwordState = null;
    
    public StrengthCalculator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<tn.mbach.warnMe.PasswordStrength.PasswordUIState> getPasswordUIState() {
        return null;
    }
    
    private final void calculateStrength(java.lang.String password) {
    }
    
    private final void measureStrength() {
    }
    
    @java.lang.Override()
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence p0, int p1, int p2, int p3) {
    }
    
    @java.lang.Override()
    public void onTextChanged(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence p0, int p1, int p2, int p3) {
    }
    
    @java.lang.Override()
    public void afterTextChanged(@org.jetbrains.annotations.Nullable()
    android.text.Editable p0) {
    }
}