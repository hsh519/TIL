l1 = list(map(int, input().split()))
l2 = sorted(l1)
l3 = sorted(l1, reverse=True)

if l1 == l2:
    print("ascending")
elif l1 == l3:
    print("descending")
else:
    print("mixed")