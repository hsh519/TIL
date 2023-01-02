/* #define 문장으로 LINKEDLIST_H 를 정의하지 않았다면 */
#ifndef LINKEDLIST_H

/* 실행 문장 */
#define LINKEDLIST_H

#include <stdio.h>
#include <stdlib.h>

/* 타입 선언 */
typedef struct nodeType {
    int Data;
    struct nodeType* NextNode;
} Node;

/* 함수 선언 */
Node* SLL_CreateNode(int NewData); // 노드 생성
void SLL_AppendNode(Node** ListHead, Node* NewNode); // 노드 추가
void SLL_RemoveNode(Node** ListHead, Node* RemoveNode); // 노드 삭제
void SLL_DestroyNode(Node* DestroyNode);// 노드 소멸
void SLL_InsertNode(Node* Current, Node* InsertNode); // 노드 삽입
int SLL_CountNode(Node* Head); // 노드 개수 세기
Node* SLL_SearchNode(Node* Head, int Location); // 노드 탐색

#endif