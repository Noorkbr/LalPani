package com.example.lalpani.DataLayer


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.example.lalpani.DomainLayer.Drink


@Keep
data class ResponseDrinkDto(
    @SerializedName("drinks")
    val drinks: List<Drink?>? = null
) {
    @Keep
    data class Drink(
        @SerializedName("idDrink")
        val idDrink: String? = null,
        @SerializedName("strDrink")
        val strDrink: String? = null,
        @SerializedName("strDrinkThumb")
        val strDrinkThumb: String? = null
    )
}
    fun ResponseDrinkDto.Drink.toDrinkItem(): Drink {
        return Drink(
            id =this.idDrink.toString(),

            name = this.strDrink.toString(),
            imageUrl = this.strDrinkThumb
                ?:"https://img.freepik.com/free-vector/mexican-tequila-festival-colorful-round-label_225004-1330.jpg?w=740&t=st=1726316469~exp=1726317069~hmac=3350539243d259d6e038b4740ebe0842a5e6084fa423d5abcce5036c0f156472"

        )


    }
