package com.example.hw7_3mon.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw7_3mon.Activityes.DetailActivity
import com.example.hw7_3mon.Model.Music
import com.example.hw7_3mon.Adapter.MusicAdapter
import com.example.hw7_3mon.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    private val musicList = arrayListOf(
        Music("1", "Baby mama", "Скриптонит", "3:52"),
        Music("2", "Животные", "Скриптонит", "3:03"),
        Music("3", "Ламбада", "Скриптонит", "3:11"),
        Music("4", "Старшие", "OG Buda", "4:03"),
        Music("5", "Бандит", "OG Buda", "3:46"),
        Music("6", "Сайфер", "OG Buda", "2:39"),
        Music("7", "Vlaga", "Big Baby Tape", "2:33"),
        Music("8", "Bandana", "Big Baby Tape", "2:32"),
        Music("9", "Trap Luv", "Big Baby Tape", "2:28"),
        Music("10", "Crocko Laco", "Ulukmanapo", "3:27"),
        Music("11", "Каганат", "Ulukmanapo", "3:13"),
        Music("12", "Плотно", "Ulukmanapo", "3:13")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = MusicAdapter(musicList, this::onClick)
        binding.rvMusic.adapter = adapter
    }

    private fun onClick(pos:Int){
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("key2", pos)
        startActivity(intent)
    }
}