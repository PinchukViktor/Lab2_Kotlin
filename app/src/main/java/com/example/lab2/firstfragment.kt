package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animal.Animal_DataClass
import com.example.animal.CustomAdapter
import com.example.lab2.databinding.FragmentFirstfragmentBinding


class firstfragment : Fragment() ,CustomAdapter.Listener{
    private var _binding : FragmentFirstfragmentBinding? = null
    private val binding get() = _binding!!
    var MyAnimals = ArrayList<Animal_DataClass>()
    lateinit var adapter: CustomAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cat = Animal_DataClass("Barbos","Cat","Цікавий факт про домашнього кота полягає в тому, що дослідження показують, що причиною муркотіння котів може бути не тільки задоволення, але і потреба відновлення кісток і м'язів після травм та травмувань. Муркотіння кота стимулює кровообіг та покращує заживлення ран.","https://www.famousbirthdays.com/faces/lyo-the-cat-image.jpg")
        var dog = Animal_DataClass("Bonya","Dog","Цікавий факт про собаку полягає в тому, що вони мають відмінний слух порівняно з людиною. Наприклад, деякі породи собак можуть чути звуки, які людина не може сприйняти, такі як ультразвукові звуки, які видає дельфін або сирена пожежної машини. Крім того, собаки можуть розрізняти різні звуки та вивчати їх значення, що дозволяє їм виконувати різні команди та розуміти мову людей.","https://zoomagazin.dp.ua/image/catalog/blog-img/ponos.jpg")
        var hedgehog = Animal_DataClass ("Harley","Hedgehog","Цікавий факт про йожика - вони мають дуже високий рівень самооборони. Коли вони відчувають небезпеку, то згортаються у тернясту кулю, що захищає їх від хижаків. Кожен йожик має близько 5000 гострих колючок на своєму тілі, які допомагають їм в цьому захисному механізмі. Крім того, вони можуть випускати залози з запахом, що відлякує ворогів і захищає їх від нападу.","https://ukr.media/static/ba/aimg/3/8/9/389577_1.jpg")

        MyAnimals.add(cat)
        MyAnimals.add(dog)
        MyAnimals.add(hedgehog)
        adapter = CustomAdapter(this ,MyAnimals, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =FragmentFirstfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(itemView: Int) {
        val bundle = bundleOf(secondfragment.number to itemView,
            secondfragment.description to MyAnimals[itemView].details,
            secondfragment.nameof to MyAnimals[itemView].titles,
            secondfragment.url to MyAnimals[itemView].URL,
            secondfragment.fulldescription to MyAnimals[itemView].desk2)
        findNavController().navigate(R.id.action_firstfragment_to_secondfragment, bundle)

    }
}
