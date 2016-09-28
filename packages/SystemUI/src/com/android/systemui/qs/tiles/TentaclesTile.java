/*
 * Copyright (C) 2016 Team OctOs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.systemui.qs.tiles;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
import com.android.internal.logging.MetricsProto.MetricsEvent;

/**
 * Tentacles quick settings tile
 */
public class TentaclesTile extends QSTile<QSTile.BooleanState> {

    private static final Intent TENTACLES_SETTINGS = new Intent().setComponent(new ComponentName(
            "com.android.settings", "com.android.settings.Settings$TentaclesActivity"));
    private static final Intent ABOUT_OCTOS = new Intent().setComponent(new ComponentName(
            "com.about.octos.aboutoctos", "com.about.octos.aboutoctos.AboutOctOs"));

    public TentaclesTile(Host host) {
        super(host);
    }

    @Override
    public BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void setListening(boolean listening) {
    }

    @Override
    protected void handleClick() {
        mHost.startActivityDismissingKeyguard(TENTACLES_SETTINGS);
    }

    @Override
    public Intent getLongClickIntent() {
    /*    To Do: Use long click to open ABOUT_OCTOS after AboutOctOS is installed */
    /*    For now default to TENTACLES_SETTINGS */
    /*    return ABOUT_OCTOS; */
        return TENTACLES_SETTINGS;
    }

    @Override
    public CharSequence getTileLabel() {
        return mContext.getString(R.string.quick_settings_tentacles_label);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsEvent.QUICK_SETTINGS;
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.label = mContext.getString(R.string.quick_settings_tentacles_label);
        state.icon = ResourceIcon.get(R.drawable.ic_qs_tentacles);
    }

}
