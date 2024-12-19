#install.packages("latexpdf")
#Today we will learn all about Booleans and how to program them in R!

#The first Boolean that we will learn about is the AND Boolean.
# This line will show how the AND (&) function works

1 & 1

#We can also then use an 'if' statement to print if 1 & 1 is TRUE

if(1&1) print("1&1 gives us a TRUE result")

#If the statement is FALSE, we could use an ELSE statement
A<-FALSE
B<-FALSE
A&B
if(A&B) print("A&B is TRUE") else print("NOT TRUE")
#As you can see it gives us the response NOT TRUE

#Now lets go over the OR (|) statement. In this if either is true, the answer is true

if(1|3) print("This OR statement is True") else print("Neither are True")

#With the ! or NOT fucntion it will reverse whether something is true or false

1 != 1
1 != 2

#This is basically saying 1 does not equal 1. But that is silly, because we know that 1 does equal 1
# We also know that 1 does not equal 2. So that gives us a true statement

#Exercise 2

height <- c(59,60,61,58,67,72,70)

weight <- c(150,140,180,220,160,140,130)
#I used x here because i use "a" earlier in the previous exercise
x <- 150

mean(height)
mean(weight)
length(height)
length(weight)
sum(height)
sum(height)/length(height)
sum(weight)/length(weight)
#These compute the same as the mean
#Computing max height as maxH
maxH<- max(height)
maxH
#Computing minimum weight as minW
minW<- min(weight)
minW
#Creating a new vector
new_weight<- weight + 5
new_weight
#Computing new weight divided by height
new_weight/height
#Conditional if statements
if(max(height)>60) "Yes" else "No"
if(min(weight)>x) "Yes" else "No"

