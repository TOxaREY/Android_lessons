package com.example.p0211twoactivity

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

class Metrica: Application() {

    override fun onCreate() {
        super.onCreate()
        val config: YandexMetricaConfig = YandexMetricaConfig.newConfigBuilder("82aa6012-cada-42a1-b41d-89d4a756ffc0").build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}