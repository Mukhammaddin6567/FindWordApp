package uz.gita.findwordappMBF.data.model

import uz.gita.findwordappMBF.contract.MainContract
import uz.gita.findwordappMBF.repository.Repository

class MainModel : MainContract.Model {
    private val repository: Repository = Repository.getRepository()

    override fun getImages(): List<Int> {
        val position = repository.getCurrentQuestionPosition()
        val data = repository.getDataByPosition(position)

        val images = ArrayList<Int>()
        images.add(data.image1)
        images.add(data.image2)
        images.add(data.image3)
        images.add(data.image4)

        return images
    }

    override fun getQuestionPosition(): Int = repository.getCurrentQuestionPosition()

    override fun getCurrentCoins(): Int = repository.getCurrentCoins()

    override fun canEmitSound(): Boolean = repository.getSoundState()
}