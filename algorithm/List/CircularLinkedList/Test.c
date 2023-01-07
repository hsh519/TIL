#include "CircularLinkedList.h"

int main(void) {
    Node* List = NULL;
    Node* PrintNode = NULL;
    Node* NewNode = NULL;
    int Count = 0;
    /* 노드 5개 추가 */
    for(int i=0;i<5;i++) {
        CLL_AppendNode(&List, CLL_CreateNode(i));
    }

    /* 리스트 출력 */
    for(int i=0;i<CLL_CountNode(List);i++) {
        PrintNode = CLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }

    /* 3번째 노드 뒤에 새 노드 삽입 */
    printf("\n");
    NewNode = CLL_SearchNode(List, 2);
    CLL_InsertNode(NewNode, CLL_CreateNode(3000));
    printf("리스트 [2]번째 뒤에 3000 값을 삽입합니다!!\n\n");

    /* 삽입 후 리스트 출력 */
    for(int i=0;i<CLL_CountNode(List)*2;i++) {
        PrintNode = CLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }
    
    /* 모든 노드를 메모리에서 제거 */
    printf("\n");
    printf("모든 노드르 제거합니다..\n\n");
    Count = CLL_CountNode(List);
    
    for(int i=0;i<Count;i++) {
        PrintNode = CLL_SearchNode(List, 0);
        CLL_RemoveNode(&List, PrintNode);
        CLL_DestroyNode(PrintNode);
        
        
    }
}
