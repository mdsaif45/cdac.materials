
class node{
    int data;
    node next;
    node prev;
}

class dll
{
    private node start;

    dll()
    {
        start = null;
    }

    void Insert_Beg(int ele)
    {
        node temp = new node();
        temp.data = ele;
        temp.prev = null;
        temp.next = start;
        if(start != null)
            start.prev = temp;
        start = temp;
    }

    void Insert_End(int ele)
    {
        node temp = new node();
        temp.data=ele;
        temp.next=null;
        if(start == null)
        {
            temp.prev = null;
            start = temp;
        }
        else{
            node curr;
            curr=start;
            while(curr.next!=null)
                curr= curr.next;
            temp.prev = curr;
            curr.next = temp;
        }
    }

    void Insert_After(int ele, int after)
    {
        if(start!=null){
            node curr;
            curr = start;
            while(curr!=null && curr.data!=after)
                curr = curr.next;
            if(curr!=null) // curr.data==after ... we found the element
            {
                node temp = new node();
                temp.data= ele;
                temp.prev =curr;
                temp.next = curr.next;
                if(curr.next!=null)
                    curr.next.prev = temp;
                curr.next = temp;
            }
            else // curr == null... reached to the end of the list
                System.out.println("Element not found\n");
        }
        else
            System.out.println("List is empty\n");
    }

    void Insert_Before(int ele, int before)
    {

    }


    int Delete_Beg()
    {


        return x;
    }

    int Delete_End()
    {

        return x;
    }

    void Delete_Spec(int ele)
    {

    }


    void travel_backward()
    {
        node curr;
        curr = start;
        if(start!=null)
        {
            while(curr.next!=null)
                curr = curr.next;
            while(curr!=null)
            {
                System.out.println(curr.data);
                curr = curr.prev;
            }
        }

    }
    
    void travel_forward()
    {
        node curr;
        curr=start;
        while(curr!=null)
        {
            System.out.println(curr.data);
            curr = curr.mext;
        }

    }

} 


public class dll_operations
{
     public static void main(String[] args) {
    
        


    }
}



