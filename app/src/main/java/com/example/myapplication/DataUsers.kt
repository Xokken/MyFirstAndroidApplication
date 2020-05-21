package com.example.myapplication

class DataUsers{
    private var user1 = User("Alexey", "Dyakonov", "dyakonov128@gmail.com", "Qwerty-111")
    private var user2 = User("Arturia", "Pendragon", "fate@gmail.com", "myGrail123")
    private var user3 = User("Ametis", "Laplas", "lapadasbarabas@gmail.com", "111q222w333eQWE")
    private var user4 = User("Ascarsin", "Delarin", "debil@gmail.com", "neDebil45")
    private var user5 = User("OmagadGanila", "TiShoCrasyyyy", "nudaishooo@gmail.com", "123qweQWE")
    private var dataUsers = mutableMapOf<String, User>(
        "dyakonov128@gmail.com" to user1,
        "fate@gmail.com" to user2,
        "lapadasbarabas@gmail.com" to user3,
        "debil@gmail.com" to user4,
        "nudaishooo@gmail.com" to user5
    )

    fun getDatabase(): MutableMap<String, User> {
        return dataUsers
    }
}