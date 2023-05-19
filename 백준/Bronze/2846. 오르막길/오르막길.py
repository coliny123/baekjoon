from sys import stdin

N = int(stdin.readline())
heights = list(map(int, input().split()))
tmp_heights = []


top = bottom = heights[0]
for i in range(1, N):
    if heights[i] <= heights[i-1]:
        top = bottom = heights[i]
    else:   # heights[i] > heights[i-1]

        top = heights[i]
        tmp_heights.append(top - bottom)

tmp_heights.sort()
if len(tmp_heights) == 0:
    print("0")
else:
    print(tmp_heights[-1])