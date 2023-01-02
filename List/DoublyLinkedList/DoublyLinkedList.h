#ifndef DOUBLYLINKEDLIST_H

#define DOUBLYLINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>

/* 타입 선언 */
typedef struct nodeType {
    int Data;
    struct nodeType* PrevNode;
    struct nodeType* NextNode;
} Node;

/* 함수 선언 */
Node* DLL_CreateNode(int NewData); // 노드 생성
void DLL_AppendNode(Node** ListHead, Node* NewNode); // 노드 추가
void DLL_RemoveNode(Node** ListHead, Node* RemoveNode); // 노드 삭제
void DLL_DestroyNode(Node* DestroyNode);// 노드 소멸
void DLL_InsertNode(Node* Current, Node* InsertNode); // 노드 삽입
int DLL_CountNode(Node* Head); // 노드 개수 세기
Node* DLL_SearchNode(Node* Head, int Location); // 노드 탐색


#endif