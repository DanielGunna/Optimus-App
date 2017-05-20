// Generated code from Butter Knife. Do not modify!
package br.com.gunna.optimus_app.androidapp;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.rengwuxian.materialedittext.MaterialEditText;
import fr.ganfra.materialspinner.MaterialSpinner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentProduzir_ViewBinding implements Unbinder {
  private FragmentProduzir target;

  private View view2131558540;

  @UiThread
  public FragmentProduzir_ViewBinding(final FragmentProduzir target, View source) {
    this.target = target;

    View view;
    target.spinMax = Utils.findRequiredViewAsType(source, R.id.spin_max, "field 'spinMax'", MaterialSpinner.class);
    target.spinProdutoA = Utils.findRequiredViewAsType(source, R.id.spin_produto, "field 'spinProdutoA'", MaterialSpinner.class);
    target.spinProdutoB = Utils.findRequiredViewAsType(source, R.id.spin_produto_b, "field 'spinProdutoB'", MaterialSpinner.class);
    target.spinQtA = Utils.findRequiredViewAsType(source, R.id.spin_qt, "field 'spinQtA'", MaterialEditText.class);
    target.spinQtB = Utils.findRequiredViewAsType(source, R.id.spin_qt_b, "field 'spinQtB'", MaterialEditText.class);
    view = Utils.findRequiredView(source, R.id.btn_otimizar, "method 'otimize'");
    view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.otimize();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentProduzir target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinMax = null;
    target.spinProdutoA = null;
    target.spinProdutoB = null;
    target.spinQtA = null;
    target.spinQtB = null;

    view2131558540.setOnClickListener(null);
    view2131558540 = null;
  }
}
