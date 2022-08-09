package uz.gita.findwordappMBF.presenter

import timber.log.Timber
import uz.gita.findwordappMBF.contract.GameContract
import uz.gita.findwordappMBF.data.model.GameModel
import uz.gita.findwordappMBF.repository.local.MySharedPreferences

class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {

    private val model: GameContract.Model = GameModel()

    private val images: ArrayList<Int> = ArrayList()

    private var currentPosition: Int = 0
    private var answer: String = ""
    private var variant: String = ""

    private var tagAnswer: StringBuilder = StringBuilder()
    private var tagVariant: StringBuilder = StringBuilder()

    private val soundState: Boolean = model.canEmitSound()

    override fun init() {
        Timber.d("MySharedPreferences.getMyPreferences().currentPosition " + MySharedPreferences.getMyPreferences().currentPosition)
        currentPosition = model.getCurrentQuestionPosition()
        if (soundState) view.createSoundPool()
        loadData()
    }

    override fun loadData() {
        if (!model.canGetDataByPosition(currentPosition)) {
            currentPosition = 0
            model.saveQuestionPosition(currentPosition)
        }

        view.clearAnswersAndVariants()

        val data = model.getDataByPosition(currentPosition)

        answer = data.answer
        tagAnswer = StringBuilder("########".substring(0, data.answer.length))
        variant = data.variant
        tagVariant = StringBuilder("############")

        images.clear()
        images.add(data.image1)
        images.add(data.image2)
        images.add(data.image3)
        images.add(data.image4)

        view.setCurrentQuestionPosition(currentPosition + 1)
        view.setCurrentCoinsValue(model.getCurrentCoins())
        view.setImagesByPosition(images)
        view.setCurrentAnswerLength(data.answer.length)
        view.setVariantsByPosition(data.variant.toList())
    }

    override fun clickedAnswerButton(position: Int) {
        if (soundState) view.emitSoundAnswer()
        view.playAnimButtonAnswer(position)
        val letter = tagAnswer[position]
        Timber.d("___________________________________")
        Timber.d("letter: $letter")
        val indexOfTagVariant = tagVariant.indexOf(letter)
        Timber.d("indexOfTagVariant: $indexOfTagVariant")
        tagVariant.setCharAt(indexOfTagVariant, '#')
        Timber.d("tagVariant: $tagVariant")
        tagAnswer.setCharAt(position, '#')
        Timber.d("tagAnswer: $tagAnswer")
        view.disableAnswerButtonByPosition(position)
        view.setLetterToVariantButtonByPosition(indexOfTagVariant, letter)
    }

    override fun clickedVariantButton(position: Int) {
        val letter = variant[position]
        Timber.d("___________________________________")
        Timber.d("letter: $letter")
        val indexOfTagAnswer = tagAnswer.indexOf("#")
        Timber.d("indexOfTagAnswer: $indexOfTagAnswer")
        if (indexOfTagAnswer >= 0) {
            if (soundState) view.emitSoundVariant()
            view.playAnimButtonVariant(position)
            tagAnswer.setCharAt(indexOfTagAnswer, letter)
            Timber.d("tagAnswer: $tagAnswer")
            tagVariant.setCharAt(position, letter)
            Timber.d("tagVariant: $tagVariant")
            view.setLetterToAnswerButtonByPosition(indexOfTagAnswer, letter)
            view.disableVariantButtonByPosition(position)
        }
        if (hasFinished()) check()
    }

    override fun onClickContinue() {
        view.emitSoundCoins()
        view.disableWinnerLayout()
        model.saveCurrentCoins()
        currentPosition++
        model.saveQuestionPosition(currentPosition)
        loadData()
    }

    private fun hasFinished(): Boolean = !tagAnswer.toString().contains("#")

    private fun check() {
        when (answer) {
            tagAnswer.toString() -> {
                if (soundState) view.emitSoundSuccess()
                view.enableWinnerLayout()
            }
            else -> {
                if (soundState) view.emitSoundWrong()
                view.playAnimWrongAnswer()
            }
        }
    }

    override fun onClickBack() {
        if (soundState) view.emitSoundClick()
        view.popBackStack()
    }

}