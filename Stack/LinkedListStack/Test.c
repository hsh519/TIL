#include "LinkedListStack.h"

int main(void) {
    int Count = 0;
    Node* Popped;

    LinkedListStack* Stack;

    LLS_CreateStack(&Stack);

    LLS_Push(Stack, LLS_CreateNode(112));
    LLS_Push(Stack, LLS_CreateNode(122));
    LLS_Push(Stack, LLS_CreateNode(132));
    LLS_Push(Stack, LLS_CreateNode(142));

    Count = LLS_GetSize(Stack);
    printf("Size: %d, Top: %d\n\n", Count, LLS_Top(Stack)->Data);

    for(int i=0; i<Count; i++) {
        if(LLS_IsEmpty(Stack)) { break; }
        
        Popped = LLS_Pop(Stack);
        printf("Popped: %d, ", Popped->Data);
        LLS_DestroyNode(Popped);

        if(! LLS_IsEmpty(Stack)) {
            printf("Current Top: %d\n", LLS_Top(Stack)->Data);
        } else {
            printf("Stack is Empty.\n");
        }
    }

    LLS_DestroyStack(Stack);

    return 0;
}