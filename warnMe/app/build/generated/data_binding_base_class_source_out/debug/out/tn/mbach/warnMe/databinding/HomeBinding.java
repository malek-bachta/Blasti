// Generated by view binder compiler. Do not edit!
package tn.mbach.warnMe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import tn.mbach.warnMe.R;

public final class HomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigation;

  @NonNull
  public final FrameLayout frameLayout;

  private HomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomNavigation, @NonNull FrameLayout frameLayout) {
    this.rootView = rootView;
    this.bottomNavigation = bottomNavigation;
    this.frameLayout = frameLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static HomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HomeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottom_navigation;
      BottomNavigationView bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.frame_layout;
      FrameLayout frameLayout = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout == null) {
        break missingId;
      }

      return new HomeBinding((ConstraintLayout) rootView, bottomNavigation, frameLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}