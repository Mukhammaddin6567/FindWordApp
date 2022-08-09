package uz.gita.findwordappMBF.ui

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import timber.log.Timber
import uz.gita.findwordappMBF.R
import uz.gita.findwordappMBF.contract.MainContract
import uz.gita.findwordappMBF.databinding.FragmentMainBinding
import uz.gita.findwordappMBF.presenter.MainPresenter

class MainFragment : Fragment(R.layout.fragment_main), MainContract.View {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MainContract.Presenter
    private var soundPool: SoundPool? = null
    private var sound: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        presenter = MainPresenter(this)
        loadSoundPool()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeViewBinding(binding)
    }

    override fun onResume() {
        Timber.d("onResume()")
        super.onResume()
        presenter.init()
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

    private fun subscribeViewBinding(binding: FragmentMainBinding) = with(binding) {
        buttonStart.setOnClickListener {
            presenter.onClickStart()
        }
        buttonSettings.setOnClickListener {
            presenter.onClickSettings()
        }
    }

    override fun navigateToGamScreen() {
        findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
    }

    override fun navigateToSettingsScreen() {
        findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
    }

    override fun setCurrentQuestionPosition(position: Int) {
        val getPosition = (position + 1).toString()
        binding.textPosition.text = getPosition
    }

    override fun setImages(images: List<Int>) {
        with(binding) {
            image1.setImageResource(images[0])
            image2.setImageResource(images[1])
            image3.setImageResource(images[2])
            image4.setImageResource(images[3])
        }
    }

    override fun setCurrentCoins(coins: Int) {
        binding.currentCoins.text = coins.toString()
    }

    override fun emitSound() {
        soundPool?.play(sound, 1f, 1f, 1, 0, 1f)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}