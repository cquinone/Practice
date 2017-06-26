import tensorflow as tf

sess = tf.Session()

# Printing Strings?
hello = tf.constant("Hello Pluralsight from TensorFlow")
print(sess.run(hello))



# Math?
a = tf.constant(20)
b = tf.constant(22)
print('a + b = {0}'.format(sess.run(a + b)))
