# Flip Bits

1 0 0 1 0 1
1 1 1 2 2 3 -> no of 1s till curr element
0 1 2 0 1 0 -> successive 0s count

Case 1: max of Successive 0s

1 0 0 1 0 0 1
1 1 1 2 2 2 3
0 1 2 0 1 2 0

Case 2: max if occurring more than 1 time


1 0 0 1 1 0 0 1 1 1 0
1 1 1 2 3 3 3 4 5 6 6
0 1 2 0 0 1 2 0 0 0 1

Curr Successive 0s
1s in b/w 0s

0,2,0,2,0,1
1,0,2,0,3,0

1s<0s => add to soln

NOTE: can be 2 sols separated by non idea in middle & right case can be max


100100
0s		0202
1s		1010

To add next, 1s should be less than both side 0s

## Corner Cases

10010011000100
0s		02020302
1s		10102010
================
0s		03020302
1s		10102010
================
0s		03020402
1s		10102010
================
0s		02020302
1s		10102010
