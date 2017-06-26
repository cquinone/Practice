# Simple linear regression model of house prices based on house size
import math
import numpy as np
import tensorflow as tf
from keras.models import Sequential
from keras.layers.core import Dense, Activation

## generate some house sizes between 1000 and 3000 (square feet)
num_house = 160
np.random.seed(42)
house_size = np.random.randint(low = 1000, high = 3500, size = num_house)

# generate house proces from house size with a random noise added
np.random.seed(42)
house_price = house_size * 100.0 + np.random.randint(low = 20000, high = 70000, size = num_house)

# normalize training data
def normalize(arr):
    return (arr - arr.mean()) / arr.std()

# define number of training examples
num_train_samples = math.floor(num_house * .7)

#  training data
train_house_size = np.asarray(house_size[:num_train_samples])
train_house_price = np.asarray(house_price[:num_train_samples])

# normalized training data
train_house_size_norm = normalize(train_house_size)
train_house_price_norm = normalize(train_house_price)

# testing data
test_house_size = np.asarray(house_size[num_train_samples:])
test_house_price = np.asarray(house_price[num_train_samples:])

# normalized testing data
test_house_size_norm = normalize(test_house_size)
test_house_price_norm = normalize(test_house_price)

# define the NN for doing Linear Regression
model = Sequential()
model.add(Dense(1, input_shape = (1,), init = "uniform", activation = "linear"))
        # 1: only need one neuron
        # (1,): one parameter (house size); the empty parameter says we don't know the # of houses
        # uniform: initilization function which causes a random normal distribution
        # linear: activation function is linear because we are doing linear regression
model.compile(loss = 'mean_squared_error', optimizer = 'sgd')

# fit/train the model
model.fit(train_house_size_norm, train_house_price_norm, nb_epoch = 300)
score = model.evaluate(test_house_size_norm, test_house_price_norm)
print("\nloss on test: {0}".format(score))
