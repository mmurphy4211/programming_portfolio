mtcars
myCars<-mtcars
head(mtcars)
head(myCars)

# 1) What is the highest hp? (The highest hp is 335)
max(myCars$hp)
#335
myCars$hp

# 2) Which car has the highest hp?
#Maserati Bora

# 3) What is the highest mpg?
max(myCars$mpg)
#33.9

# 4) Which car has the highest mpg?
rownames(myCars[myCars$mpg==max(myCars$mpg),])
#Toyota Corolla

# 5) Create a sorted dataframe, based on mpg
# sort the dataframe by mpg, in descending order, and store the sorted dataframe
#in 'myCars_sorted' 

myCars_sorted<- myCars[order(myCars$mpg, decreasing = TRUE),]
myCars_sorted

# 6) One method to pick an efficient car: divide the mpg value by hp, and pick 
#the car with highest result
# add a new column 'efficiency' in the dataframe to store the division result

myCars$effieciency<-(myCars$mpg/myCars$hp)

# 7) Which car has the best combination of mpg and hp? 
# get the index of maximum efficiency first, and then get its row name
row.names(myCars[myCars$effieciency==max(myCars$effieciency),])

# scale 'mpg' by subtracting its column mean and then dividing the column
#standard deviation

#scale mpg first:
scale(myCars$mpg)

# scale 'hp' (scale is subtracting its column mean and then dividing its 
#column’s standard deviation. But you just use scale function like this:)
scale(myCars$hp)
myCars$combined <- scale(myCars$mpg)+scale(myCars$hp)


# Get the index of maximum combination first, and then get its row name. HINT:
#use which.max function AND row.names function
row.names(myCars[myCars$combined==max(myCars$combined),])
