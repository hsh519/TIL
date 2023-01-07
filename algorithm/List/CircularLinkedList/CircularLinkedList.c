#include "CircularLinkedList.h"


/* 노드 생성 */
Node* CLL_CreateNode(int NewData) {
    // 자유 메모리에 노드 사이즈 만큼 할당한 후 메모리 주소를 저장
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;
    NewNode->NextNode = NULL;
    NewNode->PrevNode = NULL;

    return NewNode;
}

/* 노드 추가 */
void CLL_AppendNode(Node** ListHead, Node* NewNode) {
    if(*ListHead == NULL) {
        *ListHead = NewNode;
        (*ListHead)->NextNode = *ListHead;
        (*ListHead)->PrevNode = *ListHead;
    } else {
        Node* Tail = (*ListHead)->PrevNode;
        Tail->NextNode = NewNode;
        NewNode->NextNode = *ListHead;
        (*ListHead)->PrevNode = NewNode;
        NewNode->PrevNode = Tail;
    }
}

/* 노드 삭제 */
void CLL_RemoveNode(Node** ListHead, Node* RemoveNode) {
    if(*ListHead == RemoveNode) {
        *ListHead = RemoveNode->NextNode;

        (*ListHead)->PrevNode = RemoveNode->PrevNode;
        RemoveNode->PrevNode->NextNode = (*ListHead);
        
        RemoveNode->PrevNode = NULL;
        RemoveNode->NextNode = NULL;
    } else {
        Node* Temp = RemoveNode;
       
        RemoveNode->PrevNode->NextNode = Temp->NextNode;
        RemoveNode->NextNode->PrevNode = Temp->PrevNode;
       
        RemoveNode->PrevNode = NULL;
        RemoveNode->NextNode = NULL;
    }
}

/* 노드 소멸 */
void CLL_DestroyNode(Node* DestroyNode) {
    free(DestroyNode);
}

/* 노드 삽입 */
void CLL_InsertNode(Node* Current, Node* InsertNode) {
    InsertNode->NextNode = Current->NextNode;
    Current->NextNode = InsertNode;
    InsertNode->PrevNode = Current;
    if(Current->NextNode != NULL) {
        Current->NextNode->PrevNode = InsertNode;
    }
}

/* 노드 개수 세기 */
int CLL_CountNode(Node* Head) {
    int Count = 1;
    Node* Current = Head;

    while(Current != NULL && Current->NextNode == Head) {
        Count++;
        Current = Current->NextNode;
    }
    return Count;
}

/* 노드 탐색 */
Node* CLL_SearchNode(Node* Head, int Location) {
    Node* Current = Head;

    for(int i=0; i<Location; i++) {
        Current = Current->NextNode;
    }

    return Current;
}
