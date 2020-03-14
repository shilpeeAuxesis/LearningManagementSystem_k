package com.learningmanagement.ui.constant

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class Utils {
    companion object{

        val MY_PREFS_NAME: String = "LearningManagementSystem"

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