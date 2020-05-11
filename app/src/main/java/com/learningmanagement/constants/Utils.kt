package com.learningmanagement.constants

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import android.widget.Toast
import com.learningmanagement.R

class Utils {
    companion object{
        val TAG ="Utils"
        val MY_PREFS_NAME: String = "LearningManagementSystem"
        private lateinit var progressDialogBuilder: AlertDialog.Builder
        private lateinit var progressDialog: AlertDialog

        fun showLoading(context: Context){
            progressDialogBuilder = AlertDialog.Builder(context)
            progressDialogBuilder.setCancelable(false) // if you want user to wait for some process to finish,
            progressDialogBuilder.setView(R.layout.layout_loading_dialog)
            progressDialog = progressDialogBuilder.create()
            progressDialog.show()
        }

        /**
         * @action hide progress loader
         */
        fun hideLoading(){
            try {
                progressDialog.dismiss()
            }catch (ex: java.lang.Exception){
                Log.e(TAG, ex.toString())
            }

        }

        fun showLongToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        public fun isInternetConnected(mContext: Context): Boolean {
            val connectivity =
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivity != null) {
                val info = connectivity.allNetworkInfo
                if (info != null)
                    for (i in info)
                        if (i.state == NetworkInfo.State.CONNECTED) {
                            return true
                        }
            }
            return false
        }

        fun setPreference(mContext: Context, key: String, value: String) {
            val editor = mContext.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun getPreference(mContext: Context, key: String): String? {
            val prefs = mContext.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE)
            return prefs.getString(key, "")
        }

    }

}