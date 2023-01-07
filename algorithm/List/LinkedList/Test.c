#include "LinkedList.h"

int main(void) {
    Node* List = NULL;
    Node* PrintNode = NULL;
    Node* NewNode = NULL;
    int Count = 0;

    /* 노드 5개 추가 */
    for(int i=0;i<5;i++) {
        SLL_AppendNode(&List, SLL_CreateNode(i));
    }

    /* 리스트 출력 */
    for(int i=0;i<SLL_CountNode(List);i++) {
        PrintNode = SLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }

    /* 3번째 노드 뒤에 새 노드 삽입 */
    NewNode = SLL_SearchNode(List, 2);
    SLL_InsertNode(NewNode, SLL_CreateNode(3000));
    printf("\n리스트 [2]번째 뒤에 3000 값을 삽입합니다!!\n\n");

    /* 삽입 후 리스트 출력 */
    for(int i=0;i<SLL_CountNode(List);i++) {
        PrintNode = SLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }

    /* 모든 노드를 메모리에서 제거 */
    Count = SLL_CountNode(List);
    
    for(int i=0;i<Count;i++) {
        PrintNode = SLL_SearchNode(List, 0);
        SLL_RemoveNode(&List, PrintNode);
        SLL_DestroyNode(PrintNode);   
    }
}