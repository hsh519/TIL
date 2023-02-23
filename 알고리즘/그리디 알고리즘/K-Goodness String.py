# 백준 22999번 - K-Goodness String

for i in range(int(input())):
    n, k = input().split()
    string = input()
    not_same = 0

    for j in range(len(string)//2):
        if string[j] != string[int(n)-j-1]:
            not_same += 1

    print("Case #{}: {}".format(i+1, abs(int(k) - not_same)))
