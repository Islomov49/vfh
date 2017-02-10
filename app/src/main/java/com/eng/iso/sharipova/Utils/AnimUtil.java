package com.eng.iso.sharipova.Utils;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by developer on 11.02.2017.
 */

public class AnimUtil {

    public interface AfterAnimationEnd {
        void onAnimoationEnd();
    }
    public static void buttonClickCustomAnimation(float scaleSize, final View view, final AfterAnimationEnd afterAnimationEnd) {
        final Runnable onClickAction = new Runnable() {
            @Override
            public void run() {
                afterAnimationEnd.onAnimoationEnd();
            }
        };
        Runnable endAction = new Runnable() {
            public void run() {
                view.animate().setDuration(30).scaleXBy(0.5f).scaleYBy(0.5f).scaleX(1f).scaleY(1f).setInterpolator(new AccelerateInterpolator()).withEndAction(onClickAction);
            }
        };
        view.animate().setDuration(30).scaleXBy(0.5f).scaleYBy(0.5f).scaleX(scaleSize).scaleY(scaleSize).setInterpolator(new DecelerateInterpolator()).withEndAction(endAction);

    }
}
