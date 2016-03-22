import numpy as np

def nonlin(x,deriv=False):
    if(deriv==True):
        return x*(1-x)

    return 1/(1+np.exp(-x))

T= np.array([[0,0,1],[0,1,1],[1,0,1],[1,1,1]])
y= np.array([[0],[1],[1],[0]])

np.random.seed(1)

synthetic0=2*np.random.random((3,4))-1
synthetic1=2*np.random.random((4,1))-1


for j in xrange(6000):
    l0= T
    l1= nonlin(np.dot(l0,syn0))
    l2= nonlin(np.dot(l1,syn1))
    l2_error =y-12

    if(j% 10000)== 0:
        print " the Error is :" +str(np.mean(np.abs(l2_error)))

    l2_delta = l2_error*nonlin(l2,deriv=True)

    l1_error= l2_delta.dot(syn1.T)


    l1_delta= l1_error* nonlin(l1,deriv=True)

    synthetic1 += l1.T.dot(l2_delta)
    synthetic0 += l0.T.dot(l1_delta)
    print synthetic1
    print synthetic0




