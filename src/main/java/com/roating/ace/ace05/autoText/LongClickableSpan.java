package com.roating.ace.ace05.autoText;

import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by yangc on 2018/3/13.
 */

public  abstract class LongClickableSpan extends ClickableSpan {
    /**
     * 长按事件
     * @param widget
     */
    public abstract void onLongClick(View widget);
}
