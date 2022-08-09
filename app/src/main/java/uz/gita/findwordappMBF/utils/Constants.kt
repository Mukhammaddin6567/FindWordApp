package uz.gita.findwordappMBF.utils

enum class PreferenceKeys(val key: String) {
    COINS_KEY("shp_coins"),
    CURRENT_POSITION("shp_position"),
    SOUND_KEY("shp_sound")
}

enum class DefaultValues(val result: Int) {
    DEFAULT_VALUE(0),
    WINNER_COINS(4)
}

enum class DurationValues(val duration:Long){
    BUTTONS_DURATION(300),
    WRONG_ANSWER_DURATION(600)
}