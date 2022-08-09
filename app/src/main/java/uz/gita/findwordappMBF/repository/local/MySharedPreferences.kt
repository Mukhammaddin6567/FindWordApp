package uz.gita.findwordappMBF.repository.local

import android.content.Context
import android.content.SharedPreferences
import uz.gita.findwordappMBF.utils.DefaultValues
import uz.gita.findwordappMBF.utils.PreferenceKeys

class MySharedPreferences {
    companion object {
        private var preferences: SharedPreferences? = null
        private var myPreferences: MySharedPreferences? = null

        fun init(context: Context) {
            myPreferences = MySharedPreferences()
            preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
        }

        fun getMyPreferences(): MySharedPreferences {
            return myPreferences!!
        }
    }

    var currentPosition: Int
        get() = preferences!!.getInt(
            PreferenceKeys.CURRENT_POSITION.key,
            DefaultValues.DEFAULT_VALUE.result
        )
        set(value) = preferences!!.edit().putInt(PreferenceKeys.CURRENT_POSITION.key, value).apply()

    var currentCoins: Int
        get() = preferences!!.getInt(
            PreferenceKeys.COINS_KEY.key,
            DefaultValues.DEFAULT_VALUE.result
        )
        set(value) {
            val oldValue = currentCoins
            preferences!!.edit().putInt(PreferenceKeys.COINS_KEY.key, oldValue + value).apply()
        }

    var sound: Boolean
        get() = preferences!!.getBoolean(PreferenceKeys.SOUND_KEY.key, true)
        set(value) = preferences!!.edit().putBoolean(PreferenceKeys.SOUND_KEY.key, value).apply()
}