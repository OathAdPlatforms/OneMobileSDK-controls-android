/*
 * Copyright 2018, Oath Inc.
 * Licensed under the terms of the MIT License. See LICENSE.md file in project root for terms.
 */

package com.aol.mobile.sdk.controls.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.aol.mobile.sdk.annotations.PrivateApi;
import com.aol.mobile.sdk.controls.R;
import com.aol.mobile.sdk.controls.Themed;

@PrivateApi
public class TintableImageButton extends ImageButton implements Themed {
    protected int mainColor;
    protected int accentColor;

    public TintableImageButton(@NonNull Context context) {
        this(context, null);
    }

    public TintableImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @SuppressWarnings("deprecation")
    public TintableImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        mainColor = context.getResources().getColor(R.color.default_main_color);
        accentColor = context.getResources().getColor(R.color.default_accent_color);

        if (attrs != null) {
            TypedArray a = context
                    .obtainStyledAttributes(attrs, R.styleable.TintableImageButton, defStyle, 0);

            try {
                mainColor = a.getColor(R.styleable.TintableImageButton_mainColor, mainColor);
                accentColor = a.getColor(R.styleable.TintableImageButton_accentColor, accentColor);
            } finally {
                a.recycle();
            }
        }

        drawableStateChanged();
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setColorFilter(getColorFor(getDrawableState()), PorterDuff.Mode.MULTIPLY);
    }

    @ColorInt
    protected int getColorFor(@NonNull int[] drawableState) {
        for (int state : drawableState) {
            switch (state) {
                case android.R.attr.state_pressed:
                case android.R.attr.state_selected:
                case android.R.attr.state_focused:
                    return accentColor;
            }
        }

        return mainColor;
    }

    @Override
    public void setMainColor(@ColorInt int color) {
        this.mainColor = color;
        drawableStateChanged();
    }

    @Override
    public void setAccentColor(@ColorInt int color) {
        this.accentColor = color;
        drawableStateChanged();
    }
}
