package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.Converter

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoe = MutableLiveData<Shoe>()
    val shoe : LiveData<Shoe>
        get() = _shoe

    private val initialShoeList : MutableList<Shoe> = mutableListOf(
        Shoe(
            name="Air Jordan 1 Low",
            size = 40.5,
            company = "Nike",
            description = "Inspired by the original that debuted in 1985, the Air Jordan 1 Low " +
                    "offers a clean, classic look that's familiar yet always fresh. It's made for " +
                    "casual mode, with an iconic design that goes with everything and never " +
                    "goes out of style.",
            images = mutableListOf("An encapsulated Air-Sole unit provides lightweight cushioning.",
                "Genuine leather in the upper offers durability and a premium look.",
                "A solid-rubber outsole enhances traction on a variety of surfaces.",
                "Shown: Noble Green/White/Black/Pollen"
            )
        ),
        Shoe(
            name = "Stan Smith Shoes",
            size = 8.0,
            company = "Adidas",
            description = "Stan Smith isn't in the dictionary. Yet. But if it were? The definition " +
                    "would be something like this — effortlessly cool. Keeping feet fly since the " +
                    "'70s, these adidas shoes are iconic. Both a cultural force and a closet " +
                    "essential. With perforated 3-Stripes, a scalloped tongue and a clean white " +
                    "upper, this pair celebrates the unstoppable legacy. It's also part of our " +
                    "effort to help end plastic waste.",
            images = mutableListOf("Rubber outsole: 90% natural rubber, 10% recycled content",
            "Rubber outsole: 90% natural rubber, 10% recycled content", "Synthetic upper and lining")
        ),
        Shoe(
            name="Coco Sioux Marine Medium Heel",
            size = 38.0,
            company = "Pitillos",
            description = "Basic pumps in nappa leather with a medium heel. Minimalist and elegant," +
                    " it is available in a wide range of colors. They cannot be missing in your " +
                    "most distinguished looks.",
            images = mutableListOf("Nappa leather", "Medium Heel", "Heel height 4 cm", "Colour marine")
        ),
        Shoe(
            name="Somiedo 61 Gore-Tex",
            size = 38.0,
            company = "Chiruca",
            description = "Waterproof nubuck leather. Water-repellent laces. GORE-TEX® Performance" +
                    " Comfort lining. NG Xtra bi-density polyurethane sole. ",
            images = mutableListOf("Weight: 637 g", "Colour: green", "Trekking")
        )
    )

    init {
        _shoeList.value = initialShoeList
        _shoe.value = Shoe(name = "", company = "", description = "", size = Converter.stringToDouble(""))
    }

    // Add a new Shoe to the Shoe List
    fun addShoe() {
        _shoeList.value?.add(_shoe.value!!)
        _shoe.value = Shoe("", 0.0, "", "", mutableListOf())
    }

}