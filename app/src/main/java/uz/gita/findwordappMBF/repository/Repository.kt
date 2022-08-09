package uz.gita.findwordappMBF.repository

import timber.log.Timber
import uz.gita.findwordappMBF.R
import uz.gita.findwordappMBF.data.data.QuestionData
import uz.gita.findwordappMBF.repository.local.MySharedPreferences
import java.util.*

class Repository {
    private val questionsList: ArrayList<QuestionData> = ArrayList()

    init {
        if (getCurrentQuestionPosition() == 0) questionsList.shuffle()
        loadData()
    }

    companion object {
        private var repository: Repository? = null

        fun initRepository() {
            if (repository != null) return
            else {
                repository = Repository()
            }
        }

        fun getRepository(): Repository {
            return repository!!
        }
    }

    private fun loadData() {
        questionsList.add(
            QuestionData(
                id = 1,
                image1 = R.drawable.photo1_1,
                image2 = R.drawable.photo1_2,
                image3 = R.drawable.photo1_3,
                image4 = R.drawable.photo1_4,
                answer = "ХОЛОД",
            )
        )
        questionsList.add(
            QuestionData(
                id = 2,
                image1 = R.drawable.photo2_1,
                image2 = R.drawable.photo2_2,
                image3 = R.drawable.photo2_3,
                image4 = R.drawable.photo2_4,
                answer = "ГРОМКО",
            )
        )
        questionsList.add(
            QuestionData(
                id = 3,
                image1 = R.drawable.photo3_1,
                image2 = R.drawable.photo3_2,
                image3 = R.drawable.photo3_3,
                image4 = R.drawable.photo3_4,
                answer = "ГОРЯЧИЙ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 4,
                image1 = R.drawable.photo4_1,
                image2 = R.drawable.photo4_2,
                image3 = R.drawable.photo4_3,
                image4 = R.drawable.photo4_4,
                answer = "МУЗЫКА",
            )
        )
        questionsList.add(
            QuestionData(
                id = 5,
                image1 = R.drawable.photo5_1,
                image2 = R.drawable.photo5_2,
                image3 = R.drawable.photo5_3,
                image4 = R.drawable.photo5_4,
                answer = "ТОЧКА",
            )
        )
        questionsList.add(
            QuestionData(
                id = 6,
                image1 = R.drawable.photo6_1,
                image2 = R.drawable.photo6_2,
                image3 = R.drawable.photo6_3,
                image4 = R.drawable.photo6_4,
                answer = "ЗАМОК",
            )
        )
        questionsList.add(
            QuestionData(
                id = 7,
                image1 = R.drawable.photo7_1,
                image2 = R.drawable.photo7_2,
                image3 = R.drawable.photo7_3,
                image4 = R.drawable.photo7_4,
                answer = "ЛЁД",
            )
        )
        questionsList.add(
            QuestionData(
                id = 8,
                image1 = R.drawable.photo8_1,
                image2 = R.drawable.photo8_2,
                image3 = R.drawable.photo8_3,
                image4 = R.drawable.photo8_4,
                answer = "ОФИЦИАНТ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 9,
                image1 = R.drawable.photo9_1,
                image2 = R.drawable.photo9_2,
                image3 = R.drawable.photo9_3,
                image4 = R.drawable.photo9_4,
                answer = "ПЕЧАТЬ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 10,
                image1 = R.drawable.photo10_1,
                image2 = R.drawable.photo10_2,
                image3 = R.drawable.photo10_3,
                image4 = R.drawable.photo10_4,
                answer = "МЕЧ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 11,
                image1 = R.drawable.photo11_1,
                image2 = R.drawable.photo11_2,
                image3 = R.drawable.photo11_3,
                image4 = R.drawable.photo11_4,
                answer = "ПОДАРОК",
            )
        )
        questionsList.add(
            QuestionData(
                id = 12,
                image1 = R.drawable.photo12_1,
                image2 = R.drawable.photo12_2,
                image3 = R.drawable.photo12_3,
                image4 = R.drawable.photo12_4,
                answer = "ВАМПИР",
            )
        )
        questionsList.add(
            QuestionData(
                id = 13,
                image1 = R.drawable.photo13_1,
                image2 = R.drawable.photo13_2,
                image3 = R.drawable.photo13_3,
                image4 = R.drawable.photo13_4,
                answer = "РОЗОВЫЙ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 14,
                image1 = R.drawable.photo14_1,
                image2 = R.drawable.photo14_2,
                image3 = R.drawable.photo14_3,
                image4 = R.drawable.photo14_4,
                answer = "ГЕРОЙ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 15,
                image1 = R.drawable.photo15_1,
                image2 = R.drawable.photo15_2,
                image3 = R.drawable.photo15_3,
                image4 = R.drawable.photo15_4,
                answer = "ВИНО",
            )
        )
        questionsList.add(
            QuestionData(
                id = 16,
                image1 = R.drawable.photo16_1,
                image2 = R.drawable.photo16_2,
                image3 = R.drawable.photo16_3,
                image4 = R.drawable.photo16_4,
                answer = "ФРУКТЫ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 17,
                image1 = R.drawable.photo17_1,
                image2 = R.drawable.photo17_2,
                image3 = R.drawable.photo17_3,
                image4 = R.drawable.photo17_4,
                answer = "ХЛОПОК",
            )
        )
        questionsList.add(
            QuestionData(
                id = 18,
                image1 = R.drawable.photo18_1,
                image2 = R.drawable.photo18_2,
                image3 = R.drawable.photo18_3,
                image4 = R.drawable.photo18_4,
                answer = "СЕРДЦЕ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 19,
                image1 = R.drawable.photo19_1,
                image2 = R.drawable.photo19_2,
                image3 = R.drawable.photo19_3,
                image4 = R.drawable.photo19_4,
                answer = "СЕКРЕТ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 20,
                image1 = R.drawable.photo20_1,
                image2 = R.drawable.photo20_2,
                image3 = R.drawable.photo20_3,
                image4 = R.drawable.photo20_4,
                answer = "ШАРИК",
            )
        )
        questionsList.add(
            QuestionData(
                id = 21,
                image1 = R.drawable.photo21_1,
                image2 = R.drawable.photo21_2,
                image3 = R.drawable.photo21_3,
                image4 = R.drawable.photo21_4,
                answer = "ЦИРК",
            )
        )
        questionsList.add(
            QuestionData(
                id = 22,
                image1 = R.drawable.photo22_1,
                image2 = R.drawable.photo22_2,
                image3 = R.drawable.photo22_3,
                image4 = R.drawable.photo22_4,
                answer = "ТУНЕЛЬ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 23,
                image1 = R.drawable.photo23_1,
                image2 = R.drawable.photo23_2,
                image3 = R.drawable.photo23_3,
                image4 = R.drawable.photo23_4,
                answer = "КОРЕНЬ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 24,
                image1 = R.drawable.photo24_1,
                image2 = R.drawable.photo24_2,
                image3 = R.drawable.photo24_3,
                image4 = R.drawable.photo24_4,
                answer = "РОСТ",
            )
        )
        questionsList.add(
            QuestionData(
                id = 25,
                image1 = R.drawable.photo25_1,
                image2 = R.drawable.photo25_2,
                image3 = R.drawable.photo25_3,
                image4 = R.drawable.photo25_4,
                answer = "КЛОУН",
            )
        )
    }

    private fun makeVariant(answer: String): String {
        val characters = arrayOf(
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
            'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'
        )
        val variant = ArrayList<Char>()
        for (i in answer.length..11) variant.add(characters[Random().nextInt(31)])
        for (i in answer.indices) variant.add(answer[i])
        var result = ""
        variant.shuffle()
        for (i in variant.indices) result += variant[i]
        Timber.d("result $result")
        return result
    }

    // connection with data
    fun getDataByPosition(position: Int): QuestionData {
        questionsList[position].variant = makeVariant(questionsList[position].answer)
        return questionsList[position]
    }

    // connection with data
    fun isAvailableDataByPosition(position: Int): Boolean = questionsList.size - 1 >= position

    // connection with sharedPreferences
    fun saveCurrentQuestionPosition(position: Int) =
        kotlin.run { MySharedPreferences.getMyPreferences().currentPosition = position }

    // connection with sharedPreferences
    fun getCurrentQuestionPosition(): Int = MySharedPreferences.getMyPreferences().currentPosition

    // connection with sharedPreferences
    fun saveCurrentCoins(coins: Int) = kotlin.run {
        MySharedPreferences.getMyPreferences().currentCoins = coins
    }

    // connection with sharedPreferences
    fun getSoundState(): Boolean = MySharedPreferences.getMyPreferences().sound

    // connection with sharedPreferences
    fun setSoundState(state: Boolean) =
        kotlin.run { MySharedPreferences.getMyPreferences().sound = state }

    // connection with sharedPreferences
    fun getCurrentCoins(): Int = MySharedPreferences.getMyPreferences().currentCoins
}