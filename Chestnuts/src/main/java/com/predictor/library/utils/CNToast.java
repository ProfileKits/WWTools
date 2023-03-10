package com.predictor.library.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;


import com.predictor.library.R;

import java.lang.reflect.Field;

/**
 *
 */
public class CNToast {

    public static void showErrorNet(Context context) {
        show(context, R.string.net_exception);
    }

    public static void show(Context context, int res) {
        if (context == null) {
            return;
        }
        realShow(context, context.getString(res), Toast.LENGTH_SHORT);
    }

    public static void showErrorData(Context context) {
        if (context == null) {
            return;
        }
        realShow(context, context.getString(R.string.data_exception), Toast.LENGTH_SHORT);
    }


    public static void showNetError(Context context) {
        if (context == null) {
            return;
        }
        realShow(context, context.getString(R.string.net_exception), Toast.LENGTH_SHORT);
    }

    public static void show(Context context, String message) {
        if (context == null) {
            return;
        }
        realShow(context, message, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, String message) {
        if (context == null) {
            return;
        }
        realShow(context, message, Toast.LENGTH_LONG);
    }

    public static void showLong(Context context, int res) {
        if (context == null) {
            return;
        }
        realShow(context, context.getString(res), Toast.LENGTH_LONG);
    }

    public static void showUnkownError(Context ctx, Throwable t) {
        String message = "null";
        if (t != null) {
            message = t.getMessage();
        }
        show(ctx, ctx.getString(R.string.tip_unkown_error_place_holder, message));
    }

    private static void realShow(Context context, int res, int duration) {
        realShow(context, context.getString(res), duration);
    }

    private static void realShow(Context context, CharSequence text, int duration) {
        // ??????7???toast????????????ui????????????????????????hook??????try,
        hook(Toast.makeText(context, text, duration)).show();
    }

    @SuppressWarnings("JavaReflectionMemberAccess")
    private static Toast hook(Toast toast) {
        Class<Toast> cToast = Toast.class;
        try {
            //TN???private???
            @SuppressLint("SoonBlockedPrivateApi") Field fTn = cToast.getDeclaredField("mTN");
            fTn.setAccessible(true);

            //??????tn??????
            Object oTn = fTn.get(toast);
            //??????TN???class????????????????????????Field.getType()?????????
            Class<?> cTn = oTn.getClass();
            Field fHandle = cTn.getDeclaredField("mHandler");

            //??????set->mHandler
            fHandle.setAccessible(true);
            fHandle.set(oTn, new HandlerProxy((Handler) fHandle.get(oTn)));
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
        return toast;
    }

    private static class HandlerProxy extends Handler {
        private Handler mHandler;
        HandlerProxy(Handler handler) {
            this.mHandler = handler;
        }

        @Override
        public void handleMessage(Message msg) {
            try {
                mHandler.handleMessage(msg);
            } catch (WindowManager.BadTokenException ignored) {
                // ??????8?????????handleShow????????????????????????try catch?????????????????????????????????try catch???????????????
            }
        }
    }
}
