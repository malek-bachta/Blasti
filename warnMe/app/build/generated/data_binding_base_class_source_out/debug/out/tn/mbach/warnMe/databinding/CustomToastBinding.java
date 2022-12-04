// Generated by view binder compiler. Do not edit!
package tn.mbach.warnMe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import tn.mbach.warnMe.R;

public final class CustomToastBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final FrameLayout buttonAccentBorder;

  @NonNull
  public final TextView toastText;

  private CustomToastBinding(@NonNull RelativeLayout rootView,
      @NonNull FrameLayout buttonAccentBorder, @NonNull TextView toastText) {
    this.rootView = rootView;
    this.buttonAccentBorder = buttonAccentBorder;
    this.toastText = toastText;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomToastBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomToastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_toast, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomToastBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_accent_border;
      FrameLayout buttonAccentBorder = ViewBindings.findChildViewById(rootView, id);
      if (buttonAccentBorder == null) {
        break missingId;
      }

      id = R.id.toast_text;
      TextView toastText = ViewBindings.findChildViewById(rootView, id);
      if (toastText == null) {
        break missingId;
      }

      return new CustomToastBinding((RelativeLayout) rootView, buttonAccentBorder, toastText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}