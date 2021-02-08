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

public class AfficherEtablissementActivity_ViewBinding implements Unbinder {
  private AfficherEtablissementActivity target;

  private View view7f0800b5;

  private View view7f0800b8;

  private View view7f0800b7;

  @UiThread
  public AfficherEtablissementActivity_ViewBinding(AfficherEtablissementActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEtablissementActivity_ViewBinding(final AfficherEtablissementActivity target,
      View source) {
    this.target = target;

    View view;
    target.layoutRaisonSocial = Utils.findRequiredViewAsType(source, R.id.layoutRaisonSocial, "field 'layoutRaisonSocial'", TextInputLayout.class);
    target.textRaisonSocial = Utils.findRequiredViewAsType(source, R.id.textRaisonSocial, "field 'textRaisonSocial'", TextInputEditText.class);
    target.layoutType = Utils.findRequiredViewAsType(source, R.id.layoutType, "field 'layoutType'", TextInputLayout.class);
    target.textType = Utils.findRequiredViewAsType(source, R.id.textType, "field 'textType'", TextInputEditText.class);
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
    AfficherEtablissementActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutRaisonSocial = null;
    target.textRaisonSocial = null;
    target.layoutType = null;
    target.textType = null;
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
