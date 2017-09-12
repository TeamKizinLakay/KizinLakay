package com.example.thodlydugue.kizinlakayapp;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by sonel on 9/7/2017.
 */

public class DialogHelper {
    /**
     * Creates a dialog box displaying error message.
     *
     * @param context a context in which error occurred
     * @param title   title of the error
     * @param message error message
     * @return dialog containing error message
     */
    public static AlertDialog createErrorDialog(Context context, String title, String message )
    {
        return new AlertDialog.Builder( context )
                .setTitle( title )
                .setMessage( message )
                .setIcon( android.R.drawable.ic_dialog_alert )
                .create();
    }


}
