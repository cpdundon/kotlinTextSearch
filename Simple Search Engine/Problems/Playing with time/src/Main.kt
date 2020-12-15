val calendar = createCalendar()
// write your code here
    calendar.selectCurrentDay()
    val fmtTemplate = "%s %s %s"
    println(fmtTemplate.format(calendar.day, calendar.month, calendar.year))
