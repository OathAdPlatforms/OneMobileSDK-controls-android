/*
 * Copyright (c) 2016 One by Aol : Publishers. All rights reserved.
 */

package com.aol.mobile.sdk.controls.viewmodel;

import android.support.annotation.Nullable;

public class PlayerControlsVM {
    public boolean isLoading;
    public boolean isPlayButtonVisible;
    public boolean isPauseButtonVisible;
    public boolean isReplayButtonVisible;
    public boolean isNextButtonVisible;
    public boolean isNextButtonEnabled;
    public boolean isPrevButtonVisible;
    public boolean isPrevButtonEnabled;
    public boolean isSeekerVisible;
    public boolean isSeekForwardButtonVisible;
    public boolean isSeekBackButtonVisible;
    public boolean isSubtitlesButtonVisible;
    public boolean isSubtitlesButtonEnabled;
    public boolean isSubtitlesButtonSelected;
    public boolean isTitleVisible;
    public boolean isSubtitlesTextVisible;
    public boolean isCompassViewVisible;
    public boolean isThumbnailImageVisible;
    public boolean isStreamPlaying;
    public int seekerBufferedProgress;
    public int seekerMaxValue;
    public double seekerProgress;
    public double compassLatitude;
    public double compassLongitude;
    @Nullable
    public String seekerCurrentTimeText;
    @Nullable
    public String seekerTimeLeftText;
    @Nullable
    public String seekerDurationText;
    @Nullable
    public String titleText;
    @Nullable
    public CharSequence subtitlesText;
    @Nullable
    public String thumbnailImageUrl;
}