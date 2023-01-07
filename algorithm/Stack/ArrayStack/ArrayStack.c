#include "ArrayStack.h"

/* 스택 생성 */
void AS_CreateStack(ArrayStack** Stack, int Capacity) {
    *Stack = (ArrayStack*)malloc(sizeof(ArrayStack));

    (*Stack)->Nodes = (Node*)malloc(sizeof(Node)*Capacity);
    (*Stack)->Capacity = Capacity;
    (*Stack)->Top = 0;
}

/* 스택 소멸 */
void AS_DestroyStack(ArrayStack* Stack) {
    free(Stack->Nodes);
    free(Stack);
}

/* 스택 삽입 연산 */
void AS_Push(ArrayStack* Stack, int Data) {
    int Position = Stack->Top;
    Stack->Nodes[Position].Data = Data;
    ++(Stack->Top);
}

/* 스택 제거 연산 */
int AS_Pop(ArrayStack* Stack) {
    return Stack->Nodes[--(Stack->Top)].Data;
}

/* 스택의 최상위 노드 반환하는 함수 */
int AS_Top(ArrayStack* Stack) {
    return Stack->Nodes[(Stack->Top) - 1].Data;
}

/* 스택의 노드 개수를 반환하는 함수 */
int AS_GetSize(ArrayStack* Stack) {
    return Stack->Top;
}

/* 스택이 비었는지 검사하는 함수 */
int AS_IsEmpty(ArrayStack* Stack) {
    return Stack->Top == 0;
}