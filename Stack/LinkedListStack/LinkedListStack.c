#include "LinkedListStack.h"

void LLS_CreateStack(LinkedListStack** Stack) {
    *Stack = (LinkedListStack*)malloc(sizeof(LinkedListStack));
    (*Stack)->List = NULL;
    (*Stack)->Tail = NULL;
}

void LLS_DestroyStack(LinkedListStack* Stack) {
    while(! LLS_IsEmpty(Stack)) {
       Node* PopNode = LLS_Pop(Stack);
       LLS_DestroyNode(PopNode);
    }
    free(Stack);    
}

Node* LLS_CreateNode(int NewData) {
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;
    NewNode->NextNode = NULL;

    return NewNode;
}

Node* LLS_DestroyNode(Node* DestroyNode) {
    free(DestroyNode);
}

void LLS_Push(LinkedListStack* Stack, Node* NewNode) {
    if(Stack->List == NULL) {
        Stack->List = NewNode;
        Stack->Tail = NewNode;
    } else {
        Node* Current = Stack->List;
        while(Current != Stack->Tail) {
            Current = Current->NextNode;
        }
        Current->NextNode = NewNode;
        Stack->Tail = NewNode;
    }
}

Node* LLS_Pop(LinkedListStack* Stack) {
    Node* PopNode = Stack->Tail;

    if(PopNode == Stack->List) {
        Stack->List = NULL;
        Stack->Tail = NULL;
    } else {
        Node* Current = Stack->List;
        while(Current != NULL && Current->NextNode != PopNode) {
            Current = Current->NextNode;
        }
        Stack->Tail = Current;
        Current->NextNode = NULL;
    }

    return PopNode;
}

Node* LLS_Top(LinkedListStack* Stack) {
    return Stack->Tail;
}

int LLS_GetSize(LinkedListStack* Stack) {
    Node* Current = Stack->List;
    int Count = 0;

    while(Current != NULL) {
        Count++;
        Current = Current->NextNode;
    }
    return Count;
}

int LLS_IsEmpty(LinkedListStack* Stack) {
    return Stack->List == NULL;
}