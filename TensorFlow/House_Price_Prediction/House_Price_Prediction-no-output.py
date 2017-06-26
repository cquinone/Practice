# Simple linear regression model of house prices based on house size
import math
import numpy as np
import tensorflow as tf
import matplotlib.pyplot as plt
import matplotlib.animation as animation

# generate some house sizes between 1000 and 3000 (square feet)
num_house = 160
np.random.seed(42)
house_size = np.random.randint(low = 1000, high = 3500, size = num_house)

# generate house proces from house size with a random noise added
np.random.seed(42)
house_price = house_size * 100.0 + np.random.randint(low = 20000, high = 70000, size = num_house)

# plot generated house and size
#plt.plot(house_size, house_price, "bx") # bx = blue x
#plt.xlabel("Size")
#plt.ylabel("Price")
#plt.show()

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

# Tensor Types
# Constant - constant value; Variable - values adjusted in graph; PlaceHolder - used to pass data in graph

# TF PlaceHolder's that get updated as we descend down the gradient
tf_house_size = tf.placeholder("float", name = "house_size")
tf_house_price = tf.placeholder("float", name = "price")

print(tf_house_size)
print(tf_house_price)

# Define variables holding size_factor and price + initiialize them to random values based on Norm(mu, sigma^2)
tf_size_factor = tf.Variable(initial_value = np.random.normal(loc = 0, scale = 1), name = "size_factor") # Beta_1 (quantitative predictor)
tf_price_offset = tf.Variable(initial_value = np.random.normal(loc = 0, scale = 1), name = "price_offset") # Beta_0 (quantitative predictor)

print(tf_size_factor)
print(tf_price_offset)

# Define operation for predicting value
#tf_price_pred = tf.add(tf.multiply(tf_size_factor, tf_house_size), tf_price_offset)

# Define Loss Function - Mean Square Error
#tf_cost = tf.reduce_sum(tf.pow(tf_price_pred - tf_house_price, 2)) / (2 * num_train_samples)

# Optimizer Learning Rate
#learning_rate = .1

# Define optimizer that will minimize the loss function defined above
#tf_optimizer = tf.train.GradientDescentOptimizer(learning_rate).minimize(tf_cost)

# Currenlty TF variables are defined, but they do not exist in the execution environment and they have not been set to initial values

# Initializing the variables...
"""
tf_init = tf.global_variables_initializer()

# Launch the graph in the session
with tf.Session() as sess:
    sess.run(tf_init)

    # set how often to display training progress and number of training iterations
    display_every = 2
    num_training_iter = 50

    # keep iterating the training data
    for iteration in range(num_training_iter):

        # fit all training data
        for (x, y) in zip(train_house_size_norm, train_house_price_norm):
            sess.run(tf_optimizer, feed_dict = {tf_house_size: x, tf_house_price: y})

        # displays status as code runs
        if (iteration + 1) % display_every == 0:
            c = sess.run(tf_cost, feed_dict = {tf_house_size: train_house_size_norm, tf_house_price: train_house_price_norm})
            print("iteration #:", '%02d' % (iteration + 1), "cost = ", "{:.9f}".format(c), \
                  "size_factor = ", sess.run(tf_size_factor), "price_offset = ", sess.run(tf_price_offset))


    print ("Optimization finished...") #below are the final cost, size factor, and price offset
    training_cost = sess.run(tf_cost, feed_dict = {tf_house_size: train_house_size_norm, tf_house_price: train_house_price_norm})
    training_size_factor = sess.run(tf_size_factor)
    training_price_offset = sess.run(tf_price_offset)
    print("Trained cost = ", training_cost, "size_factor = ", training_size_factor, "price_offset = ", training_price_offset, '\n')

    train_house_size_mean = train_house_size.mean()
    train_house_size_std = train_house_size.std()

    train_house_price_mean = train_house_price.mean()
    train_house_price_std = train_house_price.std()

    #PLOT GRAPH
    plt.rcParams["figure.figsize"] = (10, 8)
    plt.title("Gradient Descent Fitting Regression Line")
    plt.xlabel("Size (sq. feet)")
    plt.ylabel("Price")
    plt.plot(train_house_size, train_house_price, 'go', label='Training Data')
    plt.plot(test_house_size, test_house_price, 'mo', label='Testing Data')
    plt.plot(train_house_size_norm * train_house_size_std + train_house_size_mean,
             (training_size_factor * train_house_size_norm + training_price_offset) * train_house_price_std + train_house_price_mean, label = "Learned Regression")
    plt.legend(loc = 'upper left')
    plt.show()




#Can also use a session by doing...

#sess = tf.Session() 
#sess.run()
#sess.close()
"""