
#include <stdio.h>
#include <stdlib.h>
struct node {
int data;
struct node* next;
};

typedef struct node node;

node* head =NULL;
node* create_node(int data){
    node* temp = (node *)malloc(sizeof(node));
    temp->data = data;
    temp->next = NULL;

    return temp;
}
void add_node_last(int data){
    node* new_node= create_node(data);
  //  printf("new node is created at heap\n");
    if(head == NULL){
        head = new_node;
        return;
    }
    
    node* temp = head;
    while(temp->next !=NULL){
        temp = temp->next;
    }
    
    temp->next = new_node;
   //  printf("attached to last\n");
}
void traverse_list(){
    node* temp = head;
    while(temp != NULL){
        printf("data %d\n",temp->data);
        temp = temp->next;
    }
}

void insert_at_position(int data, int n){
    node* new_node = create_node(data);

    if(n == 1){
        new_node->next = head;
        head = new_node;
        return;
    }
    node* temp = head;
    
    for (int i = 1; i < n - 1 && temp != NULL; i++) {
        temp = temp->next;
    }

    new_node->next = temp->next;
    temp->next = new_node;
}

void deletion_at_position(int n){
    node* temp = head;
    for(int i=1;i<n-1;i++){
        temp=temp->next;
    }
    node* to_delete = temp->next;
    temp->next = temp->next->next;
    free(to_delete);
}
int main()
{
    add_node_last(2);
    insert_at_position(6,2);
    add_node_last(4);
    deletion_at_position(2);
    traverse_list();

    return 0;
}
