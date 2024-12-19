#Task 1
mtcars
my_mtcars <- mtcars

str(my_mtcars)

#my_mtcars has 32 obs of 11 variables

#Calculating engine displacement per cylinder
my_mtcars$UnitEngine <- my_mtcars$disp / my_mtcars$cyl

#Summarizing new variable 'Unit Engine'

summary(my_mtcars$UnitEngine)

#Task 2

#Create numeric vector for Pets

Pets <- c(1,1,1,0,0)

#Create numeric vector for Order, Siblings, and IDs
Order <- c(3,1,2,3,3)
Siblings <- c(0,3,5,0,0)
IDs<- c(1,2,3,4,5)

#Create data frame for above

myFriends <- data.frame(Pets, Order, Siblings, IDs)

#Report Structure of myFriends data frame
str(myFriends)

#Summarize myFriends
summary(myFriends)

#list all values for IDs, Pets, Order and Siblings individually

myFriends$IDs
myFriends$Pets
myFriends$Order
myFriends$Siblings

#Code for 5th observation of Pets
myFriends$Pets[5]

#Use cBind to add vector called age to myFriends
age <-c(23,21,45,21,18)
myFriends <- cbind(myFriends, age)

names <-c("John", "Smith", "Susan", "Joe", "Wendy")
myFriends<- cbind(myFriends, names)
str(myFriends)
