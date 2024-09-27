from sys import stdin

N = int(stdin.readline())
distances = list(map(int, stdin.readline().split()))
oil_prices = list(map(int, stdin.readline().split()))

total = 0
max = oil_prices[0]
for i in range(N-1):  # 0, 1, 2
    if oil_prices[i] < max:
        max = oil_prices[i]
    total += max * distances[i]

print(total)
