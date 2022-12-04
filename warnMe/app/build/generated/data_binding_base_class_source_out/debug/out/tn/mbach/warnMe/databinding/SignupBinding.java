// Generated by view binder compiler. Do not edit!
package tn.mbach.warnMe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import tn.mbach.warnMe.R;

public final class SignupBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout AllOfPageSingUp;

  @NonNull
  public final TextView btnGoToLogin;

  @NonNull
  public final Button btnSignUp;

  @NonNull
  public final TextView imageView;

  @NonNull
  public final ProgressBar pbPasswordStrength;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView twPasswordStrength;

  @NonNull
  public final TextInputLayout txtConfirmPasswordLayout;

  @NonNull
  public final TextInputEditText txtConfirmPwd;

  @NonNull
  public final TextInputLayout txtEmailLayoutSignUp;

  @NonNull
  public final TextInputEditText txtEmailSignUp;

  @NonNull
  public final TextInputEditText txtName;

  @NonNull
  public final TextInputLayout txtNameLayout;

  @NonNull
  public final TextInputLayout txtPasswordLayoutSignUp;

  @NonNull
  public final TextInputEditText txtPwdSignUp;

  private SignupBinding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout AllOfPageSingUp,
      @NonNull TextView btnGoToLogin, @NonNull Button btnSignUp, @NonNull TextView imageView,
      @NonNull ProgressBar pbPasswordStrength, @NonNull TextView textView,
      @NonNull TextView twPasswordStrength, @NonNull TextInputLayout txtConfirmPasswordLayout,
      @NonNull TextInputEditText txtConfirmPwd, @NonNull TextInputLayout txtEmailLayoutSignUp,
      @NonNull TextInputEditText txtEmailSignUp, @NonNull TextInputEditText txtName,
      @NonNull TextInputLayout txtNameLayout, @NonNull TextInputLayout txtPasswordLayoutSignUp,
      @NonNull TextInputEditText txtPwdSignUp) {
    this.rootView = rootView;
    this.AllOfPageSingUp = AllOfPageSingUp;
    this.btnGoToLogin = btnGoToLogin;
    this.btnSignUp = btnSignUp;
    this.imageView = imageView;
    this.pbPasswordStrength = pbPasswordStrength;
    this.textView = textView;
    this.twPasswordStrength = twPasswordStrength;
    this.txtConfirmPasswordLayout = txtConfirmPasswordLayout;
    this.txtConfirmPwd = txtConfirmPwd;
    this.txtEmailLayoutSignUp = txtEmailLayoutSignUp;
    this.txtEmailSignUp = txtEmailSignUp;
    this.txtName = txtName;
    this.txtNameLayout = txtNameLayout;
    this.txtPasswordLayoutSignUp = txtPasswordLayoutSignUp;
    this.txtPwdSignUp = txtPwdSignUp;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SignupBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout AllOfPageSingUp = (RelativeLayout) rootView;

      id = R.id.btnGoToLogin;
      TextView btnGoToLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnGoToLogin == null) {
        break missingId;
      }

      id = R.id.btnSignUp;
      Button btnSignUp = ViewBindings.findChildViewById(rootView, id);
      if (btnSignUp == null) {
        break missingId;
      }

      id = R.id.imageView;
      TextView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.pb_password_strength;
      ProgressBar pbPasswordStrength = ViewBindings.findChildViewById(rootView, id);
      if (pbPasswordStrength == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.twPasswordStrength;
      TextView twPasswordStrength = ViewBindings.findChildViewById(rootView, id);
      if (twPasswordStrength == null) {
        break missingId;
      }

      id = R.id.txtConfirmPasswordLayout;
      TextInputLayout txtConfirmPasswordLayout = ViewBindings.findChildViewById(rootView, id);
      if (txtConfirmPasswordLayout == null) {
        break missingId;
      }

      id = R.id.txtConfirmPwd;
      TextInputEditText txtConfirmPwd = ViewBindings.findChildViewById(rootView, id);
      if (txtConfirmPwd == null) {
        break missingId;
      }

      id = R.id.txtEmailLayoutSignUp;
      TextInputLayout txtEmailLayoutSignUp = ViewBindings.findChildViewById(rootView, id);
      if (txtEmailLayoutSignUp == null) {
        break missingId;
      }

      id = R.id.txtEmailSignUp;
      TextInputEditText txtEmailSignUp = ViewBindings.findChildViewById(rootView, id);
      if (txtEmailSignUp == null) {
        break missingId;
      }

      id = R.id.txtName;
      TextInputEditText txtName = ViewBindings.findChildViewById(rootView, id);
      if (txtName == null) {
        break missingId;
      }

      id = R.id.txtNameLayout;
      TextInputLayout txtNameLayout = ViewBindings.findChildViewById(rootView, id);
      if (txtNameLayout == null) {
        break missingId;
      }

      id = R.id.txtPasswordLayoutSignUp;
      TextInputLayout txtPasswordLayoutSignUp = ViewBindings.findChildViewById(rootView, id);
      if (txtPasswordLayoutSignUp == null) {
        break missingId;
      }

      id = R.id.txtPwdSignUp;
      TextInputEditText txtPwdSignUp = ViewBindings.findChildViewById(rootView, id);
      if (txtPwdSignUp == null) {
        break missingId;
      }

      return new SignupBinding((RelativeLayout) rootView, AllOfPageSingUp, btnGoToLogin, btnSignUp,
          imageView, pbPasswordStrength, textView, twPasswordStrength, txtConfirmPasswordLayout,
          txtConfirmPwd, txtEmailLayoutSignUp, txtEmailSignUp, txtName, txtNameLayout,
          txtPasswordLayoutSignUp, txtPwdSignUp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}