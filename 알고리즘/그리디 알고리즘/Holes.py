# 백준 3578번 - Holes

h = int(input())

if(h==0): 
    print(1)
elif(h==1): 
    print(0)
else:
    count_eight = h//2
    count_four = h%2
    res = (count_four*"4" + count_eight*"8")

    print(res)