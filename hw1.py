"""This is a sample file for hw1. 
It contains the function that should be submitted,
except all it does is output a random value out of the
possible values that are allowed.
- Dr. Licato"""

import re

def problem1(NPs, S):
    hypernyms = set()

    # Lowercase the sentence to handle capitalization uniformly
    S_lower = S.lower()

    # Define Hearst patterns
    patterns = [
	r'(\b{}\b) is (\b{}\b)'
	r'(\b{}\b) is a type of (\b{}\b)'
        r'(\b{}\b) is a kind of (\b{}\b)'
	r'(\b{}\b) was (\b{}\b)'
	r'(\b{}\b) was a type of (\b{}\b)'
	r'(\b{}\b) was a kind of (\b{}\b)'
	r'(\b{}\b) are (\b{}\b)'
	r'(\b{}\b) are a type of (\b{}\b)'
	r'(\b{}\b) are a kind of (\b{}\b)'
	r'(\b{}\b) such as (\b{}\b)'
	r'(\b{}\b) including (\b{}\b)'
    ]
    
    # Loop through noun phrases and check all pairs
    for np1 in NPs:
        for np2 in NPs:
            if np1 != np2:
                for pattern in patterns:
                    # Compile the pattern with the noun phrases inserted
                    regex = re.compile(pattern.format(re.escape(np2), re.escape(np1)))
                    matches = regex.findall(S_lower)
                    if matches:
                        hypernyms.add((np2, np1))

    return hypernyms


def problem2(s1, s2):
	return random.randint(0, abs(len(s1) - len(s2)))
