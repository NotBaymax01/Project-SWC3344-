import java.util.*;
import java.io.*;

public class HyperMarketCounter 
{
    public static void main(String[] args) throws IOException 
    {
        // declare & create a new LinkedList
        LinkedList<CustomerInformation> customerList = new LinkedList<>();

        // create 4 queues
        CustomQueue counter1Queue = new CustomQueue();
        CustomQueue counter2Queue = new CustomQueue();
        CustomQueue counter3Queue = new CustomQueue();

        Stack<CustomerInformation> completeStack = new Stack<>();

        // declare and create object
        CustomerInformation cust;
        ItemInformation item;

        // to get Customer Information
        try 
        {
            // Read from customer.txt file
            BufferedReader data = new BufferedReader(new FileReader("customers.txt"));

            String indata; // declare indata (a line input file)

            while ((indata = data.readLine()) != null) 
            {
                StringTokenizer st = new StringTokenizer(indata, ";");
                int custId = Integer.parseInt(st.nextToken());
                long custIc = Long.parseLong(st.nextToken());
                int counterPaid = Integer.parseInt(st.nextToken());

                // invoke constructor with parameter of CustomerInformation
                cust = new CustomerInformation(custId, custIc, counterPaid);

                StringTokenizer s2 = new StringTokenizer(st.nextToken(), ":");
                LinkedList<ItemInformation> itemList = new LinkedList<>();
                while (s2.hasMoreTokens()) 
                {
                    StringTokenizer s3 = new StringTokenizer(s2.nextToken(), ",");
                    int itemId = Integer.parseInt(s3.nextToken());
                    String itemName = s3.nextToken();
                    double itemPrice = Double.parseDouble(s3.nextToken());
                    String datePurchase = s3.nextToken();
                    
                    item = new ItemInformation(itemId, itemName, itemPrice, datePurchase);
                    itemList.add(item);

                }
                cust.setItemPurchase(itemList);
                // add cust into LinkedList(customerList)
                customerList.add(cust);
            }

            data.close();

            //to insert data from customerList into queue
            int customerCount = 0;
            for (int i = 0; i < customerList.size(); i++) 
            {
                cust = customerList.get(i);

                //to get the number of item bought by each customer
                int itemSize = cust.getItemPurchase().size();

                if (itemSize <= 5) 
                {
                    customerCount++;
                    if (customerCount % 2 != 0) 
                    {
                        counter1Queue.enqueue(cust);
                        cust.setcounterPaid(1);
                    } else 
                    {
                        counter2Queue.enqueue(cust);
                        cust.setcounterPaid(2);
                    }
                } else 
                {
                    counter3Queue.enqueue(cust);
                    cust.setcounterPaid(3);
                }
            }
            
            //create a temporary queue between counterQueue and CompleteStack
            CustomQueue waitingQueue = new CustomQueue();
            
            //to make first 5 customer from counter1 first follow by counter2 and counter3
            while (!counter1Queue.empty() || !counter2Queue.empty() || !counter3Queue.empty()) {
                for (int i = 0; i < 5; i++) {
                    if (!counter1Queue.empty()) {
                        cust = (CustomerInformation) counter1Queue.dequeue();
                        waitingQueue.enqueue(cust);
                        customerCount++;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    if (!counter2Queue.empty()) {
                        cust = (CustomerInformation) counter2Queue.dequeue();
                        waitingQueue.enqueue(cust);
                        customerCount++;
                    }
                }
                    for (int i = 0; i < 5; i++) {
                    if (!counter3Queue.empty()) {
                        cust = (CustomerInformation) counter3Queue.dequeue();
                        waitingQueue.enqueue(cust);
                        customerCount++;
                    }
                }

                while (!waitingQueue.empty()) {
                    cust = (CustomerInformation) waitingQueue.dequeue();
                    completeStack.push(cust);
                }
            }
            
            // display customer information
            while (!completeStack.isEmpty()) 
            {
                double totalPrice = 0;
                cust = completeStack.pop();
                System.out.println("============================================================================================================");
                System.out.println("\t\t\t\t Customer Information");
                System.out.println("Customer ID:" + cust.getcustId() + "\t\tCustomer IC:" + cust.getcustIC() + "\t\tCounter Paid:" + cust.getcounterPaid());
                System.out.println("============================================================================================================");
                System.out.println("\t\t\t\t Item Bought");
                for (int j = 0; j < cust.getItemPurchase().size(); j++)
                {
                    ItemInformation itemInfo = cust.getItemPurchase().get(j);
                    System.out.printf("itemId: %2d\titemName: %-20s\titemPrice: RM%.2f\tdatePurchase: %s%n",itemInfo.getItemId(), itemInfo.getItemName(), itemInfo.getItemPrice(), itemInfo.getDatePurchase());
                    totalPrice = totalPrice + itemInfo.getItemPrice();
                }
                System.out.println("============================================================================================================");
                System.out.printf("Total Price: RM%.2f", totalPrice);
                System.out.println();
                System.out.println("============================================================================================================");
                System.out.println();
            }
        } catch (FileNotFoundException fnfe) 
        {
            System.out.println("File not found!");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}