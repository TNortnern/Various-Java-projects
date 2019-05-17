public class TestBread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	TestSandwichFilling dc = new TestSandwichFilling();
    	TestSandwich ol = new TestSandwich();
       System.out.println(Bread.MOTTO);
       Bread bread1 = new Bread("Rye", 5);
       bread1.printBread();

       //should be an invalid statement:
       //Bread bread2 = new Bread();

       Bread bread2 = new Bread("White", 25);
       bread2.printBread();

       Bread bread3 = new Bread("Wheat", 15);
       bread3.printBread();
       dc.printMoreSandwiches();
       ol.print3Sandwiches();

    }

}
