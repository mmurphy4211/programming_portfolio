#Matthew Murphy
#Licato
#CAI5307

import nltk
from nltk.util import ngrams
from collections import Counter
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.naive_bayes import MultinomialNB
import json
import numpy as np

# Function to train n-grams from a text file
def calcNGrams_train(trainFile, n=2):
    # Read the file
    with open(trainFile, 'r') as file:
        text = file.read()
    
    # Tokenize the text
    tokens = nltk.word_tokenize(text)
    
    # Generate n-grams
    n_grams = ngrams(tokens, n)
    
    # Frequency of each n-gram
    global n_gram_freq
    n_gram_freq = Counter(n_grams)

# Test which sentence is random
def calcNGrams_test(sentences):
    vectorizer = CountVectorizer(ngram_range=(2, 2))  # Using bigrams
    X = vectorizer.fit_transform(sentences)
    X_sum = X.sum(axis=1)
    
    # The non-random sentence test. Should have highest score
    non_random_index = np.argmax(X_sum)
    return non_random_index

# Training a Naive Bayes classifier on movie reviews
def calcSentiment_train(trainFile):
    with open(trainFile, 'r') as file:
        data = [json.loads(line) for line in file]
    
    reviews = [entry['review'] for entry in data]
    sentiments = [entry['sentiment'] for entry in data]
    
    global vectorizer, model
    vectorizer = CountVectorizer()
    X = vectorizer.fit_transform(reviews)
    
    model = MultinomialNB()
    model.fit(X, sentiments)

#Predicting is the review is positive or negative
def calcSentiment_test(review):
    X = vectorizer.transform([review])
    prediction = model.predict(X)
    return bool(prediction[0])
