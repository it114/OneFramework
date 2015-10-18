/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.it114.android.oneframework.core.util;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ��ͼ������,��ҳ��ĸ���ͼ������ͼ���ִ��ݽ���,Ȼ��ͨ��findViewById��������ͼ,�����������ת��
 *
 * @author mrsimple
 */
public final class ViewFinder {

    /**
     * ÿ���View��sub view Map
     */
    private SparseArray<View> mViewMap = new SparseArray<View>();
    /**
     * Root View��������,
     * ������ֹView�����ͷš������mRootViewû�б��ⲿ���ã���ô������������rootView֮���ϵ�rootview�ᱻ�ͷ�.
     */
    private View mRootView;

    public ViewFinder(View rootView) {
        mRootView = rootView;
    }

    public ViewFinder(Context context, int layout) {
        this(context, null, layout);
    }

    public ViewFinder(Context context, ViewGroup parent, int layout) {
        this(LayoutInflater.from(context).inflate(layout, parent, false));
    }

    /**
     * ���ض�����ͼ
     *
     * @return
     */
    public View getRootView() {
        return mRootView;
    }

    /**
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T findViewById(int viewId) {

        // �ȴ�view map�в���,����еĻ���Ļ�ֱ��ʹ��,�����ٴ�mContentView����
        View targetView = mViewMap.get(viewId);
        if (targetView == null) {
            targetView = mRootView.findViewById(viewId);
            if (targetView != null) {
                mViewMap.put(viewId, targetView);
            }

        }
        return targetView == null ? null : (T) targetView;
    }
}
