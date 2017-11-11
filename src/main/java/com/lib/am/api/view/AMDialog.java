package com.lib.am.api.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.lib.am.api.presenter.listener.AMOkCancelListener;

/**
 * Created by sasmi_000 on 25-Nov-15.
 */
public class AMDialog {
    private AlertDialog.Builder builder;
    private AMOkCancelListener listener;

    public AMDialog(Context context) {
        this.builder = new AlertDialog.Builder(context);
    }

    public AMDialog withListener(AMOkCancelListener listener) {
        this.listener = listener;
        return this;
    }

    public AMDialog withOkButton(String text) {
        builder.setPositiveButton(text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (listener != null) {
                    listener.onOkAction();
                }
            }
        });
        return this;
    }

    public AMDialog withCancelButton(String text) {
        builder.setNegativeButton(text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (listener != null) {
                    listener.onCancelAction();
                }
            }
        });
        return this;
    }

    public AMDialog withView(AMView view) {
        if (view instanceof View) {
            builder.setView((View) view);
        }
        return this;
    }

    public AMDialog withView(View view) {
        builder.setView(view);
        return this;
    }

    public AMDialog withWarning(String msg) {
        withOkButton("Ok").withTitle("Warning").withMessage(msg);
        return this;
    }

    public AMDialog withError(String msg) {
        withOkButton("Ok").withTitle("Error").withMessage(msg);
        return this;
    }

    public AMDialog withInfo(String msg) {
        withOkButton("Ok").withTitle("Info").withMessage(msg);
        return this;
    }

    public AMDialog withMessage(String msg) {
        builder.setMessage(msg);
        return this;
    }

    public AMDialog withIcon(Drawable drawable) {
        builder.setIcon(drawable);
        return this;
    }

    public AMDialog withIcon(int drawableID) {
        builder.setIcon(drawableID);
        return this;
    }

    public AMDialog withTitle(String title) {
        builder.setTitle(title);
        return this;
    }

    public void setVisible(boolean visible) {
        if (visible) {
            builder.show();
        }
    }
}
