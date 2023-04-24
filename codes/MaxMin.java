package mac190.maxmin;
/*
 * Design, code and test a class MaxMin that has the following properties: 
 * 1- two integer private members, min and max, where max >= min at all times
 * 2- default constructor that sets both to 0
 * 3- A constructor that accepts one integer and sets both to that integer 
 * 4- A constructor that accepts two integers and sets Max to the maximum 
 * of the two and min to the minimum of the two
 * 5- getters
 * 6- setters. If you try to set Max to a smaller value than min then max should 
 * be set to min and min should be set to the new value 
 * If you try to set min to a value greater than max, then min should be set to max
 * and max should be set to the new value
 * -7 String toString() that returns min and max values in a string 
 * -8 boolean equals(MaxMin m) return true if both max and min of this and m are equal, false 
 * otherwise
 * -9 public MaxMin add(int a) returns a MaxMin objects where max and min are same 
 * as this augmented with a
 * -10 public MaxMin add(MaxMin m) returns an object MaxMin that is the sum of this and m
 * -11 public MaxMin multiply(int a) return MaxMin object that is this multiplied by a. 
 * Remember if you multiply by negative number, max and min change order 
 * -Test your class, all your methods, constructors etc with appropriate variables/values 
 * of your choice.
 * 
 * 
 */

 public class MaxMin {
    //privatizing max and min.
    private int max, min;
   public MaxMin() {
    //default int to 0.
    max=0;
    min=0;
   }
   public MaxMin(int Brady) {
    // create a constructor that accepts one integer and set max and min to the one integer.
    min = Brady;
    max = Brady;
   }
    
   public MaxMin(int b, int c){
    /*A constructor that accepts two integers. If b does equal to c, then the b and c
    * will just have the same value.  
    */
    if (b>c){
        max=b;
        min=c;
    }
    else {
        min = b;
        max = c;
    }}
    //creating the getters here.
   public int getMax() {
        return max;
    }
    
    public int getMin() {
        return min;
    }
    // create setters
    public void setMax(int input) {
        if (input < min) {
            max = min;
            min = input;
        } else {
            max = input;
        }
    }

    public void setMin(int input) {
        if (input > max) {
            min = max;
            max = input;
        } else {
            min = input;
        }
    }

    @Override //Override is to over write the toString method to the superclass.
    public String toString() {
        return "Min: " + min + " Max: " + max;
    }

    // Takes in another MaxMin object
    // returns true if and only if the mins and maxes of the other MaxMin object matches the mins and maxes of this object
    public boolean equals(MaxMin otherMaxMinObject) { 
        if ((otherMaxMinObject.getMax() == this.getMax()) && (otherMaxMinObject.getMin() == this.getMin())) { //this is reffering to itself
            return true;
        } else {
            return false;
        }
    }

    public MaxMin add(int a) {
        return new MaxMin(max + a, min + a);
    }

    public MaxMin add(MaxMin m) {
        return new MaxMin(max + m.getMax(), min + m.getMin());
    }

    public MaxMin multiply(int a) {
        return new MaxMin(max * a, min * a);
    }

    public static void main(String args[]) {
        //==========================================================
        // Default constructor that sets both min and max to 0
        MaxMin defaultConstructorTest = new MaxMin();
        System.out.println(defaultConstructorTest.toString());

        //==========================================================
        // Constructor that accepts one integer and sets both max and min to that integer
        MaxMin singleArgumentConstructorTest = new MaxMin(8);
        System.out.println(  singleArgumentConstructorTest.toString());

        //==========================================================
        // A construtor that accepts two integers and sets Max to the maximum of the two and min to the minimum 
        MaxMin doubleConstructorTest1 = new MaxMin(3, 5);
        System.out.println( doubleConstructorTest1.toString());

        MaxMin doubleConstructorTest2 = new MaxMin(5, 3);
        System.out.println(  doubleConstructorTest2.toString());

        //==========================================================
        // Test the getters
        MaxMin getterTest = new MaxMin(8, 9);
        System.out.println("Get the maximum of (8,9): " + getterTest.getMax());
        System.out.println("Get the minimum of (8,9): " + getterTest.getMin());

        //==========================================================
        // Test the setters
        MaxMin setterTest = new MaxMin(15, 4);
        
        setterTest.setMax(20);
        System.out.println( setterTest.toString());

        setterTest.setMin(7);
        System.out.println(  setterTest.toString());

        setterTest.setMax(5);
        System.out.println( setterTest.toString());

        setterTest.setMin(30);
        System.out.println(  setterTest.toString());

        //==========================================================
        // Test equals method
        MaxMin equalsTest1 = new MaxMin(8,9);
        MaxMin equalsTest2 = new MaxMin(8,9);
        MaxMin equalsTest3 = new MaxMin(11,13);

        System.out.println( equalsTest1.equals(equalsTest2));
        System.out.println( equalsTest1.equals(equalsTest3));

        //==========================================================
        // Test add methods
        MaxMin addTest1 = new MaxMin(2,4);
        MaxMin addTest2 = new MaxMin(3,5);

        System.out.println(  addTest1.add(4).toString());
        System.out.println( addTest1.add(addTest2).toString());

        //==========================================================
        // Test multiply method
        MaxMin multiplyTest1 = new MaxMin(4,5);
        MaxMin multiplyTest2 = new MaxMin(6,5);

        System.out.println(  multiplyTest1.multiply(5).toString());
        System.out.println( multiplyTest2.multiply(-2).toString());
    }
}
