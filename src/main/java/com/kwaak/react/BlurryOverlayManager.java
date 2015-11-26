package com.kwaak.react;

import android.app.Activity;

import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class BlurryOverlayManager extends SimpleViewManager<BlurryOverlayView> {

    private Activity activity;

    public BlurryOverlayManager(Activity activity) {
        this.activity = activity;
    }

    public static final String REACT_CLASS = "RCTBlurryOverlay";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public BlurryOverlayView createViewInstance(ThemedReactContext context) {
        BlurryOverlayView c = new BlurryOverlayView(context, activity);

        return c;
    }

    @ReactProp(name = "radius", defaultInt = 0)
    public void setRadius(BlurryOverlayView view, int radius) {
        view.setRadiusAndUpdate(radius);
    }

    @ReactProp(name = "sampling", defaultInt = 0)
    public void setSampling(BlurryOverlayView view, int sampling) {
        view.setSamplingAndUpdate(sampling);
    }

    @ReactProp(name = "color")
    public void setColor(BlurryOverlayView view, String color) {
        view.setColorAndUpdate(color);
    }
}

