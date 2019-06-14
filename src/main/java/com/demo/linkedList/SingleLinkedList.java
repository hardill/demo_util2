package com.demo.linkedList;

/**
 * @program: demo_util
 * @description: 单链表
 * @author: Mr.Huang
 * @create: 2019-03-12 17:38
 **/
public class SingleLinkedList {

    private int size;
    private Node head;

    public SingleLinkedList(){
        this.size=0;
        this.head=null;
    }

    private class Node{
        private Object data;
        private Node next;
        public Node(Object obj){
            this.data=obj;
        }
    }

    /**新增
     * @param data
     * @return
     */
    public Node addHead(Object data){
        Node newHead = new Node(data);
        if(size==0){
            head=newHead;
        }else {
            newHead.next=head;
            head=newHead;
        }

        size++;
        return newHead;
    }

    /**删除链表头
     * @return
     */
    public Object deleteHead(){
        Object obj = head.data;
        head=head.next;
        size--;
        return obj;
    }

    /**根据信息查找节点
     * @param date
     * @return
     */
    public Node find(Object date){
        Node current =head;
        int tempSize =size;

        while (tempSize>0){
            if(date.equals(current.data)){
                return current;
            }else{
                tempSize--;
                current=head.next;
            }
        }
        return null;
    }

    /**删除指定元素
     * @param data
     * @return
     */
    public boolean delete(Object data){
        if(size==0){
            return false;
        }

        Node current =head;
        Node previous  =head;
        while (!current.data.equals(data)){
            if(current.next==null){
                return false;
            }else {
                previous = current;
                current=current.next;
            }


            if(current==head){
                // 删除节点为首节点
                head=current.next;
                size--;
            }else{
                //删除节点非首节点
                previous.next=current.next;
                size--;
            }
        }
        return true;

    }

    /**链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 打印节点信息
     */
    public void  display(){
        if(size>0){

            if(size==1){
                System.out.println(head.data);
                return;
            }

            Node current =head;
            int tempSize = size;
            while (tempSize>0){
                if(current.equals(head)){
                    System.out.println(current.data+"->");
                }else if(current.next==null){
                    System.out.println(current.data);
                }else {
                    System.out.println(current.data+"->");
                }

                current=current.next;
                tempSize--;
            }
        }else{
            System.out.println("[]");
        }


    }


}
