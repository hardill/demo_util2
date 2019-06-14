package com.demo.tree;

/**
 * @program: demo_util
 * @description: 二叉树实现
 * @author: Mr.Huang
 * @create: 2019-03-08 10:33
 **/
public class BinarySearchTree<T extends Comparable> implements Tree<T> {
    // 根节点
    protected BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryNode<T> data) {
        if (data == null) {
            return 0;
        }
        return size(data.left) + 1 + size(data.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(BinaryNode<T> data) {
        if (data == null) {
            return 0;
        }

        int l = height(data.left);
        int r = height(data.right);
        return l > r ? (l + 1) : (r + 1);

    }

    @Override
    public String preOrder() {
        String sb=preOrder(root);
        if(sb.length()>1){
            sb =sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    /**先根遍历,先根节点,再左节点,再右节点
     * @param data
     * @return
     */
    private String preOrder(BinaryNode<T> data) {
        StringBuffer sb = new StringBuffer();
        if(data!=null){
            sb.append(data.data).append(",");
            sb.append(preOrder(data.left));
            sb.append(preOrder(data.right));
        }
        return sb.toString();
    }

    /**中根遍历,先左节点,再跟节点,最后右节点
     * @return
     */
    @Override
    public String inOrder() {
        String sb=inOrder(root);
        if(sb.length()>1){
            sb =sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    private String inOrder(BinaryNode<T> data) {
        StringBuffer sb = new StringBuffer();
        if(data!=null){
            sb.append(inOrder(data.left));
            sb.append(data.data).append(",");
            sb.append(inOrder(data.right));
        }
        return sb.toString();
    }

    /**后跟次序算法
     * @return
     */
    @Override
    public String postOrder() {
        String sb=postOrder(root);
        if(sb.length()>1){
            sb =sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    private String postOrder(BinaryNode<T> data) {
        StringBuffer sb = new StringBuffer();
        if(data!=null){
            sb.append(postOrder(data.left));
            sb.append(postOrder(data.right));
            sb.append(data.data).append(",");
        }
        return sb.toString();
    }

    /**层次遍历算法
     * @return
     */
    @Override
    public String levelOrder() {
        LinkedQueue queue = new LinkedQueue();
        StringBuffer sb = new StringBuffer();
        BinaryNode p = this.root;
        while (p!=null){
            sb.append(p.data).append(",");
            if(p.left!=null){
                queue.add(p.left);
            }

            if(p.right!=null){
                queue.add(p.right);
            }

            p= (BinaryNode) queue.poll();
        }
        return sb.toString();
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data is null");
        }

        root = insert(data, root);
    }

    /**
     * 递归插入节点
     *
     * @param data
     * @param p
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> p) {
        if (p == null) {
            p = new BinaryNode<>(data);
        }

        int compare = data.compareTo(p.data);
        if (compare > 0) {
            //大于,放右节点
            p.right = insert(data, p.right);
        } else if (compare < 0) {
            // 小于,放左节点
            p.left = insert(data, p.left);
        } else {
            // 重复,无需插入
        }
        return p;
    }

    @Override
    public void remove(T data) {
        if (data == null) {
            throw new RuntimeException("data is null");
        }
        root = remove(data, root);
    }

    private BinaryNode<T> remove(T data, BinaryNode<T> p) {
        if (p == null) {
            return null;
        }

        int compare = data.compareTo(p.data);
        if (compare > 0) {
            //大于,在右节点
            p.right = remove(data, p.right);
        } else if (compare < 0) {
            // 小于,在左节点
            p.left = remove(data, p.left);
        } else if (p.left != null && p.right != null) {
            // 左右节点都有
            // 寻找中继节点
            p.data = findMin(p.right).data;
            //移除用于替换的节点
            p.right = remove(p.data, p.right);
        } else {
            // 仅单个子节点的情况
            p = (p.left != null) ? p.left : p.right;
        }

        return p;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new RuntimeException("tree is empty");
        }

        return findMin(root).data;
    }

    /**
     * 递归查找最小节点
     *
     * @param data
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> data) {
        if (data == null) {
            return null;
        } else if (data.left == null) {
            return data;
        }
        return findMin(data.left);
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("tree is empty");
        }

        return findMax(root).data;
    }

    /**
     * 递归查找最大节点
     *
     * @param data
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> data) {
        if (data == null) {
            return null;
        } else if (data.right == null) {
            return data;
        }
        return findMin(data.right);
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
