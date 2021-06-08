# K-means-to-reduce-color-information
Implementing the k-means algorithm in Java and using it reduce color information in a colored image.
This assignment was based on the K-means algorithm. We used it to reduce the color information in an image. We used Java to implement this algorithm, because we found the process of image handling in this language quite hassle-free.

After implementing the algorithm, we put in different values of k and got different results. The results were even different when the value of k was the same and the algorithm was stopped and re-run. This is because every time the algorithm was re-run, the initial values of the k-means were computed randomly, hence converging to different values at the end of each run. The following is the original image we were provided with:

![image](https://user-images.githubusercontent.com/54366232/120939399-5519a100-c731-11eb-8de0-81270da5b1e9.png)
 
In the following section of this report, we will be displaying the values of k and the image that resulted at each value:

K = 3

![image](https://user-images.githubusercontent.com/54366232/120939406-62cf2680-c731-11eb-81e6-a6206af126ec.png)

K = 4

![image](https://user-images.githubusercontent.com/54366232/120939452-a2960e00-c731-11eb-89de-b3a044519a89.png)


K = 5

![image](https://user-images.githubusercontent.com/54366232/120939456-a6c22b80-c731-11eb-8b2b-ddd2855d05fa.png)


K = 6

![image](https://user-images.githubusercontent.com/54366232/120939460-ac1f7600-c731-11eb-80b0-d53a772bcfa9.png)


K = 7

![image](https://user-images.githubusercontent.com/54366232/120939476-bd688280-c731-11eb-906b-298f10374d8e.png)


K = 8

![image](https://user-images.githubusercontent.com/54366232/120939482-bfcadc80-c731-11eb-86f9-871fde80f3bd.png)


K = 9

![image](https://user-images.githubusercontent.com/54366232/120939487-c35e6380-c731-11eb-8084-3d9ed87837d3.png)


K = 10

![image](https://user-images.githubusercontent.com/54366232/120939488-c6595400-c731-11eb-8306-d44d91624979.png)


K = 15

![image](https://user-images.githubusercontent.com/54366232/120939496-c9ecdb00-c731-11eb-8f2a-dd7000f69aa9.png)


K = 20

![image](https://user-images.githubusercontent.com/54366232/120939499-cd806200-c731-11eb-864f-d054916a0d8d.png)


K = 30

![image](https://user-images.githubusercontent.com/54366232/120939505-d1ac7f80-c731-11eb-8aa9-d833c69ab3ed.png)


K = 40

![image](https://user-images.githubusercontent.com/54366232/120939509-d4a77000-c731-11eb-9487-00ad5f80cecf.png)


K = 50

![image](https://user-images.githubusercontent.com/54366232/120939516-da9d5100-c731-11eb-90d4-c8530669eccb.png)



As is evident in the images, as the value of k increases, so does the resemblance of the image to the original one. This is because k represents the total number of colors in the image. When k is small, the image looks disfigured and somewhat unrecognizable. But as k increases and more colors are added to the image, it starts to look more and more like the original one.
Predictably, When we put k = 255, we got an image that looks similar to the original one.

K = 255

![image](https://user-images.githubusercontent.com/54366232/120939534-eb4dc700-c731-11eb-836f-91994c4f4bf6.png)



