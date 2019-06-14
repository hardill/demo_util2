package com.demo.linkedList;

/**
 * @program: demo_util
 * @description: 双端链表
 * @author: Mr.Huang
 * @create: 2019-03-12 17:38
 **/
public class DoublePointLinkedList {

    private int size;
    /**头节点*/
    private Node head;
    /**尾节点*/
    private Node tail;

    public DoublePointLinkedList(){
        this.size=0;
        this.head=null;
        this.tail=null;
    }

    private class Node{
        private Object data;
        private Node next;
        public Node(Object obj){
            this.data=obj;
        }
    }

    /**新增头节点
     * @param data
     */
    public void addHead(Object data){
        Node node = new Node(data);
        if(size==0){
            head=node;
            tail=node;
        }else {
           node.next=head;
           head=node;
        }
        size++;
    }

    /**新增尾节点
     * @param data
     */
    public void addTail(Object data){
        Node node = new Node(data);
        if(size==0){
            head=node;
            tail=node;
        }else {
            tail.next=node;
            tail=node;
        }
        size++;
    }

    /**删除头节点
     * @return
     */
    public boolean deleteHead(){
        if(size==0){
            return false;
        }

        if(head.next==null){
            head=null;
            tail=null;
        }else{
            head=head.next;
        }
        size--;
        return true;
    }
}
