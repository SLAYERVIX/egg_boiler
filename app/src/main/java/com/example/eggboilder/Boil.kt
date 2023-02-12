package com.example.eggboilder

data class Boil(
    val time: Int
) {
    companion object {
        val list = mutableListOf<Boil>(
            Boil(3),
            Boil(4),
            Boil(5),
            Boil(6),
            Boil(8)
        )
    }

}
