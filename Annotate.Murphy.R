

urlToRead <- "https://www2.census.gov/programs-surveys/popest/tables/2010-2011/state/totals/nst-est2011-01.csv"

testFrame <- read.csv(url(urlToRead))

#1 shows the first 6 lines and the structure of the object testFrame
head(testFrame)

str(testFrame)

#2 removing of the first 8 lines and giving a summary of the testFrame
testFrame <-testFrame[-1:-8,]
head(testFrame)

summary(testFrame[,6:10])

#3 Limits testFrame to the first 5 columns
testFrame <- testFrame[,1:5]

#4 Removes rows 52-58
testFrame <-testFrame[-52:-58,]
head(testFrame)

#5 changes the column name to stateName 
testFrame$stateName <-testFrame[,1]
head(testFrame)

#6 print out a list of the column names
colnames(testFrame)

#7 remove the first row
testFrame <-testFrame[,-1]
head(testFrame)

#8 changes the names to the names listed in the c code
colnames(testFrame)
cnames<-colnames(testFrame)
cnames

cnames2 <-c("Census", "Base", "Census2010", "Census2011","StateName")
colnames(testFrame) <-cnames2
head(testFrame)

#9 Remove the "." in front of each of the state names
testFrame$StateName <-gsub("\\.", '',testFrame$StateName)
head(testFrame)

#10 Change the numeric for census, base, census2010 and census2011
testFrame$Census <-as.numeric(gsub(",","",testFrame$Census))
testFrame$Base <-as.numeric(gsub(",","",testFrame$Base))
testFrame$Census2010 <-as.numeric(gsub(",","",testFrame$Census2010))
testFrame$Census2011 <-as.numeric(gsub(",","",testFrame$Census2011))

testFrame

#rownames changes the rows name so that the count starts at 1
rownames(testFrame)<-NULL
testFrame

#move the last column to first
library(dplyr)
new_testFrame <-testFrame %>% select(StateName, everything())
