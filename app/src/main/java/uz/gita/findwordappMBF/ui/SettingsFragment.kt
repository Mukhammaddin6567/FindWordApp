package uz.gita.findwordappMBF.ui

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.findwordappMBF.R
import uz.gita.findwordappMBF.contract.SettingsContract
import uz.gita.findwordappMBF.databinding.FragmentSettingsBinding
import uz.gita.findwordappMBF.presenter.SettingsPresenter

class SettingsFragment : Fragment(R.layout.fragment_settings), SettingsContract.View {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: SettingsContract.Presenter
    private var soundPool: SoundPool? = null
    private var sound: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        loadSoundPool()
        presenter = SettingsPresenter(this)
        presenter.init()
        return binding.root
    }

    private fun loadSoundPool() {
        val audioAttributes = AudioAttributes
            .Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        soundPool = SoundPool
            .Builder()
            .setMaxStreams(1)
            .setAudioAttributes(audioAttributes)
            .build()
        sound = soundPool!!.load(requireContext(), R.raw.click, 1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonBack.setOnClickListener {
                presenter.onClickClose()
            }
            sound.setOnCheckedChangeListener { _, isChecked ->
                presenter.changeSoundState(isChecked)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun setSoundState(state: Boolean) {
        binding.sound.isChecked = state
    }

    override fun emitSound() {
        soundPool?.play(sound, 1f, 1f, 1, 0, 1f)
    }

    override fun close() {
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        soundPool = null
    }
}