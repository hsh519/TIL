answer = [i for i in range(1,10001)]
i, res = 1, 0

while i < 10000:
    if i <= 9:
        res = i+i
    elif i <= 99:
        res = i + i//10 + i%10
    elif i <= 999:
        res = i + i//100 +  (i%100)//10 + (i%100)%10
    elif i <= 9999:
        res = i + i//1000 +  (i%1000)//100 + ((i%1000)%100)//10 + ((i%1000)%100)%10
    if res in answer:
        answer[res-1] = 0
    i += 1

for n in answer:
    if n == 0:
        continue
    else:
        print(n)
