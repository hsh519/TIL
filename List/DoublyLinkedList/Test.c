#include "DoublyLinkedList.h"

int main(void) {
    Node* List = NULL;
    Node* PrintNode = NULL;
    Node* NewNode = NULL;
    int Count = 0;
    /* 노드 5개 추가 */
    for(int i=0;i<5;i++) {
        DLL_AppendNode(&List, DLL_CreateNode(i));
    }

    /* 리스트 출력 */
    for(int i=0;i<DLL_CountNode(List);i++) {
        PrintNode = DLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }

    /* 3번째 노드 뒤에 새 노드 삽입 */
    NewNode = DLL_SearchNode(List, 2);
    DLL_InsertNode(NewNode, DLL_CreateNode(3000));
    printf("리스트 [2]번째 뒤에 3000 값을 삽입합니다!!\n");

    /* 삽입 후 리스트 출력 */
    for(int i=0;i<DLL_CountNode(List);i++) {
        PrintNode = DLL_SearchNode(List, i);
        printf("List[%d] : %d\n", i, PrintNode->Data);
    }
    
    /* 모든 노드를 메모리에서 제거 */
    Count = DLL_CountNode(List);
    
    for(int i=0;i<Count;i++) {
        PrintNode = DLL_SearchNode(List, 0);
        DLL_RemoveNode(&List, PrintNode);
        DLL_DestroyNode(PrintNode);
        
        
    }
}
