import sys
from copy import deepcopy

n = int(sys.stdin.readline())
k = int(sys.stdin.readline())

apples = []
turn = []
head_d = 0
snake = [[0,0]]
answer = 0
turn_cnt = 0

for i in range(k):
    x, y = map(int, sys.stdin.readline().rsplit())
    apples.append([y-1, x-1])

l = int(sys.stdin.readline())

for i in range(l):
    s, d = sys.stdin.readline().rstrip().rsplit()
    s = int(s)
    turn.append([s, d])

while True:
    answer += 1
    x, y = snake[0][0], snake[0][1]
    if head_d == 0:
        snake[0][0] += 1
    elif head_d == 1:
        snake[0][1] += 1
    elif head_d == 2:
        snake[0][0] -= 1
    else:
        snake[0][1] -= 1
    
    if snake[0][0] < 0 or snake[0][0] >= n or snake[0][1] < 0 or snake[0][1] >= n or snake[0] in snake[1:]:
        print(answer)
        break

    if snake[0] in apples:
        idx = apples.index(snake[0])
        apples[idx] = 0
        snake.insert(1, [x,y])
    else:
        if len(snake) >= 3:
            for i in range(len(snake)-1,1,-1):
                snake[i] = deepcopy(snake[i-1])
        if len(snake) >= 2:
            snake[1][0], snake[1][1] = x, y
    
    if answer == turn[turn_cnt][0]:
        direction = turn[turn_cnt][1]
        if direction == 'D':
            head_d = (head_d + 1) % 4
        else:
            head_d = (head_d - 1) % 4
        
        if turn_cnt < l-1:
            turn_cnt += 1