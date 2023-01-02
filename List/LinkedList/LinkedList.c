#include "LinkedList.h"

/* 노드 생성 */
Node* SLL_CreateNode(int NewData) {
    // 자유 메모리에 노드 사이즈 만큼 할당한 후 메모리 주소를 저장
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;
    NewNode->NextNode = NULL;

    return NewNode;
}

/* 노드 추가 */
void SLL_AppendNode(Node** ListHead, Node* NewNode) {
    if(*ListHead == NULL) {
        *ListHead = NewNode;
    } else {
        Node* Tail = *ListHead;
        while(Tail != NULL) {
            Tail = Tail->NextNode;
    }
    Tail->NextNode = NewNode;
    }
}

/* 노드 삭제 */
void SLL_RemoveNode(Node** ListHead, Node* RemoveNode) {
    if(*ListHead == RemoveNode) {
        *ListHead = RemoveNode->NextNode;
    } else {
        Node* Current = *ListHead;
        while(Current != NULL && Current->NextNode != RemoveNode) {
            Current = Current->NextNode;
        }
        if(Current != NULL) {
            Current->NextNode = RemoveNode->NextNode;
        }
    }
}

/* 노드 소멸 */
void SLL_DestroyNode(Node* DestroyNode) {
    free(DestroyNode);
}

/* 노드 삽입 */
void SLL_InsertNode(Node* Current, Node* InsertNode) {
    InsertNode->NextNode = Current->NextNode;
    Current->NextNode = InsertNode;
}

/* 노드 개수 세기 */
int SLL_CountNode(Node* Head) {
    int Count = 0;
    Node* Current = Head;

    while(Current != NULL) {
        Count++;
        Current = Current->NextNode;
    }
    
    return Count;
}

/* 노드 탐색 */
Node* SLL_SearchNode(Node* Head, int Location) {
    Node* Current = Head;

    for(int i=0; i<Location; i++) {
        Current = Current->NextNode;
    }

    return Current;
}