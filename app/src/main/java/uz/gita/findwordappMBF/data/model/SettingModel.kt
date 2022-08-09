package uz.gita.findwordappMBF.data.model

import uz.gita.findwordappMBF.contract.SettingsContract
import uz.gita.findwordappMBF.repository.Repository

class SettingModel : SettingsContract.Model {

    private val repository by lazy { Repository.getRepository() }

    override fun canEmitSound(): Boolean = repository.getSoundState()

    override fun saveSoundState(state: Boolean) = kotlin.run { repository.setSoundState(state) }
}