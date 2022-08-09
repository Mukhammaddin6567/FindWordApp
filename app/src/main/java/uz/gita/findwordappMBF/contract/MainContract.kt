package uz.gita.findwordappMBF.contract


// Model | View | Presenter
interface MainContract {

    interface Model {
        fun getImages(): List<Int>
        fun getQuestionPosition(): Int
        fun getCurrentCoins(): Int
        fun canEmitSound(): Boolean
    }

    interface View {
        fun navigateToGamScreen()
        fun navigateToSettingsScreen()

        fun setCurrentQuestionPosition(position: Int)
        fun setImages(images: List<Int>)
        fun setCurrentCoins(coins: Int)

        fun emitSound()
    }

    interface Presenter {
        fun init()
        fun onClickStart()
        fun onClickSettings()
    }

}