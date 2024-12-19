library(actuar)

#Creating a histogram with a random set of numbers with rnorm nested
hist((rnorm(20, mean=50, sd=25)), main= "Histogram", xlab = "Random Numbers")




#Generating a random set of numbers and a histogram with rnorm nested

hist(rnorm(20,mean=50, sd=25), main = "Random", xlab = "Numbers")

#Creating a Histogram with Pareto Random Numbers 51
pdata<- rpareto(51,10,50)
hist(pdata, main= "Pareto Histogram", xlab= "Dispersion", ylab = "Amount listed")
