package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

//        leagueNextBtn.setOnClickListener {
//            val skillIntent = Intent(this, SkillActivity::class.java)
//            startActivity(skillIntent)
//        }
    }

    fun onMensClicked(view: View) {
        womensButton.isChecked = false
        coedButton.isChecked = false

        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensButton.isChecked = false
        coedButton.isChecked = false

        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        mensButton.isChecked = false
        womensButton.isChecked = false

        selectedLeague = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select a league!", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
