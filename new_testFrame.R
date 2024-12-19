
urlToread<- 'https://www2.census.gov/programs-surveys/popest/tables/2010-2011/state/totals/nst-est2011-01.csv'
testFrame<- read.csv(url(urlToread))

#read first few lines
head(testFrame)
#review structure
str(testFrame)                     
#removing rows and columns: remove header rows using minus
testFrame <- testFrame[-1:-8,]
head(testFrame)

summary(testFrame[,6:10])

testFrame<-testFrame[,1:5]
testFrame<-testFrame[-52:-58,]

head(testFrame)

testFrame$State_Name<- testFrame[,1]
head(testFrame)

colnames(testFrame)
testFrame<-testFrame[,-1]
head(testFrame)
cnames <-(colnames(testFrame))
cnames

cnames2<-c("Census","Base","Census2010","Census2011","StateNames")
colnames(testFrame)<-cnames2
head(testFrame)

testFrame$StateNames <- gsub("\\.",'',testFrame$StateNames)
head(testFrame)

testFrame$Census <-as.numeric(gsub(",","",testFrame$Census))
testFrame$Base <-as.numeric(gsub(",","",testFrame$Base))
testFrame$Census2010 <-as.numeric(gsub(",","",testFrame$Census2010))
testFrame$Census2011 <-as.numeric(gsub(",","",testFrame$Census2011))

testFrame
rownames(testFrame)<-NULL
testFrame

library(dplyr)
new_testFrame <- testFrame %>% select(StateNames, everything())
new_testFrame

write.csv(new_testFrame, "testFrame.MM.csv")
setwd("C:/Users/mattm/OneDrive/Documents/Personal/School/Intro Data Science/R Projects/CSV Files")
write.csv(new_testFrame, "testFrame.MM.csv")

