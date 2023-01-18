package com.example.scrolls

import java.time.LocalDateTime

class PhoneModel {
    val listItems: List<ElementsForOneRow> = listOf(
        ElementsForOneRow("isOk", "Jayme", LocalDateTime.now()),
        ElementsForOneRow("isNot", "Gifl", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("not", "WRLD", LocalDateTime.now().minusDays(6)),
        ElementsForOneRow("Ok", "Caln", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Brton", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "Kyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Liley", LocalDateTime.now().minusHours(1)),
        ElementsForOneRow("Ok", "Allan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "Mike", LocalDateTime.now().minusDays(4)),
        ElementsForOneRow("Ok", "Drew", LocalDateTime.now().minusHours(4)),
        ElementsForOneRow("Ok", "SDNia", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Ok", "CoiRelay", LocalDateTime.now().minusDays(8)),
        ElementsForOneRow("Ok", "CGGlan", LocalDateTime.now().minusHours(2)),
        ElementsForOneRow("Not", "Brton", LocalDateTime.now().minusHours(7)),
        ElementsForOneRow("Ok", "TKyla", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Liley", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Not", "ADlan", LocalDateTime.now().minusDays(1)),
        ElementsForOneRow("Ok", "Mike", LocalDateTime.now().minusHours(5)),
        ElementsForOneRow("N", "Drew", LocalDateTime.now().minusHours(3)),
        ElementsForOneRow("Ok", "VBNia", LocalDateTime.now().minusDays(7)),
        ElementsForOneRow("Not", "DReay", LocalDateTime.now().minusHours(1))

    )


}