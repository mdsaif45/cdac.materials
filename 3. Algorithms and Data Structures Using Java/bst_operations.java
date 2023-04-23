import javax.lang.model.util.ElementScanner6;

class node{
    int data;
    node left;
    node right;
}

class bst
{
    private node b;

    bst()
    {
        b = null;
    }
    
    int NoLeafNodes()
    {
        if(b!=null)
            return(NoLeafNodes(b.left)+NoLeafNodes(b.right));
        else
        {
            System.out.println("Tree is empty\n");
            return 0;
        }
    }

    int NoLeafNodes(node curr)
    {
        if(curr == null)
            return 0 ;
        if(curr.left == null&& curr.right==null)
            return 1;
        return (NoLeafNodes(curr.left)+NoLeafNodes(curr.right));
    }

    int NoNonLeafNodes()
    {
        if(b!=null)
        return(NoNonLeafNodes(b.left)+NoNonLeafNodes(b.right));
         else
        {
             System.out.println("Tree is empty\n");
             return 0;
         }
   }


   int NoNonLeafNodes(node curr)
   {
        if(curr == null)
        return 0;
        if(curr.left == null && curr.right == null)
            return 0;
        return (NoNonLeafNodes(curr.left)+NoNonLeafNodes(curr.right)+1);
   }


    int height()
    {
        if(b!=null)
            return(height(b));
        else
        {
            System.out.println("No tree\n");
            return -1;
        }
    }

    int height(node curr)
    {
        if(curr==null)
            return -1;
        if(curr.left == null && curr.right == null)
            return 0;
        return(max(height(curr.left), height(curr.right))+1);
    }

    int Find_max(node curr)
    {
        if(curr!=null)
        {
            while(curr.right!=null)
                curr = curr.right;
            return curr.data;
        }
        return -1;
    }

    int Find_min(node curr)
    {
        if(curr!=null)
        {
            while(curr.left!=null)
                curr = curr.left;
            return curr.data;
        }
       return -1;
    }

    void inorder()
    {
        if(b!=null)
            inorder(b);
        else
            System.out.println("Tree is empty\n");
    }

    void inorder(node curr)
    {
        if(curr!=null)
        {
            inorder(curr.left);
            System.out.println(curr.data);
            inorder(curr.right);
        }
    }

    void preorder()
    {
        if(b!=null)
            preorder(b);
        else
            System.out.println("Tree is empty\n");

    }

    void preorder(node curr)
    {
        if(curr!=null)
        {
            System.out.println(curr.data);
            preorder(curr.left);
            preorder(curr.right);
        }
    }

    void postorder()
    {
        if(b!=null)
            postorder(b);
        else
            System.out.println("Tree is empty\n");

    }

    void postorder(node curr)
    {
        if(curr!=null)
        {
            postorder(curr.left);
            postorder(curr.right);
            System.out.println(curr.data);
        }
    }

    void insert_ele(int ele)
    {
        node temp;
        temp = new node();
        temp.data = ele;
        temp.left = temp.right = null;
        if(b == null)
            b= temp;
        else    // tree to travel
        {
            node curr;
            curr = b;
            while(true)
            {
                if(ele<curr.data)
                {
                    if(curr.left!= null)
                        curr=curr.left;
                    else
                    {
                        curr.left = temp;
                        break;
                    }
                }   
                else
                {
                    if(curr.right!=null)
                        curr = curr.right;
                    else
                    {
                        curr.right = temp ;
                        break;
                    }
                }
            }   
        }
    }


    void delete_ele(int ele)
    {

        if(b!=null)
        {
            b = delete_ele(ele, b);
        }
        else
         System.out.println("Tree is empty\n");
  
    }

    node delete_ele(int ele, node curr)
    {
        if(curr!=null)
        {
            if(ele > curr.data)
                curr.right = delete_ele(ele, curr.right);
            else
                if(ele < curr.data)
                    curr.left = delete_ele(ele, curr.left);
                else    // we found the element
                {
                    if(curr.left!=null && curr.right!=null)  // two children
                    {
                        curr.data = Find_min(curr.right);
                        curr.right = delete_ele(curr.data, curr.right);
                    }
                    else    // no children or one child
                    {
                        if(curr.left == null)
                            curr = curr.right;
                        else
                            curr = curr.left;
                    }
                }
        }
         return curr;
    }

}

public class bst_operations{

public static void main(String[] args) {
    

    //code
}

}