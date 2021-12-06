package com.example.recyclerview

class MovieGenerator {

    private val friends = R.drawable.friends
    private val twoAndHalfMan = R.drawable.two_and_half_man
    private val badBoys = R.drawable.bad_boys
    private val bayWatch = R.drawable.baywatch
    private val centralIntelligence = R.drawable.central_ntelligence


    fun generateMovieList(): List<Movie> {
        return listOf(
            Movie(
                twoAndHalfMan, 1, "Two and haf man", 2003, "Charlie Sheen, Jon Cryer",
                "...", 10
            ),
            Movie(
                friends, 2, "Friends", 1994, "Jennifer Aniston, David Schwimmer",
                "...", 10
            ),
            Movie(
                badBoys, 3, "Bad boys", 1995, "Martin Lawrence, Will Smith",
                "...", 10
            ),
            Movie(
                bayWatch, 4, "Baywatch", 2017, "Dwayne Douglas Johnson(The Rock)",
                "...", 5
            ),
            Movie(
                centralIntelligence, 5, "Central Intelligence", 2016,
                "Dwayne Douglas Johnson(The Rock)", "...", 9
            )
        )
    }
}