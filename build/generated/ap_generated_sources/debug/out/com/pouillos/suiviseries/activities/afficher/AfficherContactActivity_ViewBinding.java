// Generated code from Butter Knife. Do not modify!
package com.pouillos.suiviseries.activities.afficher;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherContactActivity_ViewBinding implements Unbinder {
  private AfficherContactActivity target;

  private View view7f0800b5;

  private View view7f0800b8;

  private View view7f0800b7;

  @UiThread
  public AfficherContactActivity_ViewBinding(AfficherContactActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherContactActivity_ViewBinding(final AfficherContactActivity target, View source) {
    this.target = target;

    View view;
    target.layoutDr = Utils.findRequiredViewAsType(source, R.id.layoutDr, "field 'layoutDr'", TextInputLayout.class);
    target.textDr = Utils.findRequiredViewAsType(source, R.id.textDr, "field 'textDr'", TextInputEditText.class);
    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextInputEditText.class);
    target.layoutFirstName = Utils.findRequiredViewAsType(source, R.id.layoutFirstName, "field 'layoutFirstName'", TextInputLayout.class);
    target.textFirstName = Utils.findRequiredViewAsType(source, R.id.textFirstName, "field 'textFirstName'", TextInputEditText.class);
    target.layoutJob = Utils.findRequiredViewAsType(source, R.id.layoutJob, "field 'layoutJob'", TextInputLayout.class);
    target.textJob = Utils.findRequiredViewAsType(source, R.id.textJob, "field 'textJob'", TextInputEditText.class);
    target.layoutPlace = Utils.findRequiredViewAsType(source, R.id.layoutPlace, "field 'layoutPlace'", TextInputLayout.class);
    target.textPlace = Utils.findRequiredViewAsType(source, R.id.textPlace, "field 'textPlace'", TextInputEditText.class);
    target.layoutComplement = Utils.findRequiredViewAsType(source, R.id.layoutComplement, "field 'layoutComplement'", TextInputLayout.class);
    target.textComplement = Utils.findRequiredViewAsType(source, R.id.textComplement, "field 'textComplement'", TextInputEditText.class);
    target.layoutNumStreet = Utils.findRequiredViewAsType(source, R.id.layoutNumStreet, "field 'layoutNumStreet'", TextInputLayout.class);
    target.textNumStreet = Utils.findRequiredViewAsType(source, R.id.textNumStreet, "field 'textNumStreet'", TextInputEditText.class);
    target.layoutZip = Utils.findRequiredViewAsType(source, R.id.layoutZip, "field 'layoutZip'", TextInputLayout.class);
    target.textZip = Utils.findRequiredViewAsType(source, R.id.textZip, "field 'textZip'", TextInputEditText.class);
    target.layoutTown = Utils.findRequiredViewAsType(source, R.id.layoutTown, "field 'layoutTown'", TextInputLayout.class);
    target.textTown = Utils.findRequiredViewAsType(source, R.id.textTown, "field 'textTown'", TextInputEditText.class);
    target.layoutPhone = Utils.findRequiredViewAsType(source, R.id.layoutPhone, "field 'layoutPhone'", TextInputLayout.class);
    target.textPhone = Utils.findRequiredViewAsType(source, R.id.textPhone, "field 'textPhone'", TextInputEditText.class);
    target.layoutFax = Utils.findRequiredViewAsType(source, R.id.layoutFax, "field 'layoutFax'", TextInputLayout.class);
    target.textFax = Utils.findRequiredViewAsType(source, R.id.textFax, "field 'textFax'", TextInputEditText.class);
    target.layoutEmail = Utils.findRequiredViewAsType(source, R.id.layoutEmail, "field 'layoutEmail'", TextInputLayout.class);
    target.textEmail = Utils.findRequiredViewAsType(source, R.id.textEmail, "field 'textEmail'", TextInputEditText.class);
    view = Utils.findRequiredView(source, R.id.fabGoogleMap, "field 'fabGoogleMap' and method 'fabGoogleMapClick'");
    target.fabGoogleMap = Utils.castView(view, R.id.fabGoogleMap, "field 'fabGoogleMap'", FloatingActionButton.class);
    view7f0800b5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabGoogleMapClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabWaze, "field 'fabWaze' and method 'fabWazeClick'");
    target.fabWaze = Utils.castView(view, R.id.fabWaze, "field 'fabWaze'", FloatingActionButton.class);
    view7f0800b8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabWazeClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.fabSave, "field 'fabSave' and method 'fabSaveClick'");
    target.fabSave = Utils.castView(view, R.id.fabSave, "field 'fabSave'", FloatingActionButton.class);
    view7f0800b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.fabSaveClick();
      }
    });
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.activity_main_toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherContactActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutDr = null;
    target.textDr = null;
    target.layoutName = null;
    target.textName = null;
    target.layoutFirstName = null;
    target.textFirstName = null;
    target.layoutJob = null;
    target.textJob = null;
    target.layoutPlace = null;
    target.textPlace = null;
    target.layoutComplement = null;
    target.textComplement = null;
    target.layoutNumStreet = null;
    target.textNumStreet = null;
    target.layoutZip = null;
    target.textZip = null;
    target.layoutTown = null;
    target.textTown = null;
    target.layoutPhone = null;
    target.textPhone = null;
    target.layoutFax = null;
    target.textFax = null;
    target.layoutEmail = null;
    target.textEmail = null;
    target.fabGoogleMap = null;
    target.fabWaze = null;
    target.fabSave = null;
    target.toolbar = null;

    view7f0800b5.setOnClickListener(null);
    view7f0800b5 = null;
    view7f0800b8.setOnClickListener(null);
    view7f0800b8 = null;
    view7f0800b7.setOnClickListener(null);
    view7f0800b7 = null;
  }
}
