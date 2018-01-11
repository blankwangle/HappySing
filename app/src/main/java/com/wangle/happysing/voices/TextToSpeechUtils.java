package com.wangle.happysing.voices;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

/**
 * Created by wangle on 17-12-20.
 */

public class TextToSpeechUtils {
    private TextToSpeech textToSpeech;

    private static TextToSpeechUtils textToSpeechUtils;

    public static TextToSpeechUtils getInstance(Context context) {
        if(textToSpeechUtils == null){
            textToSpeechUtils = new TextToSpeechUtils(context);
        }
        return textToSpeechUtils;
    }

    public TextToSpeechUtils(Context context){
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    textToSpeech.setLanguage(Locale.US);
                    textToSpeech.setPitch(1.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.setSpeechRate(1.0f);
                }
            }
        });
    }

    public void speakText(String text) {
        if (textToSpeech != null) {
            textToSpeech.speak(text,
                    TextToSpeech.QUEUE_FLUSH, null);
        }

    }

}
