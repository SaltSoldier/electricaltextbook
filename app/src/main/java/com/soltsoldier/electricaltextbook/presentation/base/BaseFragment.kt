package com.soltsoldier.electricaltextbook.presentation.base

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import dmax.dialog.SpotsDialog

open class BaseFragment : Fragment() {
    private var mAlertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAlertDialog = SpotsDialog(activity)
    }

    override fun onPause() {
        super.onPause()
        if (mAlertDialog != null && mAlertDialog!!.isShowing) {
            mAlertDialog!!.dismiss()
            mAlertDialog = null
        }
    }

    // AlertDialogを出力する
    fun showAlertDialog() {
        if (mAlertDialog == null) {
            mAlertDialog = SpotsDialog(activity)
        }

        mAlertDialog!!.setCancelable(false)
        if (!mAlertDialog!!.isShowing) {
            mAlertDialog!!.show()
        }
    }

    // AlertDialogを消す
    fun dismissAlertDialog() {
        try {
            if (mAlertDialog != null && this.mAlertDialog!!.isShowing) {
                this.mAlertDialog!!.dismiss()
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            this.mAlertDialog = null
        }
    }
}