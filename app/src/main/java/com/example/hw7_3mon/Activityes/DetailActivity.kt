package com.example.hw7_3mon.Activityes

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Draft
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.hw7_3mon.R
import com.example.hw7_3mon.databinding.ActivityDetailBinding
import com.google.android.material.navigation.NavigationView
import java.io.IOException

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val singer = intent.getStringExtra("singer")
        binding.tvName.text = name
        binding.tvSinger.text = singer

        onClick()
    }

    private fun onClick() {
        binding.btnPlay.setOnClickListener {
            playAudio()
        }
        binding.btnPause.setOnClickListener {
            pauseAudio()
        }
    }

    private fun playAudio() {
        val audioURL = "https://www.google.com/search?q=baby+mama&sca_esv=578796015&sxsrf=AM9HkKmQIbRM-a-h7kCYEhw2ISp9JxWzRw%3A1698924604751&ei=PIhDZea-Lci9wPAP0puRmAw&gs_ssp=eJzj4tVP1zc0zEpJSrIsyks3YPTiTEpMqlTITcxNBABqyggv&oq=baby+mama&gs_lp=Egxnd3Mtd2l6LXNlcnAiCWJhYnkgbWFtYSoCCAEyBRAAGIAEMgUQLhiABDIFEAAYgAQyBRAAGIAEMgUQABiABDIIEAAYywEYgAQyCBAAGMsBGIAEMggQLhjLARiABDIIEAAYywEYgAQyCBAuGMsBGIAEMhQQLhiABBiXBRjcBBjeBBjgBNgBAUiGQ1AAWIM1cAJ4AZABAJgBwQGgAaUNqgEEMC4xMbgBAcgBAPgBAcICBxAjGIoFGCfCAg4QLhiABBixAxjHARivAcICCBAuGIAEGLEDwgILEC4YgAQYxwEY0QPCAhEQLhiABBixAxiDARjHARjRA8ICCxAAGIAEGLEDGIMBwgIHEAAYigUYQ8ICDRAuGIoFGMcBGNEDGEPCAgoQABiABBgUGIcCwgILEC4YgAQYsQMYgwHCAg0QLhiDARixAxiKBRhDwgIcEC4YgwEYsQMYigUYQxiXBRjcBBjeBBjgBNgBAcICIBAuGIAEGLEDGIMBGMcBGNEDGJcFGNwEGN4EGOAE2AEBwgILEC4YrwEYxwEYgATCAgcQLhiKBRhDwgINEC4YgAQYFBiHAhixA8ICFhAuGIoFGEMYlwUY3AQY3gQY4ATYAQHCAhoQLhiABBixAxiDARiXBRjcBBjeBBjgBNgBAcICCxAuGIMBGLEDGIAEwgILEC4YgAQYxwEYrwHCAgoQLhiABBgUGIcC4gMEGAAgQYgGAboGBggBEAEYFA&sclient=gws-wiz-serp"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setAudioStreamType(AudioManager.STREAM_MUSIC)

        try {
            mediaPlayer!!.setDataSource(audioURL)
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()

        }catch (e: IOException){
            e.printStackTrace()
        }

        Toast.makeText(this, "Audio started playing", Toast.LENGTH_SHORT).show()
    }

    private fun pauseAudio(){
        if (mediaPlayer!!.isPlaying){
            mediaPlayer!!.stop()
            mediaPlayer!!.reset()
            mediaPlayer!!.release()
        }else{
            Toast.makeText(this, "Audio has not played", Toast.LENGTH_SHORT).show()
        }
    }
}