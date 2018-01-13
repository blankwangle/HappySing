package com.wangle.happysing.app

import android.app.Application
import android.content.Context
import com.wangle.happysing.learning.chinese.ChineseContentManager
import com.wangle.happysing.utils.SpUtils

/**
 * Created by wangle on 1/13/18.
 */
class App : Application(){

    var appContext: Context? = null

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    private fun init(){
        SpUtils.init(appContext!!)
    }

    private fun initWordsToDatabase(){
        var isInstalledfirst: Boolean = SpUtils.get(SpConstKey.INSTALLED_FIRST_OPEN, false) as Boolean
        if(isInstalledfirst){
            ChineseContentManager.newInstance()!!.insertData(appContext!!)
        }
    }

}