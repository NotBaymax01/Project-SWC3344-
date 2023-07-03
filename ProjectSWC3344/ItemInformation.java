public class ItemInformation{
    protected int itemId;
    protected String itemName;
    protected double itemPrice;
    protected String datePurchase;
    protected double totalPrice = 0;
    
    //a constructor without parameter
    public ItemInformation()
    {
        itemId = 0;
        itemName = "";
        itemPrice = 0;
        datePurchase = "";
    }
    
    //a constructor with parameter
    public ItemInformation(int itemId,String itemName,double itemPrice, String datePurchase) 
    {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.datePurchase = datePurchase;
    }
    
    //mutator for all attributes
    public void setIteminformation(int itemId,String itemName,double itemPrice, String datePurchase)
    {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.datePurchase = datePurchase;
    }
    
    //mutator for each attributes
    public void setitemId(int iId)
    {
        itemId=iId;
    }
    
    public void setitemName(String iN)
    {
        itemName=iN;
    }
    
    public void setitemPrice(double iP)
    {
        itemPrice=iP;
    }
    
    public void setdatePurchase (String dP)
    {
        datePurchase=dP;
    }
    
    //accessor method for each attributes
    public int getItemId(){
        return itemId;
    }
    
    public String getItemName(){
        return itemName;
    }
    
    public double getItemPrice(){
        return itemPrice;
    }
    
    public String getDatePurchase(){
        return datePurchase;
    }
    
    public double totalPrice()
    {
        totalPrice = totalPrice + itemPrice;
        return totalPrice;
    }
    //Find the Iteminformation Id for a Iteminformation Name for a Iteminformation Price for a datePurchase
}