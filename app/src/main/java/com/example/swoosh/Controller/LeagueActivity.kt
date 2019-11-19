package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    // we save our current state into outstate when we rotate
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        // safe call on outstate because Bundle is nullable
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

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

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensButton.isChecked = false
        coedButton.isChecked = false

        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        mensButton.isChecked = false
        womensButton.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if ( player.league != "") {
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        } else {
            Toast.makeText(this, "Please select a league!", Toast.LENGTH_SHORT)
                .show()
        }

    }
}
