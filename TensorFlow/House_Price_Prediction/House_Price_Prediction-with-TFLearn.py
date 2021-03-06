import tensorflow as tf
import numpy as np
import math
import tflearn

num_house = 160
np.random.seed(42)
house_size = np.random.randint(low=1000, high=3500, size=num_house )

# Generate house prices from house size with a random noise added+.
np.random.seed(42)
house_price = house_size * 100.0 + np.random.randint(low=20000, high=70000, size=num_house)

# you need to normalize values to prevent under/overflows.
def normalize(array):
    return (array - array.mean()) / array.std()

# 1. Get Data
# Split the data into training and testing, and normalized the data

# define number of training samples, 0.7 = 70%.  We can take the first 70% since the values are randomized
num_train_samples = math.floor(num_house * 0.7)

# define training data
train_house_size = np.asarray(house_size[:num_train_samples])
train_house_price = np.asanyarray(house_price[:num_train_samples:])

train_house_size_norm = normalize(train_house_size)
train_house_price_norm = normalize(train_house_price)

# define test data
test_house_size = np.array(house_size[num_train_samples:])
test_house_price = np.array(house_price[num_train_samples:])

test_house_size_norm = normalize(test_house_size)
test_house_price_norm = normalize(test_house_price)

input = tflearn.input_data(shape = [None], name = "InputData") # Input data: list of undefined len
linear = tflearn.layers.core.single_unit(input, activation = 'linear', name = 'Linear') # define a single neuron w/ linear activation
                                                                            # the eq., it is linear (Wx + b)
# define the optimizer, metric we try to optimize, and how to calculate loss
reg = tflearn.regression(linear, loss = 'mean_square', optimizer = 'sgd',
                         metric = 'R2', learning_rate = .01, name = 'regression')
model = tflearn.DNN(reg) # define model
model.fit(train_house_size_norm, train_house_price_norm, n_epoch = 1000) # train the model with training data

print("Training complete...")
print("Weights: W = {0}, b={1}\n".format(model.get_weights(linear.W), model.get_weights(linear.b)))
print("Accuracy {0}".format(model.evaluate(test_house_size_norm, test_house_price_norm)))