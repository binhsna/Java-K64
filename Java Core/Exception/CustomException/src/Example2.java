
class InvalidProductException extends Exception {
    public InvalidProductException(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}

class Example2 {
    void productCheck(int weight) throws InvalidProductException {
        if (weight < 100) {
            throw new InvalidProductException("Product Invalid");
        }
    }

    public static void main(String args[]) {
        Example2 obj = new Example2();
        try {
            obj.productCheck(60);
        } catch (InvalidProductException ex) {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage());
        }
    }
}