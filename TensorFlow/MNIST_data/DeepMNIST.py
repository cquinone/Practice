import time
import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

# Define path to TensorBoard log files
logPath = "./tb_logs/" # after running file type "tensorboard --logdir tb_logs" to see logs
                       #

# Below we add some summary statistics to use in the TensorBoard visualization
def variable_summaries(var):
    with tf.name_scope("summaries"):
        mean = tf.reduce_mean(var)
        tf.summary.scalar("mean", mean)
        with tf.name_scope("stddev"):
            stddev = tf.sqrt(tf.reduce_mean(tf.square(var - mean)))
        tf.summary.scalar('stddev', stddev)
        tf.summary.scalar('max', tf.reduce_max(var))
        tf.summary.scalar('min', tf.reduce_max(var))
        tf.summary.histogram('histogram', var)


mnist = input_data.read_data_sets("MNIST_data", one_hot = True)
sess = tf.InteractiveSession() # makes it so that we don't have to have to preceed session level commands like eval with the sess reference

with tf.name_scope("MNIST_Input"):
    x = tf.placeholder(tf.float32, shape = [None, 784], name = "x")
    y_ = tf.placeholder(tf.float32, [None, 10], name = "y_")

with tf.name_scope("Input_Reshape"):
    x_image = tf.reshape(x, [-1, 28, 28, 1], name = "x_image") # Changes the data from a list of values to a 28 x 28 x 1 grayscale value cube, for the CNN to use
    tf.summary.image('input_img', x_image, 5)

def weight_variable(shape, name = None):
    initial = tf.truncated_normal(shape, stddev = .1)
    return tf.Variable(initial)

def bias_variable(shape, name = None):
    initial = tf.constant(.1, shape = shape)
    return tf.Variable(initial)

# Convolution and pooling to avoid overfitting
def conv2d(x, W, name = None):
    tf.nn.conv2d(x, W, strides = [1, 1, 1, 1], padding = 'SAME')

def max_pool_2x2(x, name = None):
    return tf.nn.max_pool(x, ksize = [1, 2, 2, 1],
                          strides = [1, 2, 2, 1], padding = None)

# Define layers in NN

# 1st Layer
with tf.name_scope('Conv1'):
    # 32 features for each 5x5 patch of the image
    with tf.name_scope('weights'):
        W_conv1 = weight_variable([5, 5, 1, 32], name = "weight") # [5, 5]: represents the size of the filter, [32]: the number of features determined by each filter, [1]: num of input channels
        variable_summaries(W_conv1)
    with tf.name_scope('biases'):
        b_conv1 = bias_variable([32], name = "bias")
        variable_summaries(b_conv1)

    # do convolution on images, add bias, and push through RELU activation
    conv1_wx_b = conv2d(x_image, W_conv1, name = "conv2d") + b_conv1
    tf.summary.histogram("conv1_wx_b", conv1_wx_b)
    h_conv1 = tf.nn.relu(conv2d(x_image, W_conv1) + b_conv1, name = "relu")
    tf.summary.histogram("h_conv1", h_conv1)
    # run results through max_pool
    h_pool1 = max_pool_2x2(h_conv1, name = "pool")

# 2nd Layer
with tf.name_scope('Conv2'):
    with tf.name_scope("weights"):
        W_conv2 = weight_variable([5, 5, 32, 64], name = "weight") # returns 64 weights and biases
        variable_summaries(W_conv2)
    with tf.name_scope('biases'):
        b_conv2 = bias_variable([64], name = "bias")
        variable_summaries(b_conv2)

    # do convolution of the output of the 1st convoultion layer.  Pool results
    conv2_wx_b = conv2d(x_image ,W_conv2, name = "conv2d") + b_conv1
    tf.summary.historgram("conv2_wx_b", conv2_wx_b)
    h_conv2 = tf.nn.relu(conv2d(h_pool1, W_conv2) + b_conv2, name = "relu")
    tf.summary.histogram("h_conv2", h_conv2)
    h_pool2 = max_pool_2x2(h_conv2)

# FC Layer
with tf.name_scope('FC'):
    W_fc1 = weight_variable([7 * 7* 64, 1024], name = "weight")
    b_fc1 = bias_variable([1024], name = "bias")

    # connect output of pooling layer 2 as input to fully connected layer
    h_pool2_flat = tf.reshape(h_pool2, [-1, 7 * 7 * 64])
    h_fc1 = tf.nn.relu(tf.matmul(h_pool2_flat, W_fc1) + b_fc1, name = "relu")

# dropout some neuros to reduce overfitting
keep_prob = tf.placeholder(tf.float32) # get dropout prob as a training input
h_fc1_drop = tf.nn.dropout(h_fc1, keep_prob)

# readout layer
with tf.name_scope("Readout"):
    W_fc2 = weight_variable([1024, 10])
    b_fc2 = bias_variable([10])

# define model
y_conv = tf.matmul(h_fc1_drop, W_fc2) + b_fc2

# loss measurement
with tf.name_scope("cross_entropy"):
    cross_entropy = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits(logits = y_conv, labels = y_))

# loss optimization
with tf.name_scope("loss_optimizer"):
    train_step = tf.train.AdamOptimizer(1e-4).minimize(cross_entropy)

# what is correct
with tf.name_scope("accuracy"):
    correct_prediction = tf.equals(tf.argmax(y_conv, 1), tf.argmax(y_, 1))
    # how accurate is it
    accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))

tf.summary.scalar("cross_entropy_scl", cross_entropy)
tf.summary.scalar("training_accuracy", accuracy)

# TensorBoard command to merge summaries
summarize_all = tf.summary.merge_all()

# initialize the variables
sess.run(tf.global_variables_initializer())

# TensorBoard - Write the default graph out so we can view it's structure
tbWriter = tf.summary.FileWriter(logPath, sess.graph)

# Train the model
num_steps = 2000
display_every = 100

# Start timer
start_time = time.time()
end_time = time.time()

for i in range(num_steps):
    batch = mnist.train.next_batch(50)
    _, summary = sess.run([train_step, summarize_all], feed_dict = {x: batch[0], y_: batch[1], keep_prob: .5})

    # status display
    if i % display_every == 0:
        train_accuracy = accuracy.eval(feed_dict = {
            x: batch[0], y_: batch[1], keep_prob: 1.0})
        end_time = time.time()
        print("step {0}, elapsed time {1: .2f} seconds, training accuracy {2:.3f}%".format(i, end_time - start_time, train_accuracy * 100))
        # write summary to log
        tbWriter.add_summary(summary, i)
# Display summary
end_time = time.time()
print("Total training time for {0} batches: {1:.2f} seconds".format(i+1, end_time - start_time))


