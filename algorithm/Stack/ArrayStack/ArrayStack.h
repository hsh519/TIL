#ifndef ARRAYSTACK_H

#define ARRAYSTACK_H

#include <stdio.h>
#include <stdlib.h>

typedef struct tagNode {
    int Data;
} Node;

typedef struct tagArrayStack
{
    int Capacity;
    int Top;
    Node* Nodes;
} ArrayStack;

void AS_CreateStack(ArrayStack** stack, int Capacity);
void AS_DestroyStack(ArrayStack* stack);
void AS_Push(ArrayStack* stack, int Data);
int AS_Pop(ArrayStack* stack);
int AS_Top(ArrayStack* stack);
int AS_GetSize(ArrayStack* stack);
int AS_IsEmpty(ArrayStack* stack);


#endif