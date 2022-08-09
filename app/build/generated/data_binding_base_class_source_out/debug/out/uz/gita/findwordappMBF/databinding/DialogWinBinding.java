// Generated by view binder compiler. Do not edit!
package uz.gita.findwordappMBF.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import uz.gita.findwordappMBF.R;

public final class DialogWinBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton buttonContinue;

  @NonNull
  public final AppCompatImageView iconCoin;

  @NonNull
  public final AppCompatImageView imageRays;

  @NonNull
  public final Guideline line1;

  @NonNull
  public final Guideline line2;

  @NonNull
  public final View viewGreetings;

  private DialogWinBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton buttonContinue, @NonNull AppCompatImageView iconCoin,
      @NonNull AppCompatImageView imageRays, @NonNull Guideline line1, @NonNull Guideline line2,
      @NonNull View viewGreetings) {
    this.rootView = rootView;
    this.buttonContinue = buttonContinue;
    this.iconCoin = iconCoin;
    this.imageRays = imageRays;
    this.line1 = line1;
    this.line2 = line2;
    this.viewGreetings = viewGreetings;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogWinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogWinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_win, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogWinBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_continue;
      AppCompatButton buttonContinue = ViewBindings.findChildViewById(rootView, id);
      if (buttonContinue == null) {
        break missingId;
      }

      id = R.id.icon_coin;
      AppCompatImageView iconCoin = ViewBindings.findChildViewById(rootView, id);
      if (iconCoin == null) {
        break missingId;
      }

      id = R.id.image_rays;
      AppCompatImageView imageRays = ViewBindings.findChildViewById(rootView, id);
      if (imageRays == null) {
        break missingId;
      }

      id = R.id.line1;
      Guideline line1 = ViewBindings.findChildViewById(rootView, id);
      if (line1 == null) {
        break missingId;
      }

      id = R.id.line2;
      Guideline line2 = ViewBindings.findChildViewById(rootView, id);
      if (line2 == null) {
        break missingId;
      }

      id = R.id.view_greetings;
      View viewGreetings = ViewBindings.findChildViewById(rootView, id);
      if (viewGreetings == null) {
        break missingId;
      }

      return new DialogWinBinding((ConstraintLayout) rootView, buttonContinue, iconCoin, imageRays,
          line1, line2, viewGreetings);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}