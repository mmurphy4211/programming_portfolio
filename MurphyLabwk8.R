#Creating the readStates function and URL to Read
urlToread<- 'https://www2.census.gov/programs-surveys/popest/tables/2010-2011/state/totals/nst-est2011-01.csv'
readStates<- function(urlToread){
  testFrame<- read.csv(url(urlToread))
  testFrame <- testFrame[-1:-8,]
  testFrame<-testFrame[,1:5]
  testFrame<-testFrame[-52:-58,]
  testFrame$State_Name<- testFrame[,1]
  colnames(testFrame)
  testFrame<-testFrame[,-1]
  cnames <-(colnames(testFrame))
  cnames
  cnames2<-c("Census","Base","Pop2010","Pop2011","StateNames")
  colnames(testFrame)<-cnames2
  testFrame$StateNames <- gsub("\\.",'',testFrame$StateNames)
  
  testFrame$Census <-as.numeric(gsub(",","",testFrame$Census))
  testFrame$Base <-as.numeric(gsub(",","",testFrame$Base))
  testFrame$Pop2010 <-as.numeric(gsub(",","",testFrame$Pop2010))
  testFrame$Pop2011 <-as.numeric(gsub(",","",testFrame$Pop2011))
  rownames(testFrame)<-NULL
  library(dplyr)
  testFrame <- testFrame %>% select(StateNames, everything())
}

#Assigning the function readStates to dfStates and testing
dfStates<- readStates(urlToread)
dfStates

#Mean of dfStates
mean(dfStates$Pop2011)

#Which state had the highest population in 2011
maxdfState2011 <- dfStates[which.max(dfStates$Pop2011), ]
maxdfState2011
#Sort states by decreasing population
dfStatesSortDec <- dfStates[order(dfStates$Pop2011, decreasing = TRUE), ]
dfStatesSortDec

#Creating function Distribution and testing it
Distribution<- function(vector, number){
  count <-length(vector[vector<number])
  percentage <- (count/length(vector))*100
  return(percentage)
}
testDistribution<- Distribution(dfStates$Pop2011, mean(dfStates$Pop2011))
testDistribution
