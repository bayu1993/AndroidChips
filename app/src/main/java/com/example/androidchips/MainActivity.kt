package com.example.androidchips

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chipGroup = ChipGroup(this)
        val gender = arrayOf("Mursit", "Iqbal", "Aji", "Ulhaq", "Efa","Iqbal", "Aji", "Ulhaq", "Efa")
        val choice = mutableListOf<String>()
        for (i in gender.indices) {
            val chip = Chip(this)
            val chipDrawable = ChipDrawable.createFromAttributes(
                this,
                null,
                0,
                R.style.ChipsTheme
            )
            chip.setChipDrawable(chipDrawable)
            chip.text = gender[i]
            chipGroup.addView(chip)
        }

        parent_chips.addView(chipGroup)

        for (index in 0 until chipGroup.childCount) {
            val chip: Chip = chipGroup.getChildAt(index) as Chip
            chip.setOnCheckedChangeListener { view, isChecked ->
                if (isChecked) choice.add(view.text.toString())
                else choice.remove(view.text.toString())
            }
        }

        btn_submit.setOnClickListener {
            var result = ""
            for (i in choice.indices) {
                result += "${choice[i]}\n"
            }

            tv_result.text = result
        }
    }
}
