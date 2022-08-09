package uz.gita.findwordappMBF.presenter

import uz.gita.findwordappMBF.contract.MainContract
import uz.gita.findwordappMBF.data.model.MainModel

class MainPresenter(private val view: MainContract.View) : MainContract.Presenter {
    private val model: MainContract.Model by lazy { MainModel() }
    private val soundState = model.canEmitSound()

    override fun init() {
        view.setCurrentCoins(model.getCurrentCoins())
        view.setImages(model.getImages())
        view.setCurrentQuestionPosition((model.getQuestionPosition()))
    }

    override fun onClickStart() {
        if (soundState) view.emitSound()
        view.navigateToGamScreen()
    }

    override fun onClickSettings() {
        if (soundState) view.emitSound()
        view.navigateToSettingsScreen()
    }

}