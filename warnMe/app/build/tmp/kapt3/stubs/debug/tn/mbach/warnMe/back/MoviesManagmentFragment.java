package tn.mbach.warnMe.back;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002J\u0006\u0010\"\u001a\u00020 J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2 = {"Ltn/mbach/warnMe/back/MoviesManagmentFragment;", "Landroidx/fragment/app/Fragment;", "()V", "DescriptiontxtWatcher", "Landroid/text/TextWatcher;", "GenretxtWatcher", "TitletxtWatcher", "Validator", "Ltn/mbach/warnMe/Utils/Validator;", "getValidator", "()Ltn/mbach/warnMe/Utils/Validator;", "btnGet", "Landroid/widget/Button;", "picker", "Landroid/widget/DatePicker;", "tvw", "Landroid/widget/TextView;", "txtDescription", "Lcom/google/android/material/textfield/TextInputEditText;", "txtGenre", "txtTitle", "txtdescriptiondLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "txtgenreLayout", "txttitleLayout", "viewModel", "Ltn/mbach/warnMe/ViewModel/MoviesViewModel;", "getViewModel", "()Ltn/mbach/warnMe/ViewModel/MoviesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "DoActionaddmovie", "", "gettextwathceraddmovie", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_debug"})
public final class MoviesManagmentFragment extends androidx.fragment.app.Fragment {
    private com.google.android.material.textfield.TextInputLayout txttitleLayout;
    private com.google.android.material.textfield.TextInputLayout txtgenreLayout;
    private com.google.android.material.textfield.TextInputLayout txtdescriptiondLayout;
    private com.google.android.material.textfield.TextInputEditText txtTitle;
    private com.google.android.material.textfield.TextInputEditText txtGenre;
    private com.google.android.material.textfield.TextInputEditText txtDescription;
    private android.widget.DatePicker picker;
    private android.widget.Button btnGet;
    private android.widget.TextView tvw;
    @org.jetbrains.annotations.NotNull()
    private final tn.mbach.warnMe.Utils.Validator Validator = null;
    private final kotlin.Lazy viewModel$delegate = null;
    private final android.text.TextWatcher TitletxtWatcher = null;
    private final android.text.TextWatcher GenretxtWatcher = null;
    private final android.text.TextWatcher DescriptiontxtWatcher = null;
    
    public MoviesManagmentFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final tn.mbach.warnMe.Utils.Validator getValidator() {
        return null;
    }
    
    private final tn.mbach.warnMe.ViewModel.MoviesViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initView() {
    }
    
    public final void DoActionaddmovie() {
    }
    
    private final void gettextwathceraddmovie() {
    }
}