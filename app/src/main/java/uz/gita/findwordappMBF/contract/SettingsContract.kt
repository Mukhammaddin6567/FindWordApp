package uz.gita.findwordappMBF.contract


interface SettingsContract {

    interface Model {
        fun canEmitSound(): Boolean
        fun saveSoundState(state: Boolean)
    }

    interface View {
        fun setSoundState(state: Boolean)
        fun emitSound()
        fun close()
    }

    interface Presenter {
        fun init()
        fun changeSoundState(state: Boolean)
        fun onClickClose()
    }

}