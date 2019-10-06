package com.soltsoldier.electricaltextbook.presentation.base

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dmax.dialog.SpotsDialog

open class BaseActivity : AppCompatActivity() {
    private var mAlertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAlertDialog = SpotsDialog(this)
    }

    // AlertDialogの表示
    @JvmOverloads
    fun showAlertDialog(msg: String? = "loading") {
        if (mAlertDialog == null) {
            mAlertDialog = SpotsDialog(this)
        }

        mAlertDialog!!.setCancelable(false)
        if (!mAlertDialog!!.isShowing) {
            mAlertDialog!!.show()
        }
    }

    // AlertDialogの消去
    fun dismissAlertDialog() {
        if (mAlertDialog != null && mAlertDialog!!.isShowing) {
            mAlertDialog!!.dismiss()
        }
    }

    // 画面の再読み込み
    fun reload() {
        val intent = intent
        overridePendingTransition(0, 0)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()

        overridePendingTransition(0, 0)
        startActivity(intent)
    }
}