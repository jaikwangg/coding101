import numpy as np
import matplotlib.pyplot as plt

#1
arr = np.zeros((3, 10, 10))
arr[0]=1 ; arr[1]=2 ; arr[2]=3
a = np.arange(1,11)
Transa = a[:, np.newaxis]
arr2 = np.zeros((10,1))
newArr2 = arr2 + Transa
cal = np.matmul(arr, newArr2)
#arr
print('Matmul (shape) : ')
print(cal.shape)
print('Result : ', cal)

# 2
n = 50
x = np.arange(-n,n,5)
y =  np.arange(-n,n,5)
xx, yy = np.meshgrid(x, y, sparse=True)
q = -1.6e-19
r = np.sqrt(xx**2 + yy**2)
V = q / r

plt.imshow(V)

# 3
ranArr = np.random.rand(3,10,10)
# ranArr.shape 3 10 10
ranArr[ (ranArr > 0.3) & (ranArr < 0.7)] = 0
ranArr

# 4

black_image = np.zeros((512, 512))
black_image[1, : ] =1
#             Y        X
black_image[80:100, 130:230] = 1
black_image[80:120, 300:400] = 1
black_image[220:240, 200:210] = 1
black_image[220:240, 230:240] =1
black_image[150:180, 180:210] = 1 # left eye
black_image[150:180, 300:330]= 1 # right eye
black_image[300:450, 130:200] = 1 # mouth
plt.imshow(black_image, cmap='gray')