import sys

t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    arr = [int(e) for e in sys.stdin.readline().split()]
    prefix_num = [arr[0]]

    for i in range(1,len(arr)):
        prefix_num.append(arr[i] + prefix_num[i-1])

    answer = max(prefix_num)
    
    for i in range(len(arr)-1):
        prefix_num = list(map(lambda x: x-arr[i], prefix_num))
        max_num = max(prefix_num[i+1:])
        answer = max(answer, max_num)
    print(answer)
