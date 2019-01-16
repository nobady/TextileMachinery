package com.textile.client.utils

/**
 * Created by bo on 2019/1/16.
 */
class AppConfig private constructor() {
    private val sharePrefsHelps = SharePrefsHelps("App_config_info")

    companion object {
        val instance = Singleton.holder
        private const val APP_LANGUAGE_KEY = "APP_LANGUAGE"
    }

    private object Singleton {
        val holder = AppConfig()
    }

    fun setLanguage(isEnglish: Boolean) {
        sharePrefsHelps.putBoolean(APP_LANGUAGE_KEY, isEnglish)
    }

    fun isEnglish(): Boolean {
        return sharePrefsHelps.getBoolean(APP_LANGUAGE_KEY)
    }
}