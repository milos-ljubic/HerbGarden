# HerbGarden
For this algorithm, we have two inputs, an array of integers and one integer.

The first thing we do is checking are all parameters are valid. For the array, we check a length of array and values of array elements. After checking we start to solve the algorithm.

First what we do is to sort the array. Considering that we need an element with maximum value, this will be very good for solving the algorithm. Max element in the sorted array will always be at last place of the array, so we can easily manipulate with that element.

After we sorted the array, we start countHarvest method in which we count harvested leaves. In that method, we have For loop which count days. Inside the loop, we use two separate methods. The first separate method is for making an array with values the very next day. At the end of that method, we have almost sorted the array. Only the last element isn't sorted. In the second method, we sort array again. When we finish new sorting we close the first-day iteration.

In the end, as a result, we have a number of leaves harvested from our plants.

In the main method, we add the method for print and test some examples for our algorithm.
