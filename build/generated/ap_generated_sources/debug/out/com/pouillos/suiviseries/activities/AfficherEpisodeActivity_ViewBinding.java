// Generated code from Butter Knife. Do not modify!
package com.pouillos.suiviseries.activities;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pouillos.suiviseries.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AfficherEpisodeActivity_ViewBinding implements Unbinder {
  private AfficherEpisodeActivity target;

  @UiThread
  public AfficherEpisodeActivity_ViewBinding(AfficherEpisodeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AfficherEpisodeActivity_ViewBinding(AfficherEpisodeActivity target, View source) {
    this.target = target;

    target.layoutName = Utils.findRequiredViewAsType(source, R.id.layoutName, "field 'layoutName'", TextInputLayout.class);
    target.textName = Utils.findRequiredViewAsType(source, R.id.textName, "field 'textName'", TextInputEditText.class);
    target.list_recycler_episode = Utils.findRequiredViewAsType(source, R.id.list_recycler_episode, "field 'list_recycler_episode'", RecyclerView.class);
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
  }
}
