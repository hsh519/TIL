#ifndef CIRCULARLINKEDLIST_H

#define CIRCULARLINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>

/* 타입 선언 */
typedef struct nodeType {
    int Data;
    struct nodeType* PrevNode;
    struct nodeType* NextNode;
} Node;

/* 함수 선언 */
Node* CLL_CreateNode(int NewData); // 노드 생성
void CLL_AppendNode(Node** ListHead, Node* NewNode); // 노드 추가
void CLL_RemoveNode(Node** ListHead, Node* RemoveNode); // 노드 삭제
void CLL_DestroyNode(Node* DestroyNode);// 노드 소멸
void CLL_InsertNode(Node* Current, Node* InsertNode); // 노드 삽입
int CLL_CountNode(Node* Head); // 노드 개수 세기
Node* CLL_SearchNode(Node* Head, int Location); // 노드 탐색

#endif