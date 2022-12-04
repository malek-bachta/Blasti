package tn.mbach.warnMe.Utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Ltn/mbach/warnMe/Utils/Validator;", "", "()V", "ValidatFormatEmail", "", "txtEmail", "Lcom/google/android/material/textfield/TextInputEditText;", "txtEmailLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "VerifLength", "txtName", "txtNameLayout", "MinValue", "", "VerifisEmpty", "app_debug"})
public final class Validator {
    
    public Validator() {
        super();
    }
    
    public final boolean VerifisEmpty(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtName, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout txtNameLayout) {
        return false;
    }
    
    public final boolean ValidatFormatEmail(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtEmail, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout txtEmailLayout) {
        return false;
    }
    
    public final boolean VerifLength(@org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputEditText txtName, @org.jetbrains.annotations.NotNull()
    com.google.android.material.textfield.TextInputLayout txtNameLayout, int MinValue) {
        return false;
    }
}