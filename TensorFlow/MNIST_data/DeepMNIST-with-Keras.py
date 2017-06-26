import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

from keras.models import Sequential
from keras.layers import Dense, Dropout, Activation, Flatten
from keras.layers import Convolution2D, MaxPooling2D
from keras import backend as K

mnist = input_data.read_data_sets("MNIST_data/", one_hot=True)

sess = tf.InteractiveSession()
image_rows = 28
image_cols = 28

# reshape the training and test images to 28 x 28 x 1
train_images = mnist.train.images.reshape(mnist.train.images.shape[0], image_rows, image_cols, 1)
test_images = mnist.test.images.reshape(mnist.test.images.shape[0], image_rows, image_cols, 1)

# layer values
num_filters = 32 # convolution filters
max_pool_size = (2, 2)
conv_kernel_size = (3, 3)
imag_shape = (28, 28, 1)
num_classes = 10
drop_prob = .5

# define the model type
model = Sequential()

# define nn layers
# 1st layer: only layer where we can use border_m
model.add(Convolution2D(num_filters, conv_kernel_size[0], conv_kernel_size[1], border_mode = 'valid', input_shape = imag_shape))
model.add(Activation('relu'))
model.add(MaxPooling2D(pool_size = max_pool_size))

# 2nd layer
model.add(Convolution2D(num_filters, conv_kernel_size[0], conv_kernel_size[1]))
model.add(Activation("relu"))
model.add(MaxPooling2D(pool_size = max_pool_size))

# FC layer
model.add(Flatten())
model.add(Dense(128)) # fully connected layer in keras
model.add(Activation('relu'))

# Dropout layer
model.add(Dropout(drop_prob))

# Readout layer
model.add(Dense(num_classes))
model.add(Activation('softmax'))

model.compile(loss = 'categorical_crossentropy',
              optimizer = 'adam',
              metrics = ['accuracy'])

# Training settings
batch_size = 128
num_epoch = 2

# fit training data to model
model.fit(train_images, mnist.train.labels, batch_size = batch_size, nb_epoch = num_epoch,
          verbose = 1, validation_data = (test_images, mnist.test.labels))

