box = 1
w = 0
n, m = map(int, input().split())

if n == 0:
    print(0)
else:
    books = list(map(int, input().split()))
    for book in books:
        if (w + book) > m:
            box += 1
            w = book
        else:
            w += book
    print(box)