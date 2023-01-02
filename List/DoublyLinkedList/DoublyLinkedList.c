#include "DoublyLinkedList.h"


/* 노드 생성 */
Node* DLL_CreateNode(int NewData) {
    // 자유 메모리에 노드 사이즈 만큼 할당한 후 메모리 주소를 저장
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;
    NewNode->NextNode = NULL;
    NewNode->PrevNode = NULL;

    return NewNode;
}

/* 노드 추가 */
void DLL_AppendNode(Node** ListHead, Node* NewNode) {
    if(*ListHead == NULL) {
        *ListHead = NewNode;
    } else {
        Node* Tail = *ListHead;
        while(Tail->NextNode != NULL) {
            Tail = Tail->NextNode;
    }
    Tail->NextNode = NewNode;
    NewNode->PrevNode = Tail;
    }
}

/* 노드 삭제 */
void DLL_RemoveNode(Node** ListHead, Node* RemoveNode) {
    if(*ListHead == RemoveNode) {
        *ListHead = RemoveNode->NextNode;
        if(*ListHead != NULL) {
            (*ListHead)->PrevNode = NULL;
        }
        RemoveNode->PrevNode = NULL;
        RemoveNode->NextNode = NULL;
    } else {
        Node* Temp = RemoveNode;
       
       RemoveNode->PrevNode->NextNode = Temp->NextNode;
       
       if(RemoveNode->NextNode != NULL) {
           RemoveNode->NextNode->PrevNode = Temp->PrevNode;
       }
       
        RemoveNode->PrevNode = NULL;
        RemoveNode->NextNode = NULL;
    }
}

/* 노드 소멸 */
void DLL_DestroyNode(Node* DestroyNode) {
    free(DestroyNode);
}

/* 노드 삽입 */
void DLL_InsertNode(Node* Current, Node* InsertNode) {
    InsertNode->NextNode = Current->NextNode;
    Current->NextNode = InsertNode;
    InsertNode->PrevNode = Current;
    if(Current->NextNode != NULL) {
        Current->NextNode->PrevNode = InsertNode;
    }
}

/* 노드 개수 세기 */
int DLL_CountNode(Node* Head) {
    int Count = 0;
    Node* Current = Head;

    while(Current != NULL) {
        Count++;
        Current = Current->NextNode;
    }
    return Count;
}

/* 노드 탐색 */
Node* DLL_SearchNode(Node* Head, int Location) {
    Node* Current = Head;

    for(int i=0; i<Location; i++) {
        Current = Current->NextNode;
    }

    return Current;
}
