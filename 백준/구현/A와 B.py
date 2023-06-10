import sys

start = sys.stdin.readline().rstrip()
end = sys.stdin.readline().rstrip()
answer = 0

while len(end) > 0:
    if end[-1] == 'B':
        end = end[::-1]
        end = end[1:]
    else:
        end = end[:-1]

    if end == start:
        answer = 1
        break

print(answer)