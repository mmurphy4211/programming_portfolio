#Install sqldf library
library(sqldf)

#inspect the airquality dataset 
print(head(airquality))

#Calculate the average level of ozone
query <- "SELECT AVG(ozone) AS average_ozone FROM airquality"
result <- sqldf(query)

average_ozone <- result$average_ozone
avg_ozone <- mean(airquality$Ozone, na.rm = TRUE)
print(average_ozone)

newAQ <- air[air$Ozone > average_ozone, ]
class(newAQ)
nrow(newAQ)
ncol(newAQ)
head(newAQ)

average_ozone <- mean(airquality$Ozone, na.rm = TRUE)
print(average_ozone)
newAQ <- airquality[airquality$Ozone > average_ozone, ]
newAQ2 <- subset(airquality, Ozone > average_ozone)
class(newAQ2)
nrow(newAQ2)
ncol(newAQ2)
head(newAQ2)