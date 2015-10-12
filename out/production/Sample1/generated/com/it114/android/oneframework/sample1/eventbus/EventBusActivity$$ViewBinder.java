// Generated code from Butter Knife. Do not modify!
package com.it114.android.oneframework.sample1.eventbus;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class EventBusActivity$$ViewBinder<T extends com.it114.android.oneframework.sample1.eventbus.EventBusActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131034112, "field 'btnPostThread' and method 'onPostThreadClick'");
    target.btnPostThread = finder.castView(view, 2131034112, "field 'btnPostThread'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onPostThreadClick();
        }
      });
    view = finder.findRequiredView(source, 2131034113, "field 'btnMainThread' and method 'onMainThread'");
    target.btnMainThread = finder.castView(view, 2131034113, "field 'btnMainThread'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onMainThread();
        }
      });
    view = finder.findRequiredView(source, 2131034114, "field 'btnBackgroundThread' and method 'onBackgroundThread'");
    target.btnBackgroundThread = finder.castView(view, 2131034114, "field 'btnBackgroundThread'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onBackgroundThread();
        }
      });
    view = finder.findRequiredView(source, 2131034115, "field 'btnAsync' and method 'onAsync'");
    target.btnAsync = finder.castView(view, 2131034115, "field 'btnAsync'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onAsync();
        }
      });
  }

  @Override public void unbind(T target) {
    target.btnPostThread = null;
    target.btnMainThread = null;
    target.btnBackgroundThread = null;
    target.btnAsync = null;
  }
}
