import sys

hap1 = 0
hap2 = 0
d = {
    'A+': 4.5,
    'A0': 4.0,
    'B+': 3.5,
    'B0': 3.0,
    'C+': 2.5,
    'C0': 2.0,
    'D+': 1.5,
    'D0': 1.0,
    'F': 0.0
}

for i in range(20):
    a = sys.stdin.readline().rstrip().rsplit()
    score, grade = float(a[1]), a[2]
    if grade == 'P':
        continue
    hap1 += score * d[grade]
    hap2 += score

print(hap1/hap2)