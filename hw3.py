"""This is a sample file for hw3. 
It contains the functions that should be submitted,
except all it does is output a random value.
- Dr. Licato"""


import random
import gensim.models.keyedvectors as word2vec
from sklearn.linear_model import LogisticRegression
from sklearn.pipeline import make_pipeline
from sklearn.preprocessing import StandardScaler
from scipy.spatial.distance import cosine as cosDist
import numpy as np
import json

w2v_model = None

# Task 1: Set up Word2Vec Model
def setModel(model):
    """
    Sets the global Word2Vec model.
    Args:
        model: Pre-trained Word2Vec model from Google News vectors.
    """
    global w2v_model
    w2v_model = model

def sentence_to_vec(sentence):
    """
    Convert a sentence to a vector by averaging word vectors.
    Args:
        sentence (str): Sentence to be converted.
    Returns:
        np.array: Averaged vector for the sentence.
    """
    words = sentence.split()
    word_vectors = [w2v_model[word] for word in words if word in w2v_model]
    return np.mean(word_vectors, axis=0) if word_vectors else np.zeros(w2v_model.vector_size)

def findPlagiarism(sentences, target):
    """
    Identifies the index of the sentence most similar to the target.
    Args:
        sentences (list of str): List of sentences to compare.
        target (str): Target sentence.
    Returns:
        int: Index of the sentence most similar to the target.
    """
    target_vec = sentence_to_vec(target)
    similarities = [1 - cosDist(target_vec, sentence_to_vec(sentence)) for sentence in sentences]
    return np.argmax(similarities)

# Task 2: Subreddit Classification
classifier_model = None

def classifySubreddit_train(trainFile):
    """
    Trains a logistic regression model to classify comments by subreddit.
    Args:
        trainFile (str): Path to the training .jsonlist file.
    """
    global classifier_model
    
    # Load data
    comments = []
    labels = []
    with open(trainFile, 'r') as f:
        for line in f:
            obj = json.loads(line)
            comments.append(obj['body'])
            labels.append(obj['subreddit'])

    # Convert comments to vectors
    X = np.array([sentence_to_vec(comment) for comment in comments])
    
    # Train logistic regression model
    classifier_model = make_pipeline(StandardScaler(), LogisticRegression(max_iter=1000))
    classifier_model.fit(X, labels)

def classifySubreddit_test(comment):
    """
    Predicts the subreddit for a given comment.
    Args:
        comment (str): Raw text of the comment.
    Returns:
        str: Predicted subreddit.
    """
    comment_vec = sentence_to_vec(comment).reshape(1, -1)
    return classifier_model.predict(comment_vec)[0]
