package com.wangle.happysing.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by wangle on 1/13/18.
 */
class SpUtils private constructor(context: Context){



    companion object {
        private val SHARED_TAG = "share_setting"

        private var shareEditor: SharedPreferences.Editor? = null
        private var sharePreference: SharedPreferences? = null

        fun init(context : Context){
            sharePreference = context.getSharedPreferences(SHARED_TAG, 0)
            shareEditor = sharePreference!!.edit()
        }

        private fun checkEditor(){
            if(shareEditor == null || sharePreference == null){
                throw RuntimeException("Please init SP.")
            }
        }

        fun put(key : String, value: Any){
            checkEditor()
            if(value is Float){
                shareEditor!!.putFloat(key, value)
            } else if(value is Boolean){
                shareEditor!!.putBoolean(key, value)
            } else if(value is Int){
                shareEditor!!.putInt(key, value)
            } else if(value is Long){
                shareEditor!!.putLong(key, value)
            } else if(value is String){
                shareEditor!!.putString(key, value)
            }

            shareEditor!!.commit()
        }

        fun get(key : String, defaultValue : Any) : Any?{
            var value : Any? = null
            if(defaultValue is Float){
                value = sharePreference!!.getFloat(key, defaultValue)
            } else if(defaultValue is Boolean){
                value = sharePreference!!.getBoolean(key, defaultValue)
            } else if(defaultValue is Int){
                value = sharePreference!!.getInt(key, defaultValue)
            } else if(defaultValue is Long){
                value = sharePreference!!.getLong(key, defaultValue)
            } else if(defaultValue is String){
                value = sharePreference!!.getString(key, defaultValue)
            }

            return value
        }
    }


}