package com.wangle.happysing.learning.chinese

import android.content.Context
import com.wangle.happysing.db.ChineseFont
import com.wangle.happysing.db.utils.ChineseFontUtils
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by wangle on 1/13/18.
 */
class ChineseContentManager private constructor(){

    companion object {
        @Volatile
        var instance: ChineseContentManager? = null

        fun newInstance() : ChineseContentManager? {
            if(instance == null){
                synchronized(ChineseContentManager::class){
                    instance = ChineseContentManager()
                }
            }

            return instance
        }
    }

    fun insertData(context: Context){
        var wordList = ArrayList<ChineseFont>()
        wordList.add(ChineseFont("一", "yi"))
        wordList.add(ChineseFont("二", "er"))
        wordList.add(ChineseFont("三", "san"))
        wordList.add(ChineseFont("四", "shi"))
        wordList.add(ChineseFont("五", "wu"))
        wordList.add(ChineseFont("六", "liu"))
        wordList.add(ChineseFont("七", "qi"))
        wordList.add(ChineseFont("八", "ba"))
        wordList.add(ChineseFont("九", "jiu"))
        wordList.add(ChineseFont("十", "shi"))
        wordList.add(ChineseFont("胡", "hu"))
        wordList.add(ChineseFont("恩", "en"))
        wordList.add(ChineseFont("兰", "lan"))
        wordList.add(ChineseFont("思", "si"))
        wordList.add(ChineseFont("汪", "wang"))
        wordList.add(ChineseFont("华", "hua"))
        wordList.add(ChineseFont("江", "jiang"))
        wordList.add(ChineseFont("良", "liang"))
        wordList.add(ChineseFont("玲", "ling"))
        wordList.add(ChineseFont("张", "zhang"))
        wordList.add(ChineseFont("鹏", "peng"))
        wordList.add(ChineseFont("老", "lao"))
        wordList.add(ChineseFont("父", "fu"))
        wordList.add(ChineseFont("姑", "gu"))
        wordList.add(ChineseFont("爸", "ba"))
        wordList.add(ChineseFont("妈", "ma"))
        wordList.add(ChineseFont("神", "shen"))
        wordList.add(ChineseFont("爱", "ai"))
        wordList.add(ChineseFont("世", "shi"))
        wordList.add(ChineseFont("人", "ren"))
        wordList.add(ChineseFont("你", "ni"))
        wordList.add(ChineseFont("我", "wo"))
        wordList.add(ChineseFont("他", "ta"))
        wordList.add(ChineseFont("她", "ta"))

        ChineseFontUtils.newInstance(context)!!.insert(wordList)
    }
}