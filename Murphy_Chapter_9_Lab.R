library(actuar)
n_1<- rnorm(1000, mean =80)
myFunction <- function(vector, min, max){
  vectorSubset <- length(vector[(vector>=min)&(vector<=max)])
  return(vectorSubset)
}
myFunction(n_1,79,81)
n_2<-rnorm(1000,80)
n_3<-rnorm(1000,80)
myFunction(n_2,79,81)
myFunction(n_3,79,81)

FSApops<-rpareto(51,10,50)
paretoFlorida<-rpareto(51,22240000,5763868)
summary(paretoFlorida)
par(mfrow = c(2,1))
hist(FSApops)
hist(paretoFlorida)
