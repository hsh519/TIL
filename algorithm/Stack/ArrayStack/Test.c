#include "ArrayStack.h"

int main(void) {
    ArrayStack* Stack = NULL;
    

    AS_CreateStack(&Stack, 10);

    AS_Push(Stack, 20);
    AS_Push(Stack, 30);
    AS_Push(Stack, 40);
    AS_Push(Stack, 50);

    printf("Capacity: %d, Size: %d, Top: %d\n\n", Stack->Capacity, AS_GetSize(Stack), AS_Top(Stack));

    int size = AS_GetSize(Stack);

    for(int i=0; i<size; i++) {
        if(AS_IsEmpty(Stack)) { break; }

        printf("Popped: %d, ", AS_Pop(Stack));

        if(! AS_IsEmpty(Stack)) {
            printf("Current Top: %d\n", AS_Top(Stack));
        } else {
            printf("Stack is Empty\n");
        }
    }

    AS_DestroyStack(Stack);

    return 0;
}