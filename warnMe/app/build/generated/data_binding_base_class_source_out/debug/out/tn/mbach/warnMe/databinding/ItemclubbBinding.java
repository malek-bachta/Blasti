// Generated by view binder compiler. Do not edit!
package tn.mbach.warnMe.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import tn.mbach.warnMe.R;

public final class ItemclubbBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView Clubimageitem;

  @NonNull
  public final TextView LocationClubitem;

  @NonNull
  public final TextView TitleClubitem;

  @NonNull
  public final TextView dateClubitem;

  private ItemclubbBinding(@NonNull CardView rootView, @NonNull ImageView Clubimageitem,
      @NonNull TextView LocationClubitem, @NonNull TextView TitleClubitem,
      @NonNull TextView dateClubitem) {
    this.rootView = rootView;
    this.Clubimageitem = Clubimageitem;
    this.LocationClubitem = LocationClubitem;
    this.TitleClubitem = TitleClubitem;
    this.dateClubitem = dateClubitem;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemclubbBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemclubbBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.itemclubb, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemclubbBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Clubimageitem;
      ImageView Clubimageitem = ViewBindings.findChildViewById(rootView, id);
      if (Clubimageitem == null) {
        break missingId;
      }

      id = R.id.LocationClubitem;
      TextView LocationClubitem = ViewBindings.findChildViewById(rootView, id);
      if (LocationClubitem == null) {
        break missingId;
      }

      id = R.id.TitleClubitem;
      TextView TitleClubitem = ViewBindings.findChildViewById(rootView, id);
      if (TitleClubitem == null) {
        break missingId;
      }

      id = R.id.dateClubitem;
      TextView dateClubitem = ViewBindings.findChildViewById(rootView, id);
      if (dateClubitem == null) {
        break missingId;
      }

      return new ItemclubbBinding((CardView) rootView, Clubimageitem, LocationClubitem,
          TitleClubitem, dateClubitem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}