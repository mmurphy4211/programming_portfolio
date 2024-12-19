emails <- c("john.doe@ivyleague.edu.com", "education@world.gov", "dalai.lama@peace.org", "invalid.edu", "quant@bigdatacollege.edu", "cookie.monster@sesame.tv")
grepl(pattern="@", x=emails)
grep(pattern="@.*\\.edu$", x=emails)
hits<- grep(pattern="@.*\\.edu$", x=emails)
hits
emails[hits]
emails
emails[hits]
