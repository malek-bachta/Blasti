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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import tn.mbach.warnMe.R;

public final class FragmentNotificationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardreservation;

  @NonNull
  public final CardView cardtickets;

  @NonNull
  public final ImageView imageReservqtion;

  @NonNull
  public final ImageView imageTicket;

  @NonNull
  public final TextView notificationtit;

  @NonNull
  public final TextView reservation;

  @NonNull
  public final TextView ticket;

  private FragmentNotificationBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView cardreservation, @NonNull CardView cardtickets,
      @NonNull ImageView imageReservqtion, @NonNull ImageView imageTicket,
      @NonNull TextView notificationtit, @NonNull TextView reservation, @NonNull TextView ticket) {
    this.rootView = rootView;
    this.cardreservation = cardreservation;
    this.cardtickets = cardtickets;
    this.imageReservqtion = imageReservqtion;
    this.imageTicket = imageTicket;
    this.notificationtit = notificationtit;
    this.reservation = reservation;
    this.ticket = ticket;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardreservation;
      CardView cardreservation = ViewBindings.findChildViewById(rootView, id);
      if (cardreservation == null) {
        break missingId;
      }

      id = R.id.cardtickets;
      CardView cardtickets = ViewBindings.findChildViewById(rootView, id);
      if (cardtickets == null) {
        break missingId;
      }

      id = R.id.imageReservqtion;
      ImageView imageReservqtion = ViewBindings.findChildViewById(rootView, id);
      if (imageReservqtion == null) {
        break missingId;
      }

      id = R.id.imageTicket;
      ImageView imageTicket = ViewBindings.findChildViewById(rootView, id);
      if (imageTicket == null) {
        break missingId;
      }

      id = R.id.notificationtit;
      TextView notificationtit = ViewBindings.findChildViewById(rootView, id);
      if (notificationtit == null) {
        break missingId;
      }

      id = R.id.reservation;
      TextView reservation = ViewBindings.findChildViewById(rootView, id);
      if (reservation == null) {
        break missingId;
      }

      id = R.id.ticket;
      TextView ticket = ViewBindings.findChildViewById(rootView, id);
      if (ticket == null) {
        break missingId;
      }

      return new FragmentNotificationBinding((ConstraintLayout) rootView, cardreservation,
          cardtickets, imageReservqtion, imageTicket, notificationtit, reservation, ticket);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}