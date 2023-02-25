# 백준 14487번 - 욱제는 효도쟁이야

n = int(input())
distance = list(map(int, input().split()))

print(sum(distance) - max(distance))