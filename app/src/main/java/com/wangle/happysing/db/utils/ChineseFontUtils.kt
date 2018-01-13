package com.wangle.happysing.db.utils

import android.content.Context
import com.wangle.happysing.db.ChineseFont
import com.wangle.happysing.db.SingInfoBean
import com.wangle.happysing.db.greendao.ChineseFontDao
import com.wangle.happysing.db.greendao.GreenDaoManager
import com.wangle.happysing.db.greendao.SingInfoBeanDao

/**
 * Created by wangle on 17-12-10.
 */
class ChineseFontUtils private constructor(mContext: Context){
    var chineseFontDao : ChineseFontDao? = null

    init {
        chineseFontDao = getDataDao(mContext)
    }

    companion object {
        @Volatile
        var instance: ChineseFontUtils? = null

        fun newInstance(mContext: Context) : ChineseFontUtils? {
            if(instance == null){
                synchronized(ChineseFontUtils::class){
                    instance = ChineseFontUtils(mContext)
                }
            }

            return instance
        }
    }

    fun getDataDao(mContext: Context) : ChineseFontDao?{
        return GreenDaoManager.getInstance(mContext)?.getDaoSession(mContext)?.chineseFontDao
    }

    fun insert(data : ChineseFont) : Boolean{
        var count : Long? = chineseFontDao?.insert(data)
        return count!! > 0
    }

    fun query() : List<ChineseFont>? {
        return chineseFontDao?.loadAll()
    }

    fun insert(dataList : List<ChineseFont>) : Boolean{
        var count : Int = 0
        for (chineseFont in dataList) {
             if(insert(chineseFont)){
                 count++
             }
        }

        return count >= dataList.size
    }
}