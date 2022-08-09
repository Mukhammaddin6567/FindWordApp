package uz.gita.findwordappMBF.presenter

import uz.gita.findwordappMBF.contract.SettingsContract
import uz.gita.findwordappMBF.data.model.SettingModel

class SettingsPresenter(private val view: SettingsContract.View) : SettingsContract.Presenter {

    private val model: SettingsContract.Model = SettingModel()

    override fun init() = kotlin.run { view.setSoundState(model.canEmitSound()) }

    override fun changeSoundState(state: Boolean) {
        if (state) view.emitSound()
        model.saveSoundState(state)
    }

    override fun onClickClose() {
        if (model.canEmitSound()) view.emitSound()
        view.close()
    }
}
