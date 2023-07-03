import java.util.*;

public class CustomerInformation{
    protected int custId;
    protected long custIC;
    protected int counterPaid;
    protected LinkedList<ItemInformation> itemPurchase;
    
    
    //a constructor without parameter
    public CustomerInformation()
    {
        custId = 0;
        custIC = 0;
        counterPaid = 0;
        itemPurchase = new LinkedList<>();
    }
    //write a constructor with parameter
    public CustomerInformation(int custId,Long custIC,int counterPaid) 
    {
        this.custId = custId;
        this.custIC = custIC;
        this.counterPaid = counterPaid;
    }
    
    //mutator for all attributes
    public void setCustomerinformation(int custId,Long custIC,int counterPaid,LinkedList<ItemInformation> itemPurchase)
    {
        this.custId = custId;
        this.custIC = custIC;
        this.counterPaid = counterPaid;
        this.itemPurchase = new LinkedList<>();
    }
    
    //mutator for each attributes
    public void setcustId(int cId)
    {
        custId=cId;
    }
    
    public void setcustIC(Long cIC)
    {
        custIC=cIC;
    }
    
    public void setcounterPaid(int cP)
    {
        counterPaid=cP;
    }
    
    public void setItemPurchase(LinkedList<ItemInformation> iP)
    {
        itemPurchase = iP;
    }
    
    //accessor method for each attributes
    public int getcustId(){
        return custId;
    }
    
    public Long getcustIC(){
        return custIC;
    }
    
    public int getcounterPaid(){
        return counterPaid;
    }
    
    public LinkedList<ItemInformation> getItemPurchase() {
        return itemPurchase;
    }
    //Find the customerinformation Id for a customerinformation IC for a counterPaid
}