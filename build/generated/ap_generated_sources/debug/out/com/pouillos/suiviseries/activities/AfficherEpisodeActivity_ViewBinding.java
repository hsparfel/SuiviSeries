// Generated code from Butter Knife. Do not modify!
package com.pouillos.suiviseries.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEpisodeActivity_ViewBinding implements Unbinder {
  private AfficherEpisodeActivity target;

  private View view7f0800a1;

  @UiThread
  public AfficherEpisodeActivity_ViewBinding(AfficherEpisodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEpisodeActivity_ViewBinding(final AfficherEpisodeActivity target, View source) {
    this.target = target;

    View view;
    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextInputEditText.class);
    target.list_recycler_episode = Utils.findRequiredViewAsType(source, R.id.list_recycler_episode, "field 'list_recycler_episode'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fabDelete, "field 'fabDelete' and method 'setFabDeleteClick'");
    target.fabDelete = Utils.castView(view, R.id.fabDelete, "field 'fabDelete'", FloatingActionButton.class);
    view7f0800a1 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setFabDeleteClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AfficherEpisodeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutName = null;
    target.textName = null;
    target.list_recycler_episode = null;
    target.fabDelete = null;

    view7f0800a1.setOnClickListener(null);
    view7f0800a1 = null;
  }
}
