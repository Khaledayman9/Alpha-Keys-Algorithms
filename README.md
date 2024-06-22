# Alpha-Keys-Algorithms-Analysis
A unique problem inspired by the mystical world of Bode Locke and his magical keys. The goal is to help Bode unlock the maximum power of his ancestors' keys by arranging them in their optimal form, termed the "Alpha form."

# Description
Bode Locke, the youngest sibling in the Locke family, discovered that their ancestors house, in which they moved in recently, is full of magical keys. The keys in the house used to whisper to him till he finds them. He found one that can turn a person to a ghost when used on the library door, and one that can set the whole place on fire, and so many other keys with amazing powers. One day, Bode heard the whispers of a key, and after following the whispers he found a very strange new key. The new key was actually not just one key but a set of keys welded together onto a golden ring with numbers stamped on them representing their powers. This can be seen in Figure 1.

![Figure 1: Ring of Keys](https://github.com/Khaledayman9/Alpha-Keys-Analysis/assets/105018459/c5dce855-7293-45b7-9e09-0edfa528c81f))
 
With the keys, Bode found the instructions his ancestors left in order to be able to use those keys. If the keys are in the Alpha order, he will be able to unlock a gate to the surface of the moon. The Alpha unleash the maximum power of the ring, and that is done when the total power of the keys in the **even positions** is the **maximum** they can be. 
The thing is, he can not order the keys as he wishes (they are welded). So the only solution is to melt the ring at 2 parts, reverse the cut part and weld it again to the ring for the ring to be complete. This can only be done once, otherwise, the ring will be destroyed. An example can be seen in Figures 2 and 3, where the keys were altered to put them in the Alpha form.


![Figure 2: Melt the ring before Key 0 and after Key 3](https://github.com/Khaledayman9/Alpha-Keys-Analysis/assets/105018459/27c6c78d-653c-428f-9df4-1eaee9f20c24)

![Figure 3: Reverse the cut part and weld to ring](https://github.com/Khaledayman9/Alpha-Keys-Analysis/assets/105018459/52644f62-c235-438d-8e3e-54ebf92caa7b)

So now Bode needs to think if the keys are already in the Alpha form or he needs to reverse part of it. We can think about using the largest subrange problem as a starter.

# Deliverables
1. The goal is to use the Divide & Conquer approach to tell Bode, the combined power of the keys at the even positions in their Alpha form. The name of the function is **alpha**.
2. The goal is to use a Dynamic Programming approach to tell Bode the combined power of the keys at the even positions in their Alpha form. Your algorithm must run in **O(n)**. The name of the function is **alpha**.
3. The goal is to reconstruct the alpha form of the given keys so that Bode knows where to alter the chain to achieve the alpha form. The name of the function is **alphaRec**.

# Function Signatures
## For Divide and Conquer:
- **public static int alpha (int[] keys):**, that implements a divide and conquer approach to finding the combined power of the keys at the even positions after finding the Alpha form.
## For Dynamic Programming:
- **public static int alpha (int[] keys):**, that implements a dynamic programming approach to finding the combined power of the keys at the even positions after finding the Alpha form and returns that combined power.
## For Reconstruction:
- **public static int[] alphaRec (int[] keys):**, that implements the reconstruction of the alpha form by returning an array of size 2, containing the start and the end indices where Bode needs to cut at in order to achieve the alpha form.

# Test Cases:
## General Tests
### For Divide and Conquer:
1. First Test Case:
```plaintext
keys=[3]
Output alpha: 3
```

2. Second Test Case:
```plaintext
keys=[3,1,2,1]
Output alpha: 5
```

3. Third Test Case:
```plaintext
keys=[1,7,3,4,7,6,2,9]
Output alpha: 26
```

### For Dynamic Programming:
1. First Test Case:
```plaintext
keys=[3]
Output alpha: 3
```

2. Second Test Case:
```plaintext
keys=[3,1,2,1]
Output alpha: 5
```

3. Third Test Case:
```plaintext
keys=[1,7,3,4,7,6,2,9]
Output alpha: 26
```

### For Reconstruction:
1. First Test Case:
```plaintext
keys=[3]
Output alphaRec:[-1,-1]
```

2. Second Test Case:
```plaintext
keys=[3,1,2,1]
Output alphaRec:[-1,-1]
```

3. Third Test Case:
```plaintext
keys=[1,7,3,4,7,6,2,9]
Output alphaRec:[0,7]
```
## Public Tests
The following are examples of possible input arrays, their corresponding outputs and a description of how the output came about.

![Tests](https://github.com/Khaledayman9/Alpha-Keys-Analysis/assets/105018459/9c29daa2-6385-4eed-a67b-9d1b8abaccc8)


# Technologies
- Java
- Eclipse IDE
- JUnit
