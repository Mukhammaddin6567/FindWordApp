package uz.gita.findwordappMBF.ui

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import timber.log.Timber
import uz.gita.findwordappMBF.R
import uz.gita.findwordappMBF.contract.GameContract
import uz.gita.findwordappMBF.databinding.FragmentGameBinding
import uz.gita.findwordappMBF.presenter.GamePresenter
import kotlin.properties.Delegates


class GameFragment : Fragment(R.layout.fragment_game), GameContract.View,
    View.OnClickListener {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private lateinit var presenter: GameContract.Presenter
    private var soundPool: SoundPool? = null
    private var soundAnswer by Delegates.notNull<Int>()
    private var soundVariant by Delegates.notNull<Int>()
    private var soundSuccess by Delegates.notNull<Int>()
    private var soundWrong by Delegates.notNull<Int>()
    private var soundCoins by Delegates.notNull<Int>()
    private var soundClick by Delegates.notNull<Int>()

    private val answers: ArrayList<TextView> = ArrayList()
    private val variants: ArrayList<TextView> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        subscribeViewBinding(binding)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = GamePresenter(this)
        presenter.init()
    }

    private fun subscribeViewBinding(binding: FragmentGameBinding) = with(binding) {
        buttonBack.setOnClickListener {
            presenter.onClickBack()
        }

        answers.add(answer1)
        answers.add(answer2)
        answers.add(answer3)
        answers.add(answer4)
        answers.add(answer5)
        answers.add(answer6)
        answers.add(answer7)
        answers.add(answer8)

        answer1.setOnClickListener(this@GameFragment)
        answer2.setOnClickListener(this@GameFragment)
        answer3.setOnClickListener(this@GameFragment)
        answer4.setOnClickListener(this@GameFragment)
        answer5.setOnClickListener(this@GameFragment)
        answer6.setOnClickListener(this@GameFragment)
        answer7.setOnClickListener(this@GameFragment)
        answer8.setOnClickListener(this@GameFragment)

        variants.add(variant1)
        variants.add(variant2)
        variants.add(variant3)
        variants.add(variant4)
        variants.add(variant5)
        variants.add(variant6)
        variants.add(variant7)
        variants.add(variant8)
        variants.add(variant9)
        variants.add(variant10)
        variants.add(variant11)
        variants.add(variant12)

        variant1.setOnClickListener(this@GameFragment)
        variant2.setOnClickListener(this@GameFragment)
        variant3.setOnClickListener(this@GameFragment)
        variant4.setOnClickListener(this@GameFragment)
        variant5.setOnClickListener(this@GameFragment)
        variant6.setOnClickListener(this@GameFragment)
        variant7.setOnClickListener(this@GameFragment)
        variant8.setOnClickListener(this@GameFragment)
        variant9.setOnClickListener(this@GameFragment)
        variant10.setOnClickListener(this@GameFragment)
        variant11.setOnClickListener(this@GameFragment)
        variant12.setOnClickListener(this@GameFragment)
    }

    override fun setImagesByPosition(images: List<Int>) {
        with(binding) {
            image1.setImageResource(images[0])
            image2.setImageResource(images[1])
            image3.setImageResource(images[2])
            image4.setImageResource(images[3])
        }
    }

    override fun setVariantsByPosition(variant: List<Char>) {
        for (i in variant.indices) {
            Timber.d("variant $variant")
            variants[i].text = variant[i].toString()
        }
    }

    override fun setCurrentQuestionPosition(position: Int) {
        val currentPosition = position.toString()
        binding.textLevel.text = currentPosition
    }

    override fun setCurrentAnswerLength(length: Int) {
        for (i in 0 until length) {
            answers[i].visibility = View.VISIBLE
        }
        for (i in length until answers.size) {
            answers[i].visibility = View.GONE
        }
    }

    override fun setCurrentCoinsValue(coins: Int) {
        binding.currentCoins.text = coins.toString()
    }

    override fun clearAnswersAndVariants() {
        for (i in 0 until answers.size) {
            answers[i].text = ""
        }

        for (i in 0 until answers.size) {
            answers[i].isEnabled = false
        }

        for (i in 0 until variants.size) {
            variants[i].isEnabled = true
        }
    }

    override fun disableAnswerButtonByPosition(position: Int) {
        answers[position].isEnabled = false
        answers[position].text = ""
    }

    override fun disableVariantButtonByPosition(position: Int) {
        variants[position].isEnabled = false
        variants[position].text = ""
    }

    override fun setLetterToAnswerButtonByPosition(position: Int, letter: Char) {
        answers[position].isEnabled = true
        answers[position].text = letter.toString()
    }

    override fun setLetterToVariantButtonByPosition(position: Int, letter: Char) {
        variants[position].isEnabled = true
        variants[position].text = letter.toString()
    }

    override fun playAnimButtonAnswer(position: Int) {
        YoYo.with(Techniques.Pulse).duration(300).playOn(answers[position])
    }

    override fun playAnimButtonVariant(position: Int) {
        YoYo.with(Techniques.Pulse).duration(300).playOn(variants[position])
    }

    override fun playAnimWrongAnswer() {
        YoYo.with(Techniques.Shake).duration(600).playOn(binding.containerAnswers)
    }

    override fun createSoundPool() {
        val audioAttributes = AudioAttributes
            .Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        soundPool = SoundPool
            .Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        soundAnswer = soundPool!!.load(requireContext(), R.raw.remove_letter, 1)
        soundVariant = soundPool!!.load(requireContext(), R.raw.insert_letter, 1)
        soundWrong = soundPool!!.load(requireContext(), R.raw.wrong_word, 1)
        soundSuccess = soundPool!!.load(requireContext(), R.raw.success_level, 1)
        soundCoins = soundPool!!.load(requireContext(), R.raw.collect_coins, 1)
        soundClick = soundPool!!.load(requireContext(), R.raw.click, 1)
    }

    override fun emitSoundSuccess() {
        soundPool?.play(soundSuccess, 1f, 1f, 1, 0, 1f)
    }

    override fun emitSoundWrong() {
        soundPool?.play(soundWrong, 1f, 1f, 1, 0, 1f)
    }

    override fun emitSoundVariant() {
        soundPool?.play(soundVariant, 1f, 1f, 1, 0, 1f)
    }

    override fun emitSoundAnswer() {
        soundPool?.play(soundAnswer, 1f, 1f, 1, 0, 1f)
    }

    override fun emitSoundCoins() {
        soundPool?.play(soundCoins, 1f, 1f, 1, 0, 1f)
    }

    override fun emitSoundClick() {
        soundPool?.play(soundClick, 1f, 1f, 1, 0, 1f)
    }

    override fun enableWinnerLayout() {
        val rotate = RotateAnimation(
            0F, 360F,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotate.duration = 3600
        rotate.repeatCount = Animation.INFINITE

        val animation =
            android.view.animation.AnimationUtils.loadAnimation(
                requireContext(),
                R.anim.anim_slide_from_top_to_center
            )

        with(binding) {
            buttonBack.visibility = View.INVISIBLE
            imageLevel.visibility = View.INVISIBLE
            textLevel.visibility = View.INVISIBLE
            toolbar.visibility = View.INVISIBLE
            currentCoins.visibility = View.INVISIBLE
            flowVariants.visibility = View.INVISIBLE
            answers.forEach { it.isEnabled =false }

            viewBackground.visibility = View.VISIBLE
            viewGreetings.visibility = View.VISIBLE
            viewGreetings.startAnimation(animation)
            textGreetings.visibility = View.VISIBLE
            textGreetings.startAnimation(animation)
            imageRays.visibility = View.VISIBLE
            imageRays.startAnimation(rotate)
            buttonContinue.visibility = View.VISIBLE
            buttonContinue.setOnClickListener {
                presenter.onClickContinue()
            }
            iconCoin.visibility = View.VISIBLE
            coinsCount.visibility = View.VISIBLE
        }
    }

    override fun disableWinnerLayout() {
        with(binding) {
            viewBackground.visibility = View.GONE
            viewGreetings.visibility = View.GONE
            textGreetings.visibility = View.GONE
            imageRays.visibility = View.GONE
            imageRays.clearAnimation()
            buttonContinue.visibility = View.GONE
            iconCoin.visibility = View.GONE
            coinsCount.visibility = View.GONE

            buttonBack.visibility = View.VISIBLE
            imageLevel.visibility = View.VISIBLE
            textLevel.visibility = View.VISIBLE
            toolbar.visibility = View.VISIBLE
            currentCoins.visibility = View.VISIBLE
            YoYo.with(Techniques.BounceIn).duration(600).playOn(currentCoins)
            answers.forEach { it.isEnabled =false }
            flowVariants.visibility = View.VISIBLE
        }
    }

    override fun popBackStack() {
        findNavController().popBackStack()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            answers[0].id -> {
                Timber.d("clicked answer button: 0")
                presenter.clickedAnswerButton(0)
            }
            answers[1].id -> {
                Timber.d("clicked answer button: 1")
                presenter.clickedAnswerButton(1)
            }
            answers[2].id -> {
                Timber.d("clicked answer button: 2")
                presenter.clickedAnswerButton(2)
            }
            answers[3].id -> {
                Timber.d("clicked answer button: 3")
                presenter.clickedAnswerButton(3)
            }
            answers[4].id -> {
                Timber.d("clicked answer button: 4")
                presenter.clickedAnswerButton(4)
            }
            answers[5].id -> {
                Timber.d("clicked answer button: 5")
                presenter.clickedAnswerButton(5)
            }
            answers[6].id -> {
                Timber.d("clicked answer button: 6")
                presenter.clickedAnswerButton(6)
            }
            answers[7].id -> {
                Timber.d("clicked answer button: 7")
                presenter.clickedAnswerButton(7)
            }
            variants[0].id -> {
                Timber.d("clicked variant button: 1")
                presenter.clickedVariantButton(0)
            }
            variants[1].id -> {
                Timber.d("clicked variant button: 2")
                presenter.clickedVariantButton(1)
            }
            variants[2].id -> {
                Timber.d("clicked variant button: 3")
                presenter.clickedVariantButton(2)
            }
            variants[3].id -> {
                Timber.d("clicked variant button: 4")
                presenter.clickedVariantButton(3)
            }
            variants[4].id -> {
                Timber.d("clicked variant button: 5")
                presenter.clickedVariantButton(4)
            }
            variants[5].id -> {
                Timber.d("clicked variant button: 6")
                presenter.clickedVariantButton(5)
            }
            variants[6].id -> {
                Timber.d("clicked variant button: 7")
                presenter.clickedVariantButton(6)
            }
            variants[7].id -> {
                Timber.d("clicked variant button: 8")
                presenter.clickedVariantButton(7)
            }
            variants[8].id -> {
                Timber.d("clicked variant button: 9")
                presenter.clickedVariantButton(8)
            }
            variants[9].id -> {
                Timber.d("clicked variant button: 10")
                presenter.clickedVariantButton(9)
            }
            variants[10].id -> {
                Timber.d("clicked variant button: 11")
                presenter.clickedVariantButton(10)
            }
            variants[11].id -> {
                Timber.d("clicked variant button: 12")
                presenter.clickedVariantButton(11)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}