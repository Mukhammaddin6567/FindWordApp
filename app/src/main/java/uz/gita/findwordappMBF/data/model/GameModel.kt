package uz.gita.findwordappMBF.data.model

import uz.gita.findwordappMBF.contract.GameContract
import uz.gita.findwordappMBF.data.data.QuestionData
import uz.gita.findwordappMBF.repository.Repository
import uz.gita.findwordappMBF.utils.DefaultValues

class GameModel : GameContract.Model {

    private val repository: Repository = Repository.getRepository()

    override fun getDataByPosition(position: Int): QuestionData =
        repository.getDataByPosition(position)

    override fun getCurrentQuestionPosition(): Int = repository.getCurrentQuestionPosition()

    override fun getCurrentCoins(): Int = repository.getCurrentCoins()

    override fun saveQuestionPosition(position: Int) =
        repository.saveCurrentQuestionPosition(position)

    override fun saveCurrentCoins() {
        repository.saveCurrentCoins(DefaultValues.WINNER_COINS.result)
    }

    override fun canGetDataByPosition(position: Int): Boolean =
        repository.isAvailableDataByPosition(position)

    override fun canEmitSound(): Boolean = repository.getSoundState()
}