# simple neural network to classify handwritten digits from MNIST dataset

import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

"""Data Preparation"""
mnist = input_data.read_data_sets('MNIST_data/', one_hot = True) # use the TF helper function to pull down the data from the MNIST data

# x: placeholder for the 28 x 28 image data
x = tf.placeholder(tf.float32, shape = [None, 784]) # None means we know the dimension exists, but not how many items will be there
y_ = tf.placeholder(tf.float32, [None, 10]) # y_: 10 element vector containing the predicted prob of each digit.  must sum to 1

W = tf.Variable(tf.zeros([784, 10])) # define weights
b = tf.Variable(tf.zeros([10])) # define zbiases

"""Prediction"""
y = tf.nn.softmax(tf.matmul(x, W) + b) # softmax is good for the output layer of a NN that determines which class you have

"""Define Loss Function - Cross Entropy"""
cross_entropy = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(labels = y_, logits = y))

"""Optimize to minimize loss"""
train_step = tf.train.GradientDescentOptimizer(.5).minimize(cross_entropy) # each training step in GD we want to minimize the CE

"""Initialize"""
init = tf.global_variables_initializer()

sess = tf.Session()
sess.run(init) # perform the initiailization which is only the initialization of all global variables

for i in range(1000):
    batch_xs, batch_ys = mnist.train.next_batch(100) # get 100 random data points from the data. batch_xs = image, batch_ys = digit class
    sess.run(train_step, feed_dict = {x: batch_xs, y_: batch_ys}) #optimize with this data

correct_prediction = tf.equal(tf.argmax(y, 1), tf.argmax(y_, 1))
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
test_accuracy = sess.run(accuracy, feed_dict = {x: mnist.test.images, y_: mnist.test.labels})
print("Test Accuracy: {0}".format(test_accuracy * 100.0))

sess.close()






